package Dijkstra;

import java.util.*;

class City implements Comparable<City> {
  public Integer id;
  public Integer cost;
  
  City(Integer id, Integer cost) {
    this.id = id;
    this.cost = cost;
  }

  @Override
  public int compareTo(City other) {
    return this.cost.compareTo(other.cost);
  }
}

public class TheShortestPath {
  static int n;
  static int[] dist;
  static final int INF = (int)1e9 + 7;
  static HashMap<String,Integer> cities;
  static ArrayList<ArrayList<City>> graph;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++) {
      cities = new HashMap<>();
      graph = new ArrayList<>();
      n = sc.nextInt();
      for (int j = 0; j < n + 1; j++) {
        graph.add(new ArrayList<>());
      }
      for (int j = 1; j < n + 1; j++) {
        String name = sc.next();
        cities.put(name, j);
        int p = sc.nextInt();
        for (int k = 0; k < p; k++) {
          int id = sc.nextInt();
          int cost = sc.nextInt();
          graph.get(j).add(new City(id, cost));
        }
      }
      int r = sc.nextInt();
      for (int j = 0; j < r; j++) {
        String startName = sc.next();
        String destinationName = sc.next();
        dijkstra(cities.get(startName), cities.get(destinationName));
        System.out.println(dist[cities.get(destinationName)]);
      }
    }
    sc.close();
  }

  public static void dijkstra(int start, int finish) {
    dist = new int[n+1];
    Arrays.fill(dist, INF);
    PriorityQueue<City> pq = new PriorityQueue<>();
    pq.add(new City(start, 0));
    dist[start] = 0;

    while (!pq.isEmpty()) {
      City current = pq.poll();
      int id = current.id;
      int currentCost = current.cost;
      if (dist[id] < currentCost) // if to get to current node cost more than existing path, skip that, since this algo use heap.
        continue;

      for (int i = 0; i < graph.get(id).size(); i++) {
        City neighbor = graph.get(id).get(i);
        if (neighbor.cost + currentCost < dist[neighbor.id]) {
          dist[neighbor.id] = neighbor.cost + currentCost;
          pq.add(new City(neighbor.id, dist[neighbor.id]));
        }
      }
    }
  }
}
