// Dados vários grafos não dirigidos, 
// indicar se cada um deles é ou não bipartido.

import java.util.*;
import java.io.*;

public class DAA027 {
  static int MAX = 51;
  static int naoVis = 0;
  static int green = 1;
  static int red = 2;
  static int v, e, cor;
  static boolean adj[][] = new boolean[MAX][MAX];
  static int partido[] = new int[MAX];

  public static boolean partir(int a, int cor) {
    int newCor = (cor == green) ? red : green;
    if (partido[a] != naoVis) {
      if (partido[a] != newCor)
        return false;
      return true;
    }
    if (partido[a] == naoVis) {
      partido[a] = newCor;
      for (int i=0; i<v; i++)
        if (adj[a][i] == true)
          if (!partir(i, newCor))
            return false;
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt(); //num de casos

    for (int c=0; c<n; c++) {
      v = in.nextInt(); //num de nos
      e = in.nextInt(); //num de arestas
      for (int i=0; i<e; i++) {
        int a = in.nextInt();
        int b = in.nextInt();
        a--; b--;
        adj[a][b] = adj[b][a] = true;
      }

      boolean bipartido = partir(0, green);
      if (bipartido)
        System.out.println("sim");
      else
        System.out.println("nao");

      //reset
      for (int j=0; j<v; j++) {
        for (int k=0; k<v; k++)
          adj[j][k] = false;
        partido[j] = naoVis;
      }
    }
  }
}
