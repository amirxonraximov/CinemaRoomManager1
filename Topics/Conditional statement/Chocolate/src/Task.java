// write your answer here 

import java.util.Scanner;

class Task {
  public static void main(String[] args) {
    // put your code here
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int M = scanner.nextInt();
    int K = scanner.nextInt();

    if ((K % N == 0 && K / N < M) || (K % M == 0 && K / M < N)) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }
}
