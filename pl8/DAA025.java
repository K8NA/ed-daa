import java.util.*;
import java.io.*;

public class DAA025 {
  public static final int MAX = 101;

  static int n;              // Numero de nos do grafo
  static boolean adj[][];    // Matriz de adjacencias
  static boolean visited[];  // Que nos ja foram visitados?

  static void dfs(int v) {
    visited[v] = true;
    for (int i=1; i<=n; i++)
      if (adj[v][i] && !visited[i])
        dfs(i);
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int l, a, b;

    n = in.nextInt(); //pontos de contacto
    l = in.nextInt(); //ligacoes exictentes

    adj       = new boolean[MAX][MAX];
    visited   = new boolean[MAX];
    int redes = 0; //num de redes = componentes conexos

    for (int i=0; i<l; i++) {
      a = in.nextInt();
      b = in.nextInt();
      adj[a][b] = adj[b][a] = true;
    }

    for (int i=1; i<=n; i++) {
      if (!visited[i]) {
       redes++;
       dfs(i); // Pesquisa em profundidade a partir do no i
      }
    }
    System.out.println(redes);
  }
}
