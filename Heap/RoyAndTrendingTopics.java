package Heap;

import java.util.*;

class Topic {
  Integer id;
  Integer change;
  Integer newPoint;

  Topic(int id, int change, int newPoint) {
    this.id = id;
    this.change = change;
    this.newPoint = newPoint;
  }
}

class TopicsHeapComparator implements Comparator<Topic> {
  @Override
  public int compare(Topic o1, Topic o2) {
    if (Objects.equals(o1.change, o2.change)) {
      return o2.id.compareTo(o1.id);
    } else {
      return o2.change.compareTo(o1.change);
    }
  }
}

public class RoyAndTrendingTopics {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    PriorityQueue<Topic> pq = new PriorityQueue<>(new TopicsHeapComparator());
    for (int i =0; i<n; i++) {
      int id = sc.nextInt();
      int currentPoint = sc.nextInt();
      int post = sc.nextInt();
      int like = sc.nextInt();
      int comment = sc.nextInt();
      int share = sc.nextInt();

      int newPoint = post*50+like*5+comment*10+share*20;
      pq.add(new Topic(id, newPoint - currentPoint, newPoint));
    }
    sc.close();
    int count = 0;
    while (!pq.isEmpty() && count < 5) {
      Topic top = pq.poll();
      System.out.println(top.id + " " + top.newPoint);
      count++;
    }
  }
}
