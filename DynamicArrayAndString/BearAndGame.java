import java.util.*;

public class BearAndGame {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();

    ArrayList<Integer> al = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      al.add(sc.nextInt());
    }

    int t = 15;
    int i = 0;
    while (t <= 90 && i < n) {
      if (t >= al.get(i)) {
        t = al.get(i);
        i++;
      } else {
        break;
      }
      t+=15;
    }
    if (t > 90)
      t=90;
    System.out.println(t);
  }
}
