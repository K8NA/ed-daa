// -----------------------------------------------------------
// Estruturas de Dados 2020/2021 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados2021/
// -----------------------------------------------------------
// Exemplo de utilizacao da uma arvore binaria
// Ultima alteracao: 26/04/2018
// -----------------------------------------------------------

import java.util.Scanner;

public class Test {
   public static void main(String[] args) {
      // Ler arvore de inteiros em preorder
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      for (int i=0; i<n; i++) {
    	  int v = in.nextInt();
    	  BTree<Integer> t = LibBTree.readIntTree(in);
    	  //System.out.println("count = " + t.count());
    	  System.out.println("level(" + v + ") = " + t.level(v));
      }
   }
}
