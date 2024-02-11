package BellmanFord;

import java.util.*;

import Share.Edge;

public class ExtendedTraffic {
  static final int MAX_V = 205;
  static final int MAX_E = 205 * 204;
  private static Edge[] graph;
  private static int[] dist;
  private static  int[] weight;
  private static int n, m;
  public static final int INF = (int)1e9;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tc = sc.nextInt();

    for (int i = 1; i <= tc; i++) {
      n = sc.nextInt();
      weight = new int[MAX_V];
      for (int j = 1; j <= n; j++) {
        weight[j] = sc.nextInt();
      }
      m = sc.nextInt();
      dist = new int[MAX_V];
      graph = new Edge[MAX_E];

      for (int j = 0; j < m; j++) {
        int u = sc.nextInt();
        int v = sc.nextInt();
        graph[j] = (new Edge(u, v, (int)Math.pow((weight[v] - weight[u]), 3)));
      }
      boolean bellmanResult = bellmanFord(1);
      System.out.println("Case " + (i)+":");
      int q = sc.nextInt();
      for (int j = 0; j < q; j++) {
        int query = sc.nextInt();
        if (!bellmanResult || dist[query] < 3) {
          System.out.println("?");
        } else {
          System.out.println(dist[query]);
        }
      }
    }
    sc.close();
  }

  public static boolean bellmanFord(int start) {
		Arrays.fill(dist, (int)1e9);
		dist[start] = 0;
		int u, v, w;

		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < m; j++) {
				u = graph[j].source;
				v = graph[j].target;
				w = graph[j].weight;

				if (dist[u] != INF) {
					dist[v] = Math.min(dist[v], w + dist[u]);
				}
			}
		}

		for (int i = 0; i < m; i++) {
				u = graph[i].source;
				v = graph[i].target;
				w = graph[i].weight;

				if (dist[u] != INF && dist[v] > w + dist[u]) {
					return false;
				}
		}
		return true;
	}
}
