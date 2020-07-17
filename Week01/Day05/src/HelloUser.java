import java.util.Scanner;

public class HelloUser {
  public static void main(String[] args) {
    // Modify this program to greet user instead of the World!
    // The program should ask for the name of the user
    Scanner scan = new Scanner(System.in);
    String s = scan.next();
    System.out.println("Hello, " + s + "!");
  }
}

