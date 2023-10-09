package Heap;

import java.util.*;

class MinHeapComparator implements Comparator<Long> {
  @Override
  public int compare(Long o1, Long o2) {
    return o1.compareTo(o2);
  }
}

public class AddAll {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    while (n != 0) {
      PriorityQueue<Long> pq = new PriorityQueue<>();
      for (int i = 0; i<n;i++) {
        pq.add(sc.nextLong());
      }
      Long cost = 0L;
      while (pq.size() > 1) {
        Long temp = pq.poll()+pq.poll();
        pq.add(temp);
        cost += temp;
      }
      System.out.println(cost);
      n = sc.nextInt();
    }
    sc.close();
  }
}
