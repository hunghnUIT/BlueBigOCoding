package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BusinessTrip {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
    ArrayList<Integer> a = new ArrayList<>();
    for (int i = 0; i < 12; i++) {
      int in = sc.nextInt();
      a.add(in);
    }
    sc.close();

    Collections.sort(a, Collections.reverseOrder());
    int count = 0;
    int temp = 0;
    int i = 0;
    while (temp < k && i < 12) {
      temp += a.get(i);
      count++;
      i++;
    }
    if (temp < k)
      System.out.println(-1);
    else {
      System.out.println(count);
    }
  }
}
