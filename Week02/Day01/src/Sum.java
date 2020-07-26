import java.util.Scanner;

public class Sum {
  // Create the usual class wrapper and main method on your own.

  // Write a function called `sum` that returns the sum of numbers from zero to the given parameter
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int i = scanner.nextInt();
    System.out.println(sum(i));
  }

  public static Integer sum(int i) {
    int sum = 0;
    for (int j = 0; j <= i; j++) {
      sum = sum + j;
    }
    return sum;
  }
}