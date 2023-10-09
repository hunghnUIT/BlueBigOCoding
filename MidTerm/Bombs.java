package MidTerm;

import java.util.*;

public class Bombs {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int r = sc.nextInt();
    int c = sc.nextInt();
    while (r != 0) {

      int[][] matrix = new int[r][c];
      for (int i = 0; i < matrix.length; i++) {
        Arrays.fill(matrix[i], 0);
      }
      
      int rowsBomb = sc.nextInt();
      for (int i = 0; i < rowsBomb; i++) {
        int rowId = sc.nextInt();
        int countBomb = sc.nextInt();
        for (int j = 0; j < countBomb; j++) {
          int colId = sc.nextInt();
          matrix[rowId][colId] = 1;
        }
      }

      int startR = sc.nextInt();
      int startC = sc.nextInt();
      int endC = sc.nextInt();
      int endR = sc.nextInt();

      r = sc.nextInt();
      c = sc.nextInt();
    }
    sc.close();
  }
}
