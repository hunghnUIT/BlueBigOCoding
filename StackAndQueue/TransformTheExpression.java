package StackAndQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class TransformTheExpression {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    sc.nextLine();
    for (int i = 0; i < n; i++) {
      String temp = sc.nextLine();
      System.out.println(transform(temp));
    }
    sc.close();
  }

  public static String transform(String s) {
    StringBuilder res = new StringBuilder();
    Stack stack = new Stack<>();
    for (char c: s.toCharArray()) {
      Set<Character> hs = new HashSet<>(Arrays.asList('+','-','*','/','^'));
      if (c >= 'a' && c <= 'z') {
        res.append(c);
      } else if (hs.contains(c)) {
        stack.add(c);
      } else if (c == ')') {
        res.append(stack.pop());
      }
    }
    return res.toString();
  }
}
