package Heap;

import java.util.*;

class MaxHeapComparator2 implements Comparator<Integer> {
  @Override
  public int compare(Integer o1, Integer o2) {
    return o2.compareTo(o1);
  }
}

class MinHeapComparator2 implements Comparator<Integer> {
  @Override
  public int compare(Integer o1, Integer o2) {
    return o1.compareTo(o2);
  }
}

public class RestaurantRating {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc. nextInt();
    PriorityQueue<Integer> rest = new PriorityQueue(new MaxHeapComparator2());
    PriorityQueue<Integer> top1_3 = new PriorityQueue(new MinHeapComparator2());
    int reviewCount = 0;
    for (int i =0; i<n; i++) {
      int op = sc.nextInt();
      if (op == 1) {
        reviewCount++;
        int x = sc.nextInt();
        // if x > the smallest of top1_3 (remember that smallest of top1_3 is greater than top rest)
        if (!top1_3.isEmpty() && top1_3.peek() < x) {
          rest.add(top1_3.poll()); // move that smallest top1_3 to rest, then add x to top1_3
          top1_3.add(x);
        } else {
          rest.add(x);
        }
        if (reviewCount % 3 == 0) { // do this every each after 3 input
          top1_3.add(rest.poll());
        }
      } else {
        if (!top1_3.isEmpty())
          System.out.println(top1_3.peek());
        else
          System.out.println("No reviews yet");
      }
    }
    sc.close();
  }
}
