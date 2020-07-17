import java.util.Scanner;

public class MileToKmConverter {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    double miles = scan.nextDouble();
    double km = miles * 1.60934;
    System.out.println(miles + " miles = " + km + " km");
  }
}
