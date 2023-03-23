// -----------------------------------------------------------
// Estruturas de Dados 2020/2021 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados2021/
// -----------------------------------------------------------
// Arvore binaria "normal"
// Ultima alteracao: 26/04/2018
// -----------------------------------------------------------

public class BTree<T> {
    private BTNode<T> root; // raiz da arvore

    // Construtor
    BTree() {
	     root = null;
    }

    // Getter e Setter para a raiz
    public BTNode<T> getRoot() {return root;}
    public void setRoot(BTNode<T> r) {root = r;}

    // Verificar se arvore esta vazia
    public boolean isEmpty() {
	     return root == null;
    }

    // --------------------------------------------------------

    // Numero de nos da arvore
    public int numberNodes() {
	     return numberNodes(root);
    }

    private int numberNodes(BTNode<T> n) {
	     if (n == null) return 0;
	     return 1 + numberNodes(n.getLeft()) + numberNodes(n.getRight());
    }

    // --------------------------------------------------------

    // Altura da arvore
    public int depth() {
      return depth(root);
    }

    private int depth(BTNode<T> n) {
    	if (n == null) return -1;
    	return 1 + Math.max(depth(n.getLeft()), depth(n.getRight()));
    }

    // --------------------------------------------------------

    // O elemento value esta contido na arvore?
    public boolean contains(T value) {
	    return contains(root, value);
    }

    private boolean contains(BTNode<T> n, T value) {
    	if (n==null) return false;
    	if (n.getValue().equals(value)) return true;
    	return contains(n.getLeft(), value) || contains(n.getRight(), value);
    }

    // --------------------------------------------------------

    // Imprimir arvore em PreOrder
    public void printPreOrder() {
    	System.out.print("PreOrder:");
    	printPreOrder(root);
    	System.out.println();
    }

    private void printPreOrder(BTNode<T> n) {
    	if (n==null) return;
    	System.out.print(" " + n.getValue());
    	printPreOrder(n.getLeft());
    	printPreOrder(n.getRight());
    }

    // --------------------------------------------------------

    // Imprimir arvore em InOrder
    public void printInOrder() {
    	System.out.print("InOrder:");
    	printInOrder(root);
    	System.out.println();
    }

    private void printInOrder(BTNode<T> n) {
    	if (n==null) return;
    	printInOrder(n.getLeft());
    	System.out.print(" " + n.getValue());
    	printInOrder(n.getRight());
    }

    // --------------------------------------------------------

    // Imprimir arvore em PostOrder
    public void printPostOrder() {
    	System.out.print("PostOrder:");
    	printPostOrder(root);
    	System.out.println();
    }

    private void printPostOrder(BTNode<T> n) {
    	if (n==null) return;
    	printPostOrder(n.getLeft());
    	printPostOrder(n.getRight());
    	System.out.print(" " + n.getValue());
    }

    // --------------------------------------------------------

    // Imprimir arvore numa visita em largura (usando TAD Fila)
    public void printBFS() {
    	System.out.print("BFS:");

    	MyQueue<BTNode<T>> q = new LinkedListQueue<BTNode<T>>();
    	q.enqueue(root);
    	while (!q.isEmpty()) {
    	    BTNode<T> cur = q.dequeue();
    	    if (cur != null) {
        		System.out.print(" " + cur.getValue());
        		q.enqueue(cur.getLeft());
        		q.enqueue(cur.getRight());
    	    }
    	}
    	System.out.println();
    }

    // --------------------------------------------------------

    // Imprimir arvore numa visita em profundidade (usando TAD Pilha)
    public void printDFS() {
    	System.out.print("DFS:");

    	MyStack<BTNode<T>> q = new LinkedListStack<BTNode<T>>();
    	q.push(root);
    	while (!q.isEmpty()) {
    	    BTNode<T> cur = q.pop();
    	    if (cur != null) {
        		System.out.print(" " + cur.getValue());
        		q.push(cur.getLeft());
        		q.push(cur.getRight());
    	    }
    	}
    	System.out.println();
    }

    // ------------------------------------------

    // Devolve a quantidade de nos que sao filhos unicos

    public int count() {
      return count(root);
    }

    private int count(BTNode<T> n) {
    	if (n == null) return 0;
    	int tmp = 0;
    	if ( (n.getLeft() == null && n.getRight() != null) ||
    	     (n.getLeft() != null && n.getRight() == null) )
    	   tmp = 1;

    	return tmp + count(n.getLeft()) + count(n.getRight());
    }


    // ------------------------------------------

    // Devolve o nivel mais baixo com um no de valor v
    public int level(T v) {
      int tmp = level(root, v, 0);
      if (tmp == Integer.MAX_VALUE) return -1;
      return tmp;
    }

    private int level(BTNode<T> n, T v, int l) {
    	if (n == null) return Integer.MAX_VALUE;
    	if (n.getValue().equals(v)) return l;
    	return Math.min(level(n.getLeft(), v, l+1), level(n.getRight(), v, l+1));
    }

    // ------------------------------------------

    //Devolve o numero de folhas da arvore

    public int numberLeafs() {
      int count=0;
      MyQueue<BTNode<T>> q = new LinkedListQueue<>();
      q.enqueue(root);
      while (!q.isEmpty()) {
        BTNode<T> cur = q.dequeue();
        if (cur != null && cur.getLeft() == null && cur.getRight() == null)
          count++;
        if (cur != null) {
          q.enqueue(cur.getLeft());
          q.enqueue(cur.getRight());
        }
      }
        return count;
    }

    // ------------------------------------------

    //Devolve true se a arvore for estritamente binaria, false caso contrario

    public boolean strict() {
      MyQueue<BTNode<T>> q = new LinkedListQueue<>();
      q.enqueue(root);
      while (!q.isEmpty()) {
        BTNode<T> cur = q.dequeue();
        if (cur != null) {
          if(cur.getLeft() != null && cur.getRight() == null)
            return false;
          if (cur.getLeft() == null && cur.getRight() != null)
            return false;
          q.enqueue(cur.getLeft());
          q.enqueue(cur.getRight());
        }
      }
        return true;
    }

    // ------------------------------------------

    //Devolve o valor guardado no caminho indicado pela string s

     public T path(String s) {
       if (s.equals("R"))
          return root.getValue();
       return path(root, s);
     }

     public T path(BTNode<T> n, String s) {
       if (s.length() == 0)
        return n.getValue();
       if (s.charAt(0) == 'E')
        return path(n.getLeft(), s.substring(1));
       if (s.charAt(0) == 'D')
        return path(n.getRight(), s.substring(1));
       return null;
     }

}















//
