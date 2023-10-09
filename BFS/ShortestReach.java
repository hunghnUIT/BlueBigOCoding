package BFS;

import java.util.*;

public class ShortestReach {
  static final int DEFAULT_LENGTH = 6;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int q = sc.nextInt();
    for (int i= 0; i < q; i++ ) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      ArrayList<ArrayList<Integer>> neighbors = new ArrayList<>();
      for (int j = 0; j<=n; j++) {
        neighbors.add(new ArrayList<>());
      }
      for (int j = 0; j <m;j++) {
        int u = sc.nextInt();
        int v = sc.nextInt();
        neighbors.get(u).add(v);
        neighbors.get(v).add(u);
      }
      int start = sc.nextInt();

      boolean[] visited = new boolean[n+1];
      int[] dist = new int[n+1];
      Arrays.fill(dist, -1);
      Queue<Integer> queue = new LinkedList<>();
      queue.add(start);
      visited[start] = true;
      dist[start] = 0;
      while (!queue.isEmpty()) {
        int current = queue.poll();
        for (int neighbor: neighbors.get(current)) {
          if (!visited[neighbor]) {
            visited[neighbor] = true;
            dist[neighbor] = (dist[current] != -1 ? dist[current] : 0) + DEFAULT_LENGTH;
            queue.add(neighbor);
          }
        }
      }
      for (int j = 1; j <= n; j++) {
        if (j == start)
          continue;
        System.out.print(dist[j] + " ");
      }
      System.out.println("");
    }
    sc.close();
  }
}
