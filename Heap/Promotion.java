package Heap;

import java.util.*;

class MinHeapComparator1 implements Comparator<Long> {
  @Override
  public int compare(Long o1, Long o2) {
    return o1.compareTo(o2);
  }
}

class MaxHeapComparator1 implements Comparator<Long> {
  @Override
  public int compare(Long o1, Long o2) {
    return o2.compareTo(o1);
  }
}

public class Promotion {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    PriorityQueue<Long> maxq = new PriorityQueue(new MaxHeapComparator1());
    PriorityQueue<Long> minq = new PriorityQueue(new MinHeapComparator1());
    // Long[] freq = new Long[1000001];
    // Arrays.fill(freq, 0L);
    ArrayList<Long> payments = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int k = sc.nextInt();
      for (int j = 0; j < k; j++) {
        Long temp = sc.nextLong();
        maxq.add(temp);
        minq.add(temp);
        // freq[temp]++;
      }
      Long max = maxq.poll();
      // freq[max]--;
      Long min = minq.poll();
      // while (freq[min] < 0)
        // min = minq.poll();
      payments.add(max - min);
    }
    sc.close();
    int res = 0;
    for (Long pay: payments)
      res += pay;
    System.out.println(res);
  }
}
