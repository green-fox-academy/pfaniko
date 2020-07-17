import java.util.Scanner;

public class OddEven {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int userInput = scan.nextInt();
    if (userInput % 2 == 0) {
      System.out.println("Even");
    }
    else{
      System.out.println("Odd");
    }
  }
}