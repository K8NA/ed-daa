
public class TestSinglyLinkedList {
   public static void main(String[] args) {

      // Criacao de lista de inteiros
      SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

      // Escrevendo lista (no inicio esta vazia)
      System.out.println(list);

      // Verificando se esta vazia
      System.out.println("isEmpty? " + list.isEmpty());

      // Adicionando numeros de 1 a 5 ao final da lista
      for (int i=1; i<=5; i++)
         list.addLast(i);
      System.out.println(list);

      // Adicionando numeros de 6 a 10 ao inicio da lista
      for (int i=6; i<=10; i++)
         list.addFirst(i);
      System.out.println(list);

      // Verificando o tamanho da lista
      System.out.println("size = " + list.size());

      // Retirando o primeiro elemento
      list.removeFirst();
      System.out.println(list);

      // Retirando o ultimo elemento
      list.removeLast();
      System.out.println(list);

      // Verificando se esta vazia
      System.out.println("isEmpty? " + list.isEmpty());

      // Escreve o primeiro e ultimo elementos
      System.out.println("getFirst() = " + list.getFirst());
      System.out.println("getLast() = " + list.getLast());

      //----------------//

      SinglyLinkedList<Character> vowelist = new SinglyLinkedList<Character>();

      char[] vowels = {'a', 'e', 'i', 'o', 'u'};

      for (int i=0; i<5; i++)
         vowelist.addLast(vowels[i]);

      System.out.println(vowelist);

      //----------------//

      SinglyLinkedList<Pair> intlist = new SinglyLinkedList<Pair>();

      for (int i=1; i<=3; i++) {
        for (int j=1; j<=3; j++) {
          Pair<Integer, Integer> ints = new Pair(i,j);
          ints.setFirst(i);
          ints.setSecond(j);
          intlist.addLast(ints);
        }
      }

      System.out.println(intlist);

      //----------------//

      System.out.println("\n//----------mooshakTests----------//");

      SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
      list1.addLast(2); list1.addLast(4);
      list1.addLast(6); list1.addLast(8);
      System.out.println("list1 = " + list1);
      // System.out.println("get 0 = " + list1.get(0));
      // System.out.println("remove 0 = " + list1.remove(0));
      // System.out.println("list1 = " + list1);
      // SinglyLinkedList<Integer> newList1 = list1.copy();
      // System.out.println("NewList1 = " + newList1);
      list1.duplicate();
      // System.out.println("dupl list1 = " + list1);
      // System.out.println("count 2 = " + list1.count(2));
      list1.removeAll(6);
      System.out.println("list1 = " + list1);

      SinglyLinkedList<Character> list2 = new SinglyLinkedList<>();
      list2.addLast('a'); list2.addLast('b');
      list2.addLast('c'); list2.addLast('d');
      //System.out.println("list2 = " + list2);
      // System.out.println("get 3 = " + list2.get(3));
      // System.out.println("remove 2 = " + list2.remove(2));
      // System.out.println("list2 = " + list2);
      // SinglyLinkedList<Character> newList2 = list2.copy();
      // System.out.println("newList2 = " + newList2);
      // list2.duplicate();
      // System.out.println("dupl list2 = " + list2);

      SinglyLinkedList<String> list3 = new SinglyLinkedList<>();
      list3.addLast("estruturas");
      list3.addLast("de"); list3.addLast("dados");
      //System.out.println("list3 = " + list3);
      // System.out.println("get 3 = " + list3.get(3));
      // System.out.println("remove 2 = " + list3.remove(2));
      // System.out.println("list3 = " + list3);
      // SinglyLinkedList<String> newList3 = list3.copy();
      // System.out.println("newList3 = " + newList3);
      // list3.duplicate();
      // System.out.println("dupl list3 = " + list3);

   }
}
