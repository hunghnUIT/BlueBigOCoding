package Dijkstra;

import java.util.*;

import Share.Node;

public class SendingEmail {
  public static ArrayList<ArrayList<Node>> graph;
  public static int[] dist;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int q = sc.nextInt();
    for (int i = 0; i < q; i++) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int s = sc.nextInt();
      int t = sc.nextInt();
      dist = new int[n+1];
      Arrays.fill(dist, (int)1e9+7);
      graph = new ArrayList<>();
      for (int j = 0; j <= n; j++) {
        graph.add(new ArrayList<>());
      }
      for (int j = 0; j < m; j++) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        int delay = sc.nextInt();
        graph.get(a).add(new Node(b, delay));
        graph.get(b).add(new Node(a, delay));

      }
      dijkstra(s);
      System.out.println("Case #"+(i+1) +": " + (dist[t] != (int)1e9+7 ? dist[t] : "unreachable"));
    }
    sc.close();
  }

  static void dijkstra(int start) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(start, 0));
    dist[start] = 0;

    while (!pq.isEmpty()) {
      Node current = pq.poll();
      int id = current.id;
      int distance = current.dist;

      if (distance > dist[id])
        continue;

        for (Node node : graph.get(id)) {
          if (node.dist + distance < dist[node.id]) {
            dist[node.id] = node.dist + distance;
            pq.add(new Node(node.id, dist[node.id]));
          }
        }
    }
  }
}
