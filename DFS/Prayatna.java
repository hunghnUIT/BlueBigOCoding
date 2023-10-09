package DFS;

import java.util.*;

public class Prayatna {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 0; i <t; i++) {
      int n = sc.nextInt();
      int e = sc.nextInt();

      ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        graph.add(new ArrayList<>());
      }
      for (int j = 0; j < e; j++) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        graph.get(a).add(b);
        graph.get(b).add(a);
      }
      Stack<Integer> st = new Stack<>();
      boolean[] visited = new boolean[n];
      Arrays.fill(visited, false);
      int countVisitedGroup = 0;
      for (int j = 0; j < n; j++) {
        boolean firstVisited = false;
        st.add(j);
        if (!visited[j]) {
          if (!firstVisited) {
            countVisitedGroup++;
            firstVisited = true;
          }
          visited[j] = true;
        }
        while (!st.isEmpty()) {
          int current = st.pop();
          for (int neighbor: graph.get(current)) {
            if (!visited[neighbor]) {
              visited[neighbor] = true;
              st.add(neighbor);
            }
          }
        }
      }
      System.out.println(countVisitedGroup);
    }
    sc.close();
  }
}
