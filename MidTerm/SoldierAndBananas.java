package MidTerm;

import java.util.*;

public class SoldierAndBananas {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int k = sc.nextInt();
    int n = sc.nextInt();
    int w = sc.nextInt();
    sc.close();
    int res = 0;
    int cost = 0;
    for (int i = 1; i <= w; i++) {
      cost += (i*k);
    }
    res = n - cost;
    if (res > 0)
      System.out.println(0);
    else
      System.out.println(-res);
  }
}
