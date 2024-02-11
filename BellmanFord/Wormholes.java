package BellmanFord;

import java.util.*;

import Share.Edge;

public class Wormholes {
  private static final int INF = (int)1e9;
  private static int[] dist;
  private static int[] path;
  private static Edge[] graph;
  private static int n, m;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tc = sc.nextInt();
    for (int i = 0; i < tc; i++) {
      n = sc.nextInt();
      m = sc.nextInt();
      dist = new int[n];
      path = new int[n];
      graph = new Edge[m];
      Arrays.fill(path, -1);
      Arrays.fill(dist, INF);
      for (int j = 0; j < m; j++) {
        int u = sc.nextInt();
        int v = sc.nextInt();
        int w = sc.nextInt();
        graph[j] = new Edge(u, v, w);
      }
      boolean negativeCircuitExisting = bellmanFord(0); // solar system id is 0
      if (!negativeCircuitExisting)
        System.out.println("possible");
      else
        System.out.println("not possible");
    }
    sc.close();
  }

  public static Boolean bellmanFord(int s) {
    int u, v, w;
    dist[s] = 0;

    for (int i = 0; i < n - 1; i++) { // loop n - 1 times (n number of vertexes)
      for (int j = 0; j < m; j++) { // loop through every edge
        u = graph[j].source;
        v = graph[j].target;
        w = graph[j].weight;
        //dist[u] != INF handle if w is negative, then this condition won't be true.
        // E.g: dist[u] = INF, dist[v] = INF, w = -5 => condition true, expected to be skip this case
        if (dist[u] != INF && dist[v] > dist[u]+w) {
          dist[v] = dist[u]+w;
          path[v] = u;
        }
      }
    }

    // check negative circle
    for (int i = 0; i < m; i++) {
      u = graph[i].source;
      v = graph[i].target;
      w = graph[i].weight;
      if (dist[u] != INF && dist[v] > dist[u] + w)
        return false;
    }

    return true;
  }
}
