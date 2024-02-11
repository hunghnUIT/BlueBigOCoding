package BST;

import java.util.*;

public class DistinctCount {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tc = sc.nextInt();
    for (int t = 0; t < tc; t++) {
      HashMap<Integer, Boolean> hm = new HashMap<>();
      int x, n;
      n = sc.nextInt();
      x = sc.nextInt();
      for (int i = 0; i < n; i++) {
        int val = sc.nextInt();
        hm.put(val, true);
      }
      int size = hm.size();
      if (size == x) 
        System.out.println("Good");
      else if (size > x)
        System.out.println("Average");
      else
        System.out.println("Bad");
    }
    sc.close();    
  }
}
