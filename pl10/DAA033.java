// Dado um mapa de de estradas, a localização duma casa e a das aulas teóricas,
// escrever um programa indicando qual a distância mínima desde a casa até às aulas.

import java.lang.*;
import java.io.*;
import java.util.*;

// Classe que representa uma aresta
class Edge {
    int to;     // No destino
    float weight; // Peso da aresta

    Edge(int t, float w) {
    	to = t;
    	weight = w;
    }
}

// Classe que representa um no
class Node {
    public LinkedList<Edge> adj; // Lista de adjacencias
    public boolean visited;      // No ja foi visitado?
    public float distance;         // Distancia ao no origem da pesquisa

    Node() {
	     adj = new LinkedList<>();
    }
};

// Classe que representa um no para ficar na fila de prioridade
class NodeQ implements Comparable<NodeQ> {
    public float cost;
    public int node;

    NodeQ(float c, int n) {
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

    void addLink(int a, int b, float c) {
	     nodes[a].adj.add(new Edge(b, c));
    }

    // Algoritmo de Dijkstra
    void dijkstra(int s) {

    	//Inicializar nos como nao visitados e com distancia infinita
    	for (int i=1; i<=n; i++) {
    	    nodes[i].distance = Integer.MAX_VALUE;
    	    nodes[i].visited  = false;
    	}

    	// Inicializar "fila" com no origem
    	nodes[s].distance = 0;
    	TreeSet<NodeQ> q = new TreeSet<>();
    	q.add(new NodeQ(0, s)); // Criar um par (dist=0, no=s)

    	// Ciclo principal do Dijkstra
    	while (!q.isEmpty()) {

	      // Retirar no com menor distancia (o "primeiro" do set, que e uma BST)
  	    NodeQ nq = q.pollFirst();
  	    int    u = nq.node;
  	    nodes[u].visited = true;

  	    // Relaxar arestas do no retirado
  	    for (Edge e : nodes[u].adj) {
      		int v = e.to;
      		float cost = e.weight;
      		if (!nodes[v].visited && nodes[u].distance + cost < nodes[v].distance) {
      		    q.remove(new NodeQ(nodes[v].distance, v)); // Apagar do set
      		    nodes[v].distance = nodes[u].distance + cost;
      		    q.add(new NodeQ(nodes[v].distance, v));    // Inserir com nova (e menor) distancia
      		}
	      }
	    }
      System.out.printf("%.1f\n", nodes[2].distance);
    }
};


public class DAA033 {
  public static void main(String args[]) {
  Scanner in = new Scanner(System.in);

  Graph g = new Graph(in.nextInt());
  int   e = in.nextInt();
  in.nextLine();
  String s[] = in.nextLine().split(" "); //origem e destino
  TreeMap <String,Integer> roads = new TreeMap<String,Integer>(); //mapa das estradas
  int places = 0;
  roads.put(s[0], ++places);
  roads.put(s[1], ++places);

  for (int i=0; i<e; i++) {
    String[] map = in.nextLine().split(" ");
    int pointA, pointB;

    if(!roads.containsKey(map[0])) {
      pointA = ++places;
      roads.put(map[0], pointA);
    } else pointA = roads.get(map[0]);

    if(!roads.containsKey(map[1])) {
      pointB = ++places;
      roads.put(map[1], pointB);
    } else pointB = roads.get(map[1]);

    g.addLink(pointA, pointB, Float.parseFloat(map[2]));
    g.addLink(pointB, pointA, Float.parseFloat(map[2]));
  }

    // Execucao a partir do no origem
    g.dijkstra(1);
  }
}
