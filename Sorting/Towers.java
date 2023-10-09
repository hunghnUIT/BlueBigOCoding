package Sorting;

import java.util.ArrayList;
import java.util.Scanner;

public class Towers {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
    ArrayList<Integer> a = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      a.add(sc.nextInt());
    }
    sc.close();

    int[] freq = new int[1001];
    for (int i = 0; i < 1001; i++) {
      freq[i] = 0;
    }
    for (int num: a) {
      freq[num]++;
    }

    int max = 0;
    int count = 0;
    for (int num: freq) {
      if (num > max) {
        max = num;
      }
      if (num != 0)
        count++;
    }
    System.out.println(max + " " + count);
  }
}
