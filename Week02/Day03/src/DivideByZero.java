import java.util.Scanner;

public class DivideByZero {
  public static void main(String[] args) {
// Create a function that takes a number
// divides ten with it,
// and prints the result.
// It should print "fail" if the parameter is 0
    Scanner scan = new Scanner(System.in);
    int a = scan.nextInt();
    divider(a);
  }

  public static void divider(Integer a) {
    try {
      int result = (10 / a);
      System.out.println(result);
    } catch (ArithmeticException e) {
      System.out.println("fail");
    }
  }
}