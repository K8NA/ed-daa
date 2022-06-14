
import java.util.*;

// Classe que representa uma aresta
class Edge {
  int to;     // No destino
  int weight; // Peso da aresta

  Edge(int t, int w) {
    to = t;
    weight = w;
  }
}

// Classe que representa um no
class Node {
    public LinkedList<Edge> adj; // Lista de adjacencias
    public boolean visited;      // No ja foi visitado?
    public int distance;         // Distancia ao no origem da pesquisa

    Node() {
      adj = new LinkedList<>();
    }
};

// Classe que representa um no para ficar na fila de prioridade
class NodeQ implements Comparable<NodeQ> {
    public int cost;
    public int node;

    NodeQ(int c, int n) {
      cost = c;
      node = n;
    }

    @Override
    public int compareTo(NodeQ nq) {
      if (cost < nq.cost) return -1;
      if (cost > nq.cost) return +1;
      if (node < nq.node) return -1;
      if (node > nq.node) return +1;
      return 0;
    }
}

// Classe que representa um grafo
class Graph {
    int n;          // Numero de nos do grafo
    Node[] nodes;   // Array para conter os nos

    Graph(int n) {
     this.n = n;
     nodes = new Node[n+1];  // +1 se os nos comecam em 1 ao inves de 0
     for (int i=1; i<=n; i++)
       nodes[i] = new Node();
    }

    void addLink(int a, int b, int c) {
      nodes[a].adj.add(new Edge(b, c));
      nodes[b].adj.add(new Edge(a, c));
    }

    // Algoritmo Prim
    void prim(int s) {
     //Inicializar nos como nao visitados e com distancia infinita
     for (int i=1; i<=n; i++) {
       nodes[i].distance = Integer.MAX_VALUE;
       nodes[i].visited  = false;
     }
     // Inicializar "fila" com no origem
     nodes[s].distance = 0;
     TreeSet<NodeQ> q = new TreeSet<>();
     TreeSet<Integer> path = new TreeSet<>(); //ordena automaticamente
     q.add(new NodeQ(0, s)); // Criar um par (dist=0, no=s)

     int total = 0; //custo total do path

     // Ciclo principal do Prim
     while (!q.isEmpty()) {
       // Retirar no com menor distancia (o "primeiro" do set, que e uma BST)
       NodeQ nq = q.pollFirst();
       int    u = nq.node;
       nodes[u].visited = true;

       if (nodes[u].distance != 0)
         path.add(nodes[u].distance);

       total += nodes[u].distance;

       // Relaxar arestas do no retirado
       for (Edge e : nodes[u].adj) {
         int v = e.to;
         int cost = e.weight;
         if (!nodes[v].visited && cost < nodes[v].distance) {
           q.remove(new NodeQ(nodes[v].distance, v)); // Apagar do set
           nodes[v].distance = cost;
           q.add(new NodeQ(nodes[v].distance, v));    // Inserir com nova (e menor) distancia
         }
       }
     }
     FastPrint.out.println(total); 

     //arestas usadas para o path
     int aux = 0;
     for (Integer i : path) {
       if (aux == 0) FastPrint.out.print(i);
       else FastPrint.out.print(" " + i);
       aux = 1;
     }
     FastPrint.out.println();
  }
};


public class DAA038 {
  public static void main(String args[]) {
    FastScanner in = new FastScanner(System.in);
    int a = in.nextInt();
    int b = in.nextInt();
    int c = in.nextInt();
    Graph g = new Graph(a+b);

    for (int i=1; i<a; i++) //casas existentes
      g.addLink(i, i+1, 0);

    for (int i=0; i<c; i++) { //casas novas
      int x = in.nextInt();
      int y = in.nextInt();
      int p = in.nextInt();
      g.addLink(x, y, p);
    }

    g.prim(1);
    FastPrint.out.close();
 }
}
