package Sorting;

import java.util.*;

class Point {
  public Integer x;
  public Integer y;
  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

class PointCompare implements Comparator<Point> {
  @Override
  public int compare(Point a, Point b) {
    if (!Objects.equals(a.x, b.x)) {
      return a.x.compareTo(b.x);
    } else {
      return a.y.compareTo(b.y);
    }
  }
} 

public class EightPointSets {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Set<Integer> xSet = new HashSet();
    Set<Integer> ySet = new HashSet();
    ArrayList<Point> points = new ArrayList<>();
    for (int i = 0; i < 8; i++) {
      int first = sc.nextInt();
      int second = sc.nextInt();
      points.add(new Point(first, second));
      xSet.add(first);
      ySet.add(second);
    }
    sc.close();

    if (xSet.size() > 3 || ySet.size() > 3) {
      System.out.println("ugly");
      return;
    }

    Collections.sort(points, new PointCompare());
    // generate points based input:
    List<Integer> xArr = new ArrayList<>(xSet);
    List<Integer> yArr = new ArrayList<>(ySet);
    Collections.sort(xArr);
    Collections.sort(yArr);
    ArrayList<Point> standards = new ArrayList<>();
    for (int i = 0; i < xSet.size(); i++) {
      for (int j = 0; j < ySet.size(); j++) {
        if (i == 1 && j ==1)
          continue;
        standards.add(new Point(xArr.get(i), yArr.get(j)));
      }
    }

    for (int i = 0; i < standards.size(); i++) {
      Point standard = standards.get(i);
      Point toCheck = points.get(i);
      if (!Objects.equals(standard.x, toCheck.x) || !Objects.equals(standard.y, toCheck.y)) {
        System.out.println("ugly");
        return;
      }
    }
    System.out.println("respectable");
  }
}
