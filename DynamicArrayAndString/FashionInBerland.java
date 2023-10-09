import java.util.*;

class FashionInBerland {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.nextLine());
    String[] a = (sc.nextLine()).split(" ");
    sc.close();

    if (n == 1) {
      if (a[0].equals("1")){
        System.out.println("YES");
        return;
      } else {
        System.out.println("NO");
        return;
      }
    } else { // > 1
      int count = 0;
      for (int i = 0; i < n; i++) {
        if (a[i].equals("0")) {
          count++;
        }
      }
      if (count == 1) { // have to be == 1 for YES, not > 1 for NO bcs of 0 is expected to be NO
        System.out.println("YES");
        return;
      }
      System.out.println("NO");
    }        
  }
}