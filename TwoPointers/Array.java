package TwoPointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Array {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    ArrayList<Integer> a = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      a.add(sc.nextInt());
    }
    sc.close();

    // int start = 0;
    // int minSum = Integer.MAX_VALUE;
    // int tempSum = 0;
    // int count = 0;
    // int storedStart = -1;
    // int storedEnd = -1;
    // HashMap<Integer,Integer> hm = new HashMap();
    // for (int end = 0; end <n; end++) {
    //   int currentNum = a.get(end);
    //   tempSum += currentNum;
    //   int countExist = hm.getOrDefault(currentNum, 0);
    //   if (countExist > 0) {
    //     hm.put(currentNum, countExist+1);
    //     if (Objects.equals(a.get(end), a.get(start))) {
    //       tempSum -= a.get(start);
    //       hm.put(a.get(start), countExist); //already +1 above, just need to pass countExist
    //       start++;
    //     }
    //   } else {
    //     hm.put(currentNum, 1);
    //     count++;
    //   }
    //   while (count > k) {
    //     hm.put(a.get(start), countExist-1);
    //     start++;
    //     count--;
    //   }
    //   if (tempSum < minSum && count == k) {
    //     minSum = tempSum;
    //     storedStart = start;
    //     storedEnd = end;
    //   }
    // }

    // if (storedStart!= -1 && storedEnd!=-1) {
    //   storedStart++;
    //   storedEnd++;
    // }
    // System.out.println((storedStart) + " " + (storedEnd));

    //failed test case 18
  }
}
