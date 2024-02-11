package BST;

import java.util.*;

public class IsenbaevNumber {
  static HashMap<String, ArrayList<String>> graph = new HashMap<>();
  static HashMap<String, Boolean> visited = new HashMap<>();
  static HashMap<String, Integer> dist = new HashMap<>();
  static final String ISENBAEV = "Isenbaev";
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Set<String> names = new HashSet<>(); // collect all names
    for (int i = 0; i < n; i++) {
      String[] temp = sc.nextLine().split(" ");
      if (temp.length == 1 && "".equals(temp[0])) {
        i--; // this input line is useless, not count
        continue;
      }

      for (int j = 0; j < temp.length; j++) {
        names.add(temp[j]);

        if (graph.get(temp[j]) == null) 
          graph.put(temp[j], new ArrayList<>());

        for (int k = 0; k < temp.length; k++) {
          if (k != j) {
            graph.get(temp[j]).add(temp[k]);

            if (graph.get(temp[k]) == null)
              graph.put(temp[k], new ArrayList<>());
            graph.get(temp[k]).add(temp[j]);
          }
        }
      }
    }
    for (String name : names) {
      visited.put(name, false);
      dist.put(name, -1);
    }
    bfs(ISENBAEV);
    String[] res = new String[names.size()];
    int idx = 0;
    for (Map.Entry<String, Integer> entry : dist.entrySet()) {
      String key = entry.getKey();
      if (ISENBAEV.equals(key) && !names.contains(key))
        continue;

      String val = ""+entry.getValue();
      if ("-1".equals(val))
        val = "undefined"; 
      res[idx] = "" + key + " " + val; 
      idx++;
    }
    Arrays.sort(res);
    for (String string : res) {
      System.out.println(string);
    }
    sc.close();
  }

  private static void bfs(String start) {
    visited.put(start, true);
    dist.put(start, 0);
    Queue<String> q = new LinkedList<>();
    q.add(start);
    while (!q.isEmpty()) {
      String currentName = q.poll();
      int distToCurrent = dist.get(currentName);
      ArrayList<String> neighbors = graph.get(currentName);
      if (neighbors == null)
        continue;
      
      for (String neighborName: graph.get(currentName)) {
        if (Boolean.TRUE.equals(visited.get(neighborName)))
          continue;
        
        visited.put(neighborName, true);
        dist.put(neighborName, distToCurrent+1);
        q.add(neighborName);
      }
    }
  }
}
