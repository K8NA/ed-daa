
// descobrir que cidades estão ligadas por voos, directamente/indirectamente,
// através de outros voos, passando por cidades intermédias

//Incompleto!
import java.util.*;

// Classe que representa um no
class Node {
    public LinkedList<Integer> adj; // Lista de adjacencias

    Node() {
		    adj = new LinkedList<>();
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

    void addLink(int a, int b) {
		    nodes[a].adj.add(b);
    }

    void floydWarshall() {
  		boolean connected[][] = new boolean[n+1][n+1];

  		for(int i=1; i<=n; i++)
  			Arrays.fill(connected[i], false);

  		for(int i=1; i<=n; i++) {
  			connected[i][i] = true;
  			for (int e : nodes[i].adj)
  				connected[i][e] = true;
      }

      for (int k=1; k<=n; k++)
  			for (int i=1; i<=n; i++)
  				for (int j=1; j<=n; j++)
  					  if (connected[i][k] && connected[k][j])
  					     connected[i][j] = true;

  		System.out.print(" ");
  		for (int i=1; i<=n; i++)
  			System.out.print(" " + (char)(i+64));

  		System.out.println();

  		for (int i=1; i<=n; i++) {
  			System.out.print((char)(i+64));
  			for (int j=1; j<=n; j++) {
          int result = 0;
          if (connected[i][j]) result = 1;
  				System.out.print(" " + result);
        }
        System.out.println();
      }
   }
}


public class DAA035 {
    public static void main(String args[]) {
    	Scanner in = new Scanner(System.in);

    	int v = in.nextInt(); //num cidades
    	Graph g = new Graph(v);
      in.nextLine();

    	for (int i=0; i<v; i++) {
  	    String[] s = in.nextLine().split(" ");
  	    int origem = (int)(s[0].charAt(0))-65;
  	    int e = Character.getNumericValue(s[1].charAt(0));
  	    for (int j=0; j<e; j++) {
    			int destino = (int)(s[j+2].charAt(0))-65;
    			g.addLink(origem+1, destino+1);
  	    }
    	}
    	g.floydWarshall();
  }
}
