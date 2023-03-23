
public class SinglyLinkedList<T> {
   private Node<T> first;    // Primeiro no da lista
   private int size;         // Tamanho da lista

   // Construtor (cria lista vazia)
   SinglyLinkedList() {
      first = null;
      size = 0;
   }

   // Retorna o tamanho da lista
   public int size() {
      return size;
   }

   // Devolve true se a lista estiver vazia ou falso caso contrario
   public boolean isEmpty() {
      return (size == 0);
   }

   // Adiciona v ao inicio da lista
   public void addFirst(T v) {
      Node<T> newNode = new Node<T>(v, first);
      first = newNode;
      size++;
   }

   // Adiciona v ao final da lista
   public void addLast(T v) {
      Node<T> newNode = new Node<T>(v, null);
      if (isEmpty()) {
         first = newNode;
      } else {
         Node<T> cur = first;
         while (cur.getNext() != null)
            cur = cur.getNext();
         cur.setNext(newNode);
      }
      size++;
   }

   // Remove o primeiro elemento da lista (se for vazia nao faz nada)
   public void removeFirst() {
      if (isEmpty()) return;
      first = first.getNext();
      size--;
   }

   // Remove o ultimo elemento da lista (se for vazia nao faz nada)
   public void removeLast() {
      if (isEmpty()) return;
      if (size == 1) {
         first = null;
      } else {
         // Ciclo com for e uso de de size para mostrar alternativa ao while
         Node<T> cur = first;
         for (int i=0; i<size-2; i++)
            cur = cur.getNext();
         cur.setNext(cur.getNext().getNext());
         // Tambem se poderia fazer cur.setNext(null);
      }
      size--;
   }

    // Retorna o primeiro valor da lista (ou null se a lista for vazia)
    public T getFirst() {
       if (isEmpty()) return null;
       return first.getValue();
    }

    // Retorna o ultimo valor da lista (ou null se a lista for vazia)
    public T getLast() {
       if (isEmpty()) return null;
       Node<T> cur = first;
       while (cur.getNext() != null)
          cur = cur.getNext();
       return cur.getValue();
    }

//----------------------------------------------------//

   //------ED188------//
    public T get(int pos) {
      if (isEmpty() || pos>= size) return null;
      Node<T> cur = first;
      for (int i=0; i<pos; i++)
        cur = cur.getNext();
      return cur.getValue();
    }

   //------ED189------//
   public T remove(int pos) {
     if (pos<0 || pos>= size) return null;
     T ans;
     if (pos == 0) {
       ans = getFirst();
       removeFirst();
     } else {
       Node<T> cur = first;
       for (int i=0; i<pos-1; i++)
         cur = cur.getNext();
       ans = cur.getNext().getValue();
       cur.setNext(cur.getNext().getNext());
       size--;
     }
     return ans;
   }

   //------ED190------//
   public SinglyLinkedList<T> copy() {
     SinglyLinkedList<T> newList = new SinglyLinkedList<T>();
     Node<T> cur = first;
     for (int i=0; i<size; i++) {
       newList.addLast(cur.getValue());
       cur = cur.getNext();
     }
     return newList;
   }

   //------ED191------//
   public void duplicate() {
     Node<T> cur = first;
     while (cur != null) {
       Node<T> newnode = new Node<T>(cur.getValue(), cur.getNext());
       cur.setNext(newnode);
       size++;
       cur = cur.getNext().getNext();
     }
   }

   //------ED192------//
   public int count(T value) {
     if (isEmpty()) return 0;
     Node<T> cur = first;
     int counter = 0;
     while (cur != null) {
       if (cur.getValue().equals(value)) counter++;
       cur = cur.getNext();
     }
     return counter;
   }

   //------ED193------//
   public void removeAll(T value) {
     while (!isEmpty() && first.getValue().equals(value))
        removeFirst();
     Node<T> cur = first;
     while (cur != null && cur.getNext() != null) {
    	 if (cur.getNext().getValue().equals(value)) {
    	    cur.setNext(cur.getNext().getNext());
          size--;
       } else
          cur = cur.getNext();
     }
   }

   //------ED232.1------//
   public SinglyLinkedList<T> reverse() {
     SinglyLinkedList<T> newList = new SinglyLinkedList<T>();
     Node<T> cur = first;
     for (int i=0; i<size; i++) {
       newList.addFirst(cur.getValue());
       cur = cur.getNext();
     }
     return newList;
   }

   //------ED232.2------//
   //Devolve array com as posições de todas as ocorrências por ordem crescente
   public int[] occurrences(T elem) {
     if (isEmpty()) return null;
     int count = count(elem);
     if (count == 0) return null;
     Node<T> cur = first;
     int[] occ = new int[count];
     int pos = 0;
     for (int i=0; i<size; i++) {
       if (cur.getValue().equals(elem)) {
         occ[pos] = i;
         pos++;
       }
       cur = cur.getNext();
     }
     return occ;
   }

   //------ED232.3------//
   public void remove(SinglyLinkedList<T> toRemove) {
     if(toRemove.isEmpty()) return;
     Node<T> cur = toRemove.first;
     while (cur != null) {        // percorre a lista toRemove
       removeAll(cur.getValue()); // chama removeAll para cada valor
       cur = cur.getNext();
     }
   }

   //------ED236.1------//
   public SinglyLinkedList<T> cut(int a, int b) {
     SinglyLinkedList<T> newList = new SinglyLinkedList<T>();
     Node<T> cur = first;
     for(int i=0; i<=b; i++) {
       if (i>=a)
         newList.addLast(cur.getValue());
       cur = cur.getNext();
     }
     return newList;
   }

   //------ED236.2-rotating right-----//
   public void shift(int k) { //efficiency problem
     for (int i=0; i<k; i++) {
       addFirst(getLast());
       removeLast();
     }
   }

   //------------aula 6 extras------------//

   // Devolve a posição da primeira ocorrência
   public int indexOfFirst(T elem) {
    int index = 0;
    Node<T> cur = first;
    while (cur != null) {
      if (cur.getValue().equals(elem))
        return index;
      index++;
      cur = cur.getNext();
    }
    return -1;
  }

   //Devolve a posição da ultima ocorrência
   public int indexOfLast(T elem) {
     int index = -1;
     int count = 0;
     Node<T> cur = first;
     for (int i=0; i<size(); i++) {
       if (cur.getValue().equals(elem))
         index = count;
       count++;
       cur = cur.getNext();
      }
      return index;
   }

   //Retira todos os elementos numa posicao impar
   public void removeOdd() {
     if (isEmpty()) return;
     Node<T> node = first.getNext().getNext();
     Node<T> cur = first;
     for (int i=0; i<size()-2; i++) {
       if(i % 2 != 0 && i<size()) {
         cur.setNext(node);
         cur = cur.getNext();
         node = node.getNext().getNext();
         size--;
       }
       else {
         cur = cur.getNext();
         node = node.getNext();
       }
     }
   }

   //Retira todos os elementos numa posição par
   public void removeEven() {
     
   }

   //Junta duas listas
   public void concat() {

   }


   // Converte a lista para uma String
    public String toString() {
      String str = "{";
      Node<T> cur = first;
      while (cur != null) {
         str += cur.getValue();
         cur = cur.getNext();
         if (cur != null) str += ",";
      }
      str += "}";
      return str;
    }
}
