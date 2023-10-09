import java.util.*;

public class BigSegment {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    ArrayList<int[]> a = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int l = sc.nextInt();
      int r = sc.nextInt();
      a.add(new int[]{l, r});
    }
    sc.close();

    List<String> temp = new ArrayList<>(n);
    for (int i =0; i<n;i++) {
      temp.add(""+a.get(i)[0]+"::"+a.get(i)[1]);
    }
    int minL = Integer.MAX_VALUE;
    int maxR = 0;
    for (int i =0; i<n;i++) {
      minL = Math.min(a.get(i)[0], minL);
      maxR = Math.max(a.get(i)[1], maxR);
    }

    String need = ""+minL+"::"+maxR;
    for (int i =0; i<n;i++) {
      if (temp.get(i).equals(need)) {
        System.out.println(i+1);
        return;
      }
    }
    System.out.println(-1);
  }
}
