package StackAndQueue;

import java.util.*;

public class ThatIsYourQueue {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int p = sc.nextInt();
    int c = sc.nextInt();
    int i = 1;
    while (c != 0 && p != 0) {
      Queue<Integer> q = new LinkedList<>();
      for (int j = 1; j <= Math.min(p, c); j++) {
        q.add(j);
      }
      System.out.println("Case "+i+":");
      for (int j = 0; j < c; j++) {
        String line = sc.next();
        if ("N".equals(line)) {
          int top = q.poll();
          q.add(top);
          System.out.println(top);
        } else  {
          int number = sc.nextInt();
          int n = q.size();
          q.add(number);
          for (int k = 0; k < n; k++) {
            int temp = q.poll();
            if (temp != number) {
                q.add(temp);
            }
          }
        }
      }
      i++;
      while (!q.isEmpty())
        q.poll();

      p = sc.nextInt();
      c = sc.nextInt();
    }
    sc.close();
  }
}
