package FloydWarshall;

import java.util.*;

public class PossibleFriends {
  public static final int INF = (int)1e9;
  private static int[][] dist;
  private static int[][] path;
  private static int n;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tc = sc.nextInt();
    for (int t = 0; t < tc; t++) {
      String inputLine = sc.next();
      n = inputLine.length();
      
      dist = new int[n][n];
      path = new int[n][n];
      for (int j = 0; j < n; j++) {
        Arrays.fill(dist[j], INF);
        Arrays.fill(path[j], -1);
      }
      // first row of graph
      int temp = 0;
      for (Character c : inputLine.toCharArray()) {
        if (temp == 0) {
          dist[0][temp] = 0;
          continue;
        }
        if (c == 'N' )
          dist[0][temp] = INF;
        else
          dist[0][temp] = 1;
        temp++;
      }
      // the rest of graph
      for (int i = 1; i < n; i++) {
        inputLine = sc.next();
        int j = 0;
        for (Character c : inputLine.toCharArray()) {
          if (i == j) {
            dist[i][j] = 0;
            continue;
          }
          if (c == 'N')
            dist[i][j] = INF;
          else
            dist[i][j] = 1;
          j++;
        }
      }
      floydWarshall();
      countMaxPossibleFriend();
    }
    sc.close();
  }

  public static void floydWarshall() {
    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        if (dist[i][k] == INF) continue;
        for (int j = 0; j < n; j++) {
          if (dist[k][j] != INF && dist[i][j] > dist[i][k] + dist[k][j]) {
            dist[i][j] = dist[i][k] + dist[k][j];
            path[i][j] = path[k][j];
          }
        }
      }
    }
  }

  public static void countMaxPossibleFriend() {
    int max = 0;
    int id = -1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        
      }
    }

    System.out.println(max);
  }
}
