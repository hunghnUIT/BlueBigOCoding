package Heap;

import java.util.*;

class MaxHeapComparator implements Comparator<Long> {
  @Override
  public int compare(Long o1, Long o2) {
    return o2.compareTo(o1);
  }
}

public class MonkAndMultiplication {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();        
    PriorityQueue<Long> h = new PriorityQueue<>(new MaxHeapComparator());
    for (int i = 0; i < n; i++) {
      h.add(sc.nextLong());
      if (i < 2) {
        System.out.println(-1);
        continue;
      }
      Long max1 = h.poll();
      Long max2 = h.poll();
      Long max3 = h.poll();
      System.out.println((max1*max2*max3));
      h.add(max1);
      h.add(max2);
      h.add(max3);
    }
    sc.close();
  }
}
