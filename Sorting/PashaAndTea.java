package Sorting;

import java.util.*;

public class PashaAndTea {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int w = sc.nextInt();
    ArrayList<Integer> a = new ArrayList<>();
    for (int i = 0; i < n*2; i++) {
      a.add(sc.nextInt());
    }
    sc.close();

    Collections.sort(a);

    double p;
    if (a.get(0)*2 <= a.get(n)) {
      p = (double)a.get(0);
    } else { // a.get(0)*2 > a.get(n)
      p = (double)a.get(n)/2;
    }
    /* explain:
     * after asc sorting, cups from 0->n-1 is perfect for girls, since their water will be less than boys
     * and cups from n -> 2n - 1 boys.
     * because every boys and girls get the same water level, 
     * then the smallest cup of girls is the maximum water level for girls, and the same with the boys.
     * If the smallest cup of the girls * 2 <= the smallest cup of the boys
     * then the water level for girl (x, boys is 2x) = a[0], because the smaller, more cup will be filled
     * else (smallest girls cup > smallest boy cup) => the water level should be a[n]/2
     * the idea is to pick the lowest water level to fill every cup.
     * above is the explanation online
     * .
     * BUT WHY DONT WE JUST CALCULATE WATER LEVEL LIKE THIS: (my approach)
     * We have constraint: w >= n*x + n*2*x <=> w>= 3nx => x <= w/3n
     * => total = x*2n
     */
    double temp = p*3*n;
    if (temp > w)
      System.out.println(w);
    else
      System.out.println(temp);
  }
}
