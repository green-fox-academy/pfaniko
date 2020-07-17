import java.util.Scanner;

public class MultiplicationTable {
  public static void main(String[] args) {
    // Create a program that asks for a number and prints the multiplication table with that number
    Scanner scan = new Scanner(System.in);
    int number = scan.nextInt();
    for (int i = 1; i <= 10; i++) {
      System.out.println(i + " * " + number + " = " + i * number);
    }
  }
}
