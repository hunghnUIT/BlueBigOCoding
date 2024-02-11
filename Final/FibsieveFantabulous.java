package Final;

import java.util.*;

public class FibsieveFantabulous {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    ArrayList<Integer> input = new ArrayList<>();
    for (int i = 0; i < t; i++) {
      input.add(sc.nextInt());
    }
    Collections.sort(input);
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(1);
    int idx = 0;
    int currentAmount = 1;
    int countCase = 1;
    for (Integer need : input) {
      while (arr.get(idx) < need) {
        int nextAmount = currentAmount + 2;
        arr.add(arr.get(idx) + nextAmount);
        currentAmount = nextAmount;
        idx++;
      }
      int judgingIdx = idx +1;
      int x, y;
      int current = arr.get(idx);
      if (judgingIdx % 2 != 0) { // odd -> max on top
        x = 1;
        y = judgingIdx;
        while (current != need) {
          if (x < judgingIdx)
            x++;
          else
            y--;
          current--;
        }
      } else { // even -> max on bottom
        y = 1;
        x = judgingIdx;
        while (current != need) {
          if (y < judgingIdx)
            y++;
          else
            x--;
          current--;
        }
      }
      System.out.println("Case "+countCase+": "+ x + " " + y);
      countCase++;
    }
    sc.close();
  }
}
