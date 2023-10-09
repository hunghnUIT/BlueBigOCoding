package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class GukiZAndContest {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
    ArrayList<Integer> a = new ArrayList<>();
    ArrayList<Integer> aCopy = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int in = sc.nextInt();
      a.add(in);
      aCopy.add(in);
    }
    sc.close();

    Collections.sort(aCopy, Collections.reverseOrder());
    int idx = 1;
    HashMap<Integer,Integer> hm = new HashMap();
    for (int num : aCopy) {
      if (!hm.containsKey(num)) {
        hm.put(num, idx);
      }
      idx++;
    }

    String res = "";
    for (int num : a) {
      res += (hm.get(num) + " ");
    }
    System.out.println(res.trim());
  }
}
