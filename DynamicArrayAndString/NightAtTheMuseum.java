import java.util.*;

public class NightAtTheMuseum {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    sc.close();

    char start = 'a';
    int result = 0;
    for (int i = 0; i < s.length(); i++) {
      int temp = Math.abs(s.charAt(i) -start);
      if (temp > 13) {
        result += 13-(temp - 13);
      } else {
        result += temp;
      }
      start = s.charAt(i);
    }
    System.out.println(result);
  }
}
