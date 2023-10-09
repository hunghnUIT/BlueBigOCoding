import java.util.*;

public class VitalyAndStrings {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    String t = sc.nextLine();
    sc.close();

    String res = "";
    boolean flag = false;
    int remind = 0;
    int i = s.length() - 1;
    while (i >= 0) {
      int asciiCode = s.charAt(i); // last char code
      char nextChar;
      if (i == s.length() - 1) {
        nextChar = (char)(asciiCode+1);
      } else {
        nextChar = (char)(asciiCode+remind);
        if (remind >= 1)
          remind--;
      }
      if (Character.isLetter(nextChar)) {
        res = Character.toString(nextChar) + res;
      } else {
        res = "a" + res;
        remind++;
      }
      i--;
    }

    for (int j = 0; j < t.length(); j++){
      if (res.charAt(j)<t.charAt(j)){
        flag = true;
        break;
      }
    } 

    if (flag) {
      System.out.println(res);
    } else {
      System.out.println("No such string");
    }
  }
}
