
import java.util.Scanner;

// Estrutura para representar um no da arvore
class Node {
    boolean isBlack;  // No preto?
    boolean isNull;   // No nulo?
    int value;        // Valor
    Node left, right; // Filhos

    Node (int v) {
      isNull  = (v==0);
      isBlack = (v>=0);
      value   = Math.abs(v);
    }
}

public class DAA022 {

    // Ler input em preorder
    static Node readPreOrder(Scanner in) {
    	int v = in.nextInt();
    	Node aux = new Node(v);
    	if (v!=0) {
  	    aux.left  = readPreOrder(in);
  	    aux.right = readPreOrder(in);
    	}
    	return aux;
    }

    // Menor valor da arvore
    static int minimum(Node t) {
    	if (t.isNull) return Integer.MAX_VALUE;
    	int minLeft  = minimum(t.left);
    	int minRight = minimum(t.right);
    	return Math.min(t.value, Math.min(minLeft, minRight));
    }

    // Maior valor da arvore
    static int maximum(Node t) {
    	if (t.isNull) return Integer.MIN_VALUE;
    	int minLeft  = maximum(t.left);
    	int minRight = maximum(t.right);
    	return Math.max(t.value, Math.max(minLeft, minRight));
    }

    // Quantidade de nos (internos)
    static int size(Node t) {
    	if (t.isNull) return 0;
    	return 1 + size(t.left) + size(t.right);
    }

    static int alturaBlack(Node t) {
      int count = 0;
      while (!t.isNull) {
        t = t.left;
        if (t.isBlack) count++;
      }
      return count;
    }

    static boolean binaryTree(Node t, int min, int max) {
      if (t.isNull) return true;
      if (t.value < min || t.value > max) return false;
      return binaryTree (t.left, min, t.value-1) &&
             binaryTree (t.right, t.value+1, max);
    }

    static boolean rootProperty(Node root) {
      if (root.isBlack) return true;
      return false;
    }

    static boolean redProperty(Node t) {
      if (t.isNull) return true;
      if (!t.isBlack) {
        if (!t.left.isNull && !t.left.isBlack) return false;
        if (!t.right.isNull && !t.right.isBlack) return false;
      }
      return redProperty(t.left) && redProperty(t.right);
    }

    static boolean blackProperty(Node t, int altBlack, int count) {
      if (t.isNull) return count == altBlack;
      if (t.isBlack) count++;
      return blackProperty(t.left, altBlack, count) && blackProperty(t.right, altBlack, count);
    }

    // ---------------------------------------------------

    public static void main(String args[]) {
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	for (int i=0; i<n; i++) {
  	    Node root = readPreOrder(in);
        int altBlack = alturaBlack(root);
        if (
          binaryTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE) &&
          rootProperty(root) &&
          redProperty(root) &&
          blackProperty(root, altBlack, 0)
        ) System.out.println("SIM");
        else System.out.println("NAO");
    	}
    }
}
