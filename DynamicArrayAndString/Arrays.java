import java.util.*;

public class Arrays {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int nA = sc.nextInt();
    int nB = sc.nextInt();
    int k = sc.nextInt();
    int m = sc.nextInt();

    ArrayList<Integer> a = new ArrayList<>();
    ArrayList<Integer> b = new ArrayList<>();

    for (int i = 0; i < nA; i++) {
      a.add(sc.nextInt());
    }
    for (int i = 0; i < nB; i++) {
      b.add(sc.nextInt());
    }
    sc.close();

    int maxOfA = a.get(k-1);
    int i = 0;
    int minOfB = b.get(i);
    while (maxOfA >= minOfB && i < nB - m) {
      i++;
      minOfB = b.get(i);
    }
    if (maxOfA >= minOfB)
      System.out.println("NO");
    else
      System.out.println("YES");
  }
}
