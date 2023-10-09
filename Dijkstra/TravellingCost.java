package Dijkstra;

import java.util.*;
import Share.Node;

public class TravellingCost {
  static int[] dist = new int[501];
  static int[] path = new int[501];
  static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
  static int n;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    for (int i =0;i<501; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i =0;i<n; i++) {
      int a = sc.nextInt();
      int b= sc.nextInt();
      int w = sc.nextInt();
      graph.get(a).add(new Node(b, w));
      graph.get(b).add(new Node(a, w));
    }
    int start = sc.nextInt();
    dijkstra(start);
    int q = sc.nextInt();
    for (int i = 0; i < q; i++) {
      int distance = dist[sc.nextInt()];
      if (distance != Integer.MAX_VALUE)
        System.out.println(distance);
      else
        System.out.println("NO PATH");
    }
    sc.close();
  }

  public static void dijkstra(int s) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    int n = graph.size();
    for (int i = 0; i < n; i++) {
      dist[i] = Integer.MAX_VALUE;
      path[i] = -1;
    }

    pq.add(new Node(s,0));
    dist[s] = 0;

    while (!pq.isEmpty()) {
      Node current = pq.poll();
      int id = current.id;
      int distance = current.dist;
      if (dist[id] != distance)
        continue;
      for (int i = 0; i < graph.get(id).size(); i++) {
        Node neigNode = graph.get(id).get(i);
        if (neigNode.dist + distance < dist[neigNode.id]) {
          dist[neigNode.id] = neigNode.dist+distance;
          pq.add(new Node(neigNode.id, dist[neigNode.id]));
          path[neigNode.id] = id;
        }
      }
    }
  }
}
