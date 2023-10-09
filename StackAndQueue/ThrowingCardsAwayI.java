package StackAndQueue;

import java.util.*;
import java.util.stream.Collectors;

public class ThrowingCardsAwayI {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    while (n != 0) {
      throwCard(n);
      n = sc.nextInt();
    }
    sc.close();
  }

  public static void throwCard(int n) {
    Queue<Integer> q= new LinkedList<>();
    for (int i = 0; i < n; i++) {
      q.add(i+1);
    }
    ArrayList<Integer> discarded = new ArrayList<>();
    while (q.size() >=2) {
      discarded.add(q.poll());
      q.add(q.poll());
    }

    String discardString = "Discarded cards: " + discarded.stream().map(Object::toString)
                        .collect(Collectors.joining(", "));
    System.out.println(discardString.trim());
    System.out.println("Remaining card: " + q.peek());
  }
}
