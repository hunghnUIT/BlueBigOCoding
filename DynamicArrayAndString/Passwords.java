import java.util.*;

public class Passwords {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    ArrayList<String> a = new ArrayList<>();
    for (int i = 0; i <n; i++) {
      a.add(sc.next());
    }
    String pwd = sc.next();
    sc.close();

    int countFailedWorst = 0;
    int countFailedBest = 0;
    Map<Integer, Integer> hm = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int len = a.get(i).length();
      hm.put(len, hm.getOrDefault(len, 0)+1);
    }

    // use hashmap here is too much, just need to loop over the input array
    for (Map.Entry<Integer,Integer> el : hm.entrySet()) {
      int key = el.getKey();
      int value = el.getValue();
      if (key < pwd.length()) {
          countFailedWorst += value;
          countFailedBest+= value;
      } else if (key == pwd.length()) {
        countFailedWorst += (value - 1); // -1 because last time is success, not count
      }
    }
    int worst = countFailedWorst;
    int best = countFailedBest;
    if (countFailedWorst >  k) {
      worst = (countFailedWorst/k)*5 + countFailedWorst;
    }
    if (countFailedBest > k) {
      best = (countFailedBest/k)*5 + countFailedBest;
    }
    best++; // success takes 1 secs
    worst++; // failed takes 1 secs
    
    System.out.println(best + " " + worst);
  }
}
