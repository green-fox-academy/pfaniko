import java.util.Scanner;
import sun.audio.AudioSecurityAction;

public class OneTwoALot {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int userInput = scan.nextInt();
    if (userInput <= 0) {
      System.out.println("Not enough");
    }
    if (userInput == 1) {
      System.out.println("One");
    }
    if (userInput == 2) {
      System.out.println("Two");
    }
    if (userInput > 2) {
      System.out.println("A lot");
    }
  }
}
