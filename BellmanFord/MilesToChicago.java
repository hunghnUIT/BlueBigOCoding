package BellmanFord;

import java.util.*;

public class MilesToChicago {
  static class Edge {
    public int source;
    public int target;
    public double weight;
  
    public Edge(int s, int t, double w) {
      this.source = s;
      this.target = t;
      this.weight = w;
    }
  }
  static class Node implements Comparable<Node> {
    public Integer id;
    public Double dist;
    public Node(Integer id, double dist) {
      this.id = id;
      this.dist = dist;
    }
  
    @Override
    public int compareTo(Node other) {
      return other.dist.compareTo(this.dist);
    }
  }
  public static final int INF = (int)1e9;
  private static int n, m;
  private static ArrayList<Edge> graph;
  private static ArrayList<ArrayList<Node>> dijkstraGraph;

  private static double[] dist;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    while (n != 0) {
      graph = new ArrayList<>();
      dijkstraGraph = new ArrayList<>();
      for (int i = 0; i <= n; i++) {
        dijkstraGraph.add(new ArrayList<>());
      }
      dist = new double[n+1];
      Arrays.fill(dist, -1.0);
      m = sc.nextInt();
      for (int i = 0; i < m; i++) {
        int u = sc.nextInt();
        int v = sc.nextInt();
        double w = sc.nextDouble();
        graph.add(new Edge(u, v, w/100.0));
        dijkstraGraph.get(u).add(new Node(v, w/100.0));
        dijkstraGraph.get(v).add(new Node(u, w/100.0));
      }
      // bellmanFord(1);
      dijkstra(1);
      System.out.printf("%.6f percent\n", dist[n] * 100.0);
      n = sc.nextInt();
    }
    sc.close();
  }

  private static void bellmanFord(int s) {
    dist[s] = 1.0;
    int u, v;
    double w;

    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < m; j++) {
        u = graph.get(j).source;
        v = graph.get(j).target;
        w = graph.get(j).weight;        
        dist[v] = Math.max((dist[u] * w), dist[v]);
        dist[u] = Math.max((dist[v] * w), dist[u]); // u to v path can traverse 2 way
        // if only can from u to v, not the vice versa, only need "dist[v] = Math.max((dist[u] * w), dist[v]);"
      }
    }
  }

  private static void dijkstra(int s) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    dist[s] = 1.0;
    pq.add(new Node(s, 1.0));
    while (!pq.isEmpty()) {
      Node current = pq.poll();
      int id = current.id;
      double d = current.dist;
      if (current.dist < dist[id])
        continue;

      for (Node node : dijkstraGraph.get(id)) {
        if (d * node.dist > dist[node.id]) {
          dist[node.id] = d * node.dist;
          pq.add(new Node(node.id, dist[node.id]));
        }
      }
    }
  }
}
