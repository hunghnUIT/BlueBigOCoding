package Sorting;

import java.util.*;

public class SortTheArray {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
    ArrayList<Integer> a = new ArrayList<>();
    ArrayList<Integer> sortedA = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int temp = sc.nextInt();
      a.add(temp);
      sortedA.add(temp);
    }
    sc.close();

    int start = 0;
    int end = n - 1;
    
    Collections.sort(sortedA);
    // find start
    for (; start <n; start++) {
      if (!Objects.equals(sortedA.get(start), a.get(start))) {
        break;
      }
    }
    // find end         
    for (; end > 0; end--) {
      if (!Objects.equals(sortedA.get(end), a.get(end))) {
        break;
      }
    }

    if (start == n && end == 0) { // all sorted
      System.out.println("yes");
      System.out.println("1 1");
      return;
    }
    List<Integer> sub = new ArrayList<>();
    for (int j = 0; j < n; j++) {
      if (j >= start && j <= end) {
        sub.add(a.get(j));
      }
    }

    int subSize = sub.size();
    for (int j = 0; j < subSize/2; j++) {
      Collections.swap(sub, j, subSize-j-1);
    }
    Collections.sort(a);
    boolean flag = true;
    int k = 0;
    for (int j = start; j < end + 1; j++, k++) {
      if (!Objects.equals(a.get(j), sub.get(k))) {
        flag = false;
        break;
      }
    }

    if (flag) {
      System.out.println("yes");
      System.out.println((start + 1) + " " + (end + 1));
    }
    else {
      System.out.println("no");
    }
  }
}
