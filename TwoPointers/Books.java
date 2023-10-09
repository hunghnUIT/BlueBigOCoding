package TwoPointers;

import java.util.*;

public class Books {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int t = sc.nextInt();
    ArrayList<Integer> a = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      a.add(sc.nextInt());
    }
    sc.close();

    int max = 0;
    int start = 0;
    int readTime = 0;
    int count = 0;
    for (int end = 0; end < n; end++) {
      readTime += a.get(end);
      count++;
      while (readTime > t) {
        readTime -= a.get(start);
        start++;
        count--;
      }
      if (count > max) {
        max = count;
      }
    }    


    System.out.println(max);
  }
}
