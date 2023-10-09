package Heap;

import java.util.*;

public class Qheap1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();        
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    PriorityQueue<Integer> pqRemoved = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      int op = sc.nextInt();
      if (op == 1) {
        pq.add(sc.nextInt());
      } else if (op == 2) {
        Integer need = sc.nextInt();
        pqRemoved.add(need);
      } else {
        while (Objects.equals(pq.peek(), pqRemoved.peek())){
          pq.poll();
          pqRemoved.poll();
        }
        System.out.println(pq.peek());
      }
    }
    sc.close();
  }
}
