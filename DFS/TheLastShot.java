package DFS;

import java.util.*;

public class TheLastShot {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      graph.get(a).add(b);
    }
    sc.close();

    int max = 1;
    for (int i = 1; i <=n; i++) {
      if (!graph.get(i).isEmpty()) {
        boolean[] visited = new boolean[n+1];
        Queue<Integer> st = new LinkedList<>();
        st.add(i);
        visited[i] = true;
        while (!st.isEmpty()) {
          int current = st.poll();
          for (int neighbor: graph.get(current)) {
            if (!visited[neighbor]) {
              visited[neighbor] = true;
              st.add(neighbor);
            }
          }
        }
        int countVisited = 0;
        for (boolean el: visited) {
          if (el) 
            countVisited++;
        }
        if (countVisited > max) {
          max = countVisited;
        }
        if (max == n)
          break;
      }
    }
    System.out.println(max);
  }
}
