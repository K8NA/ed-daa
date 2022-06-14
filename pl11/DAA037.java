import java.util.*;

class Node {
  public double x;
  public double y;
  public int index;

  Node(double x, double y, int index) {
      this.x = x;
      this.y = y;
      this.index = index;
  }
}

class Edge implements Comparable<Edge> {
  double weight;
  int start, end;

  Edge(int start, int end, double weight) {
      this.start = start;
      this.end = end;
      this.weight = weight;
  }

  public int compareTo(Edge e) {
      if (weight < e.weight)
          return -1;
      return 1;
  }
}

 class UnionFind {
  int[] parent;
  public UnionFind(int size) {
    parent = new int[size];
    for (int i=0; i<size; i++)
      parent[i] = i;
  }
  public int find(int x) {
    if (parent[x] == x) return x;
    return parent[x] = find(parent[x]);
  }
  public void union(int x, int y) {
    parent[find(x)] = find(y);
  }
  public boolean sameSet(int x, int y) {
    return find(x) == find(y);
  }
}

class Kruskal {
  PriorityQueue<Edge> edges;
  UnionFind unionFind;
  double totalWeight;
  int numNodes;

  Kruskal(PriorityQueue<Edge> edges, int numNodes) {
    this.numNodes = numNodes;
    this.edges = edges;
    this.unionFind = new UnionFind(numNodes);
    this.totalWeight = 0;
  }

  void kruskal() {
    while(!edges.isEmpty()) {
      Edge edge = edges.poll();
      if(!unionFind.sameSet(edge.start, edge.end)) {
        totalWeight += edge.weight;
        unionFind.union(edge.start, edge.end);
      }
    }
    System.out.printf("%.2f\n", totalWeight);
  }
}

public class DAA037 {

  static double distance(double x1, double x2, double y1, double y2) {
    return Math.sqrt((x1 - x2)*(x1 - x2) + (y1 - y2) * (y1 - y2));
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    ArrayList<Node> nodes = new ArrayList<>(n);
    PriorityQueue<Edge> edges = new PriorityQueue<>();

    for (int i=0; i<n; i++)
      nodes.add(new Node(in.nextDouble(), in.nextDouble(), i));

    for (int i=0; i<n; i++) {
      for (int j=i+1; j<n; j++) {
        Node n1 = nodes.get(i);
        Node n2 = nodes.get(j);
        if (i != j) {
          double distance = distance(n1.x, n2.x, n1.y, n2.y);
          edges.add(new Edge(Math.min(n1.index, n2.index), Math.max(n1.index, n2.index), distance));
        }
      }
    }
    Kruskal k = new Kruskal(edges, n);
    k.kruskal();
  }
}
