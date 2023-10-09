package StackAndQueue;

import java.util.*;

public class StreetParade {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    while (n != 0) {
      ArrayList<Integer> a = new ArrayList<>();
      ArrayList<Integer> aCopy = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        int temp = sc.nextInt();
        a.add(temp);
        aCopy.add(temp);
      }
      System.out.println(check(a));
      n = sc.nextInt();
    }
    sc.close();
  }
  public static String check(ArrayList<Integer> a) {

    Stack<Integer> st = new Stack<>();
    int allow = 1;

    for(int i =0; i<a.size(); i++) {
      if (a.get(i) != allow) {
        if (!st.isEmpty()) {
          if (st.peek() == allow) {
            allow++;
            st.pop();
            i--; // get car in stack, not in the array, therefore -1 to stay at the same car in array
            continue;
          }
        } 
        st.push(a.get(i));
      } else {
        allow++;
      }
    }

    while (!st.isEmpty()) {
      int top = st.pop();
      if (top == allow) {
        allow++;
      } else {
        break;
      }
    }

    return allow - 1 == a.size() ? "yes" : "no"; //-1 since last time matching compare, allow +1
  }
}
