package Sorting;

import java.util.*;

public class DevuTheDumbGuy {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int x = sc.nextInt();
    ArrayList<Long> a = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      a.add(sc.nextLong());
    }
    sc.close();

    Collections.sort(a);

    Long res = 0L;
    int xLeft = x;
    for (Long num: a) {
      res += (xLeft*num);
      if (xLeft > 1) {
        xLeft--;
      }
    }
    System.out.println(res);
  }
}
