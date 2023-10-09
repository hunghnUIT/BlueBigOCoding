package MidTerm;

import java.util.*;


class MaxHeapComparator implements Comparator<Integer> {
  @Override
  public int compare(Integer o1, Integer o2) {
    return o2.compareTo(o1);
  }
}

public class PrinterQueue {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tc = sc.nextInt();
    for (int i = 0; i < tc; i++) {
      Queue<Integer> q = new LinkedList<>();
      PriorityQueue<Integer> pq = new PriorityQueue<>(new MaxHeapComparator());
      int n = sc.nextInt();
      int m = sc.nextInt();
      for (int j = 0; j < n; j++) {
        int task = sc.nextInt();
        q.add(task);
        pq.add(task);
      } 
      int time = 0;
      int idx = m;      
      while (!q.isEmpty()) {
        if (!Objects.equals(q.peek(), pq.peek())) {
          q.add(q.poll());
          if (0 == idx) {
            idx = q.size() - 1;
          } else {
            idx--;
          }
          continue;
        }
        time++;
        if (0 == idx) {
          break;
        }
        q.poll();
        idx--;
        pq.poll();
      }
      System.out.println(time);
    }
    sc.close();
  }
}
