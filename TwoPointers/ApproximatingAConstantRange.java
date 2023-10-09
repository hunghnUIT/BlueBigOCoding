package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ApproximatingAConstantRange {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    ArrayList<Integer> a = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      a.add(sc.nextInt());
    }
    sc.close();

    int count = 0;
    int[] freq = new int[100001];
    Arrays.fill(freq, 0);
    for (int num: a) {
      freq[num]++;
    }
    

    System.out.println(count);
  }
}
