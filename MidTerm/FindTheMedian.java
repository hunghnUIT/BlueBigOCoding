package MidTerm;

import java.util.*;


public class FindTheMedian {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    ArrayList<Integer> al = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      al.add(sc.nextInt());
    }    
    sc.close();
    Collections.sort(al);
    System.out.println(al.get((int)al.size()/2));
  }
}
