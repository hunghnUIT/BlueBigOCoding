package MidTerm;

import java.util.*;

public class CamelCase {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    sc.close();
    int res = 0;
    if (s.length() > 0)
      res++;

    for (char c: s.toCharArray()) {
      if (Character.isUpperCase(c))
        res++;
    }
    System.out.println(res);
  }
}
