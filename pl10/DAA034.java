// verificar a existencia dos ciclos negativos 

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
}

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
    int edges;
    Node[] nodes;   // Array para conter os nos

    Graph(int n, int e) {
    	this.n = n;
      edges  = e;
    	nodes = new Node[n+1];  // +1 se os nos comecam em 1 ao inves de 0
    	for (int i=1; i<=n; i++)
	      nodes[i] = new Node();
    }

    void addLink(int a, int b, int c) {
	     nodes[a].adj.add(new Edge(b, c));
    }

    int bellmanFord(int s) {
      for (int i=1; i<=n; i++)
        nodes[i].distance = Integer.MAX_VALUE/2; //para evitar overflow

      for (int i=1; i<n; i++) {
  			for (int j=1; j<=n; j++) {
  				for (Edge e : nodes[j].adj) {
            int v    = e.to;
            int cost = e.weight;
  					if (nodes[j].distance + cost < nodes[v].distance)
  						nodes[v].distance = nodes[j].distance + cost;
  				}
			  }
      }

      for (int j=1; j<=n; j++) {
  			for (Edge e : nodes[j].adj) {
  				int v    = e.to;
  				int cost = e.weight;
  				if (nodes[j].distance + cost < nodes[v].distance)
  					return -1;
  			}
  		}
  	  return 0;
    }
}


public class DAA034 {
    public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in. nextInt();

		for (int i=0; i<n; i++) {
			int v = in.nextInt();  //sistemas estrelares
			int e = in.nextInt();  //buracos negros
			Graph g = new Graph(v, e);

  		for (int j=0; j<e; j++)
  			g.addLink(in.nextInt()+1, in.nextInt()+1, in.nextInt());

      if (g.bellmanFord(1) == 0)
        System.out.println("impossivel");
      else
        System.out.println("possivel");
    }
  }
}
