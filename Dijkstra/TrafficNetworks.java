package Dijkstra;

import java.util.*;

import Share.Node;
//  TODO NOT DONE YET

public class TrafficNetworks {
  static int[] distS;
  static int[] distT;
  static ArrayList<ArrayList<Node>> graphS;
  static ArrayList<ArrayList<Node>> graphT;
  static int INF = (int)1e9+7;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++) {
      graphS = new ArrayList<>();
      graphT = new ArrayList<>();
      int n = sc.nextInt();
      distS = new int[n];
      int m = sc.nextInt();
      int k = sc.nextInt();
      int start = sc.nextInt();
      int end = sc.nextInt();

      for (int j = 0; j < n; j++) {
        graphS.add(new ArrayList<>());
        graphT.add(new ArrayList<>());
      }
      for (int j = 0; j < m; j++) {
        int u = sc.nextInt();
        int v = sc.nextInt();
        int d = sc.nextInt();
        graphS.get(u).add(new Node(v, d));
        graphT.get(v).add(new Node(u, d));
    }
    }
    sc.close();
  }

  static void dijkstra(int start, int[] dist, ArrayList<ArrayList<Node>> graph) {
    Arrays.fill(dist, INF);
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(start, 0));
    dist[start] = 0;

    while (!pq.isEmpty()) {
      Node current = pq.poll();
      int currentId = current.id;
      int currentDist = current.dist;

      if (dist[currentId] < currentDist)
        continue;

      for (Node neighbor : graph.get(currentId)) {
        if (neighbor.dist + currentDist < dist[neighbor.id]) {
          dist[neighbor.id] = neighbor.dist + currentDist;
          pq.add(new Node(neighbor.id, dist[neighbor.id]));
        }
      }
    }
  }
}
