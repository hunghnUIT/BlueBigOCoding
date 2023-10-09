package Dijkstra;

import java.util.*;

import Share.Node;


public class Commandos {
  public static int[] dist;
  public static List<ArrayList<Node>> graph;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++) {
      int n = sc.nextInt();
      dist = new int[n];
      Arrays.fill(dist, (int)1e9+7);
      graph = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        graph.add(new ArrayList<>());
      }
      int r = sc.nextInt();
      for (int j = 0; j < r; j++) {
        int u = sc.nextInt();
        int v = sc.nextInt();
        graph.get(u).add(new Node(v, 1));
        graph.get(v).add(new Node(u, 1));
      }
      int s = sc.nextInt();
      int d = sc.nextInt();
      dijkstra(s);
      System.out.println("Case "+ (i+1)+": "+ dist[d]);
    }
    sc.close();
  }

  static void dijkstra(int start) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(start, 0));
    dist[0] = 0;

    while(!pq.isEmpty()) {
      Node current = pq.poll();
      int id = current.id;
      int distance = current.dist;
      if (distance > dist[id])
        continue;

      for (Node node : graph.get(id)) {
        if (distance+node.dist < dist[node.id]) {
          dist[node.id] = distance+node.dist;
          pq.add(new Node(node.id, dist[node.id]));
        }
      }
    }
  }
}
