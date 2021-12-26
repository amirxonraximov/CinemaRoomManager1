// write your answer here 

import java.util.Scanner;

class Task {
  public static String concatStrings(String str1, String str2) {

    return str1 != null ? str2 != null ? str1 + str2 : str1 : str2 != null ? str2 : "";
  }

  /* Do not change code below */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String str1 = scanner.nextLine();
    String str2 = scanner.nextLine();
    str1 = "null".equalsIgnoreCase(str1) ? null : str1;
    str2 = "null".equalsIgnoreCase(str2) ? null : str2;

    System.out.println(concatStrings(str1, str2));
  }
}
