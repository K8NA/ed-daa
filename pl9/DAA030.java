// Dado um grafo conexo não dirigido e não pesado descrevendo uma rede biológica,
// calcular o seu diâmetro, raio, nós centrais e quais os nós periféricos.

import java.util.*;
import java.io.*;

public class DAA030 {
    public static int MAX = 1500;
    public static int matriz[][] = new int[MAX+1][MAX+1];

    static class Node {
        public LinkedList<Integer> adj;  // Lista de adjacencias
        public boolean visited;      // Valor booleano que indica se foi visitado numa pesquisa
        public int distance;         // Distancia ao no origem da pesquisa

        Node() {
          adj = new LinkedList<Integer>();
        }
    }

    static class Graph {
        int n;          // Numero de nos do grafo
        Node nodes[];    // Array para conter os nos

        Graph(int n) {
            this.n = n;
            nodes = new Node[n+1];  // +1 se os comecam em 1 ao inves de
            for (int i=1; i<=n; i++)
	            nodes[i] = new Node();
        }

        public void addLink(int a, int b) {
            nodes[a].adj.add(b);
            nodes[b].adj.add(a);
        }

        public void bfs(int v) {
            LinkedList<Integer> q = new LinkedList<Integer>();
            for (int i=1; i<=n; i++)
                nodes[i].visited = false;
            q.add(v);
            nodes[v].visited = true;
            nodes[v].distance = 0;
            matriz[v][v] = 0;

            while (q.size() > 0) {
              int u = q.removeFirst();
              for (int w : nodes[u].adj)
            		if (!nodes[w].visited) {
          		    q.add(w);
          		    nodes[w].visited  = true;
          		    nodes[w].distance = nodes[u].distance + 1;
                  matriz[v][w] = nodes[w].distance;
            		}
            }
        }
    }

    public static int excentricidade (int v, int n) {
      int max = 0;
      for (int i=1; i<=n; i++)
        if (max <= matriz[v][i])
          max = matriz[v][i];
      return max;
    }


    public static void main(String[] args){
      Scanner in = new Scanner(System.in);
      int a, b, exc;
      int diam = 0;
      int raio = Integer.MAX_VALUE;

      Set<Integer> centrais    = new TreeSet<Integer>(); //TreeSet sorts elements
      Set<Integer> perifericos = new TreeSet<Integer>();

      int n = in.nextInt();
      Graph g = new Graph(n);

      int e = in.nextInt();
      for (int i=0; i<e; i++) {
        a = in.nextInt();
        b = in.nextInt();
        g.addLink(a, b);
      }

      for (int i=1; i<=n; i++)
          g.bfs(i);

      for (int i=1; i<=n; i++) {
        exc = excentricidade(i,n);
        if (diam <= exc)
          diam = exc;
        if (raio >= exc)
          raio = exc;
       }
       System.out.println(diam);
       System.out.println(raio);

       for (int i=1; i<=n; i++) {
        exc = excentricidade(i,n);
        if (raio == exc)
          centrais.add(i);
        if (diam == exc)
          perifericos.add(i);
       }

       int count = 0;
       for (int i : centrais) {
         count++;
         if (centrais.size() == count)
           System.out.print(i);
         else
           System.out.print(i + " ");
       }
       System.out.println();

       count = 0;
       for (int i : perifericos) {
         count++;
         if (perifericos.size() == count)
           System.out.print(i);
         else
           System.out.print(i + " ");
       }
       System.out.println();
     }
}
