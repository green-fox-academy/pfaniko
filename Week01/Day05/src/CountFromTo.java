import java.util.Scanner;

public class CountFromTo {
  public static void main(String[] args) {
// Create a program that asks for two numbers
// If the second number is not bigger than the first one it should print:
// "The second number should be bigger"
//
// If it is bigger it should count from the first number to the second by one
//
    Scanner scan = new Scanner(System.in);
    int a = scan.nextInt();
    int b = scan.nextInt();
    if (b <= a) {
      System.out.println("The second number should be bigger");
    }
    else {
      for (int i = a; i <= b; i++) {
        System.out.println(i);
      }
    }
  }
}
