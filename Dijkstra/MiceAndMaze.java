package Dijkstra;

import java.util.*;

import Share.Node;

// test case show that should revert path
//2
// 1
// 3
// 2
// 2 1 5
// 2 1 3
// expect result: 2
// result if not revert path: 1
public class MiceAndMaze {
  static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
  static int n;
  static int[] dist;
  static int[] path;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    int e = sc.nextInt();
    int t = sc.nextInt();
    int m = sc.nextInt();
    for (int i = 0; i < n+1; i++) {
      graph.add(new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int cost = sc.nextInt();
      graph.get(b).add(new Node(a, cost)); // <- Important, remember to revert path a to b -> b to a to match description
    } 
    sc.close();
    dijkstra(e);
    int count = 0;
    for (int i = 0; i < n+1; i++) {
      if (path[i]!=-1 && dist[i]<=t)
        count++;
    }
    System.out.println(count+1); // +1 for the mouse already on the "e" node
  }

  public static void dijkstra(int start) {
    dist = new int[n+1];
    path = new int[n+1];
    for (int i = 0; i < n+1; i++) {
      dist[i] = Integer.MAX_VALUE;
      path[i] = -1;
    }
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(start, 0));
    dist[start] = 0;

    while (!pq.isEmpty()) {
      Node current = pq.poll();
      int id = current.id;
      int distance = current.dist;
      if (dist[id] < distance)
        continue;
      for (int i = 0; i < graph.get(id).size(); i++) {
        Node neighbor = graph.get(id).get(i);
        if (neighbor.dist + distance < dist[neighbor.id]) {
          dist[neighbor.id] = neighbor.dist + distance;
          path[neighbor.id] = id;
          pq.add(new Node(neighbor.id, dist[neighbor.id]));
        }
      }
    }
  }
}
