package BFS;

import java.util.*;

public class IceCave {
  static ArrayList<ArrayList<Character>> matrix = new ArrayList<>();
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    for (int i = 0; i <= n; i++) {
      if (i == 0) continue;
      matrix.add(new ArrayList<>());
      char[] chars = sc.next().toCharArray();
      for (char c: chars) {
        matrix.get(i).add(c);
      }
    }
    int start = sc.nextInt();
    int end = sc.nextInt();
    sc.close();
  }
}
