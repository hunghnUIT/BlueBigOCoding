package TwoPointers;

import java.util.ArrayList;
import java.util.Scanner;

public class AliceBobAndChocolate {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    ArrayList<Integer> a = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      a.add(sc.nextInt());
    }
    sc.close();

    int countA = 0;
    int countB = 0;
    int iA = 0;
    int iB = n - 1;
    int tA = 0;
    int tB = 0;
    while (iA <= iB) {
      if (tA == tB) {
        if (iA==iB){
          countA++;
          iA++;
        } else {
          tA+=a.get(iA);
          tB+=a.get(iB);
          iA++;
          iB--;
          countA++;
          countB++;
        }
      } else if (tA > tB) {
        tB+=a.get(iB);
        iB--;
        countB++;
      } else {
        tA+=a.get(iA);
        iA++;
        countA++;
      }
    }
    System.out.println(countA + " " + countB);
  }
}
