// write your answer here 

import java.util.Arrays;
import java.util.Scanner;
class Task {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int len1 = scanner.nextInt();
    int len2 = scanner.nextInt();
    int[][] cubic = new int[len1][len2];
    int[] n = new int[]{0, 0};

    for (int i = 0; i < len1; i++) {

      for (int j = 0; j < len2; j++) {
        cubic[i][j] = scanner.nextInt();

      }
    }

    int[][] a = new int[1][1];

    a[0][0] = Integer.MIN_VALUE;

    for (int i = 0; i < len1; i++) {

      for (int j = 0; j < len2; j++) {

        if (a[0][0] < cubic[i][j]) {
          a[0][0] = cubic[i][j];
          n[0] = i;
          n[1] = j;

        }
      }
    }


    final String representation = Arrays.toString(n)
            .replace("[", "")
            .replace("]", "")
            .replace(",", "");
    System.out.println(representation);
  }
}
