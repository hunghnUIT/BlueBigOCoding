package DFS;

import java.util.*;


public class BishuAndHisGirlfriend {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    for (int j = 0; j<=n; j++) {
      graph.add(new ArrayList<>());
    }
    for (int i = 0; i < n - 1; i++) {
      int u = sc.nextInt();
      int v = sc.nextInt();
      graph.get(u).add(v);
      graph.get(v).add(u);
    }

    int[] dist = new int[n+1];
    Arrays.fill(dist, 0);
    boolean[] visited = new boolean[n+1];
    Queue<Integer> q = new LinkedList<>();
    int c = sc.nextInt();
    ArrayList<Integer> ids = new ArrayList<>();
    for (int i = 0; i < c; i++) {
      ids.add(sc.nextInt());
    }
    sc.close();

    int minDist = 1001;
    int minId = 1001;
    q.add(1);
    visited[1] = true;
    dist[1] = 0;
    while (!q.isEmpty()) {
      int current = q.poll();
      for (int node: graph.get(current)) {
        if (!visited[node]) {
          visited[node] = true;
          dist[node] = dist[current] + 1;
          q.add(node);
          if (dist[node] <= minDist && node < minId && ids.contains(node)) {
            minDist = dist[node];
            minId = node;
          }
        }
      }
    }
    System.out.println(minId);
  }
}
