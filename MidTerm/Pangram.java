package MidTerm;

import java.util.*;
public class Pangram {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] freq = new int[26];
    Arrays.fill(freq, 0);
    int n = sc.nextInt();
    String s = sc.next();
    sc.close();
    for (char i : s.toCharArray()) {
      int idx = Character.toLowerCase(i) - 'a';
      freq[idx]++;
    }
    for (int i : freq) {
      if (i == 0) {
        System.out.println("NO");
        return;
      }
    }
    System.out.println("YES");
  }
}
