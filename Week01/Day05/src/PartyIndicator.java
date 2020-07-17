import java.util.Scanner;

public class PartyIndicator {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int girls = scan.nextInt();
    int boys = scan.nextInt();

    if (girls == 0) {
      System.out.println("Sausage party");
    } else if (girls == boys && girls + boys >= 20) {
      System.out.println("The party is excellent!");
    } else if (girls + boys > 20) {
      System.out.println("Quite cool party!");
    } else if (girls + boys < 20) {
      System.out.println("Average party...");
    }
  }
}
