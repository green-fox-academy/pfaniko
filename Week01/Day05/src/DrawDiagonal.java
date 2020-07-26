import java.util.Scanner;
import javax.print.StreamPrintService;
import javax.swing.Spring;

public class DrawDiagonal {
  public static void main(String[] args) {
// Write a program that reads a number from the standard input, then draws a
// square like this:
//
//
// %%%%%
// %%  %
// % % %
// %  %%
// %%%%%
//
// The square should have as many lines as the number was
    Scanner scan = new Scanner(System.in);
    int lineNumber = scan.nextInt();
    for (int i = 0; i <= lineNumber - 1; i++) {
      System.out.println();
      for (int j = 0; j <= lineNumber - 1; j++) {
        if (i == 0 || i == lineNumber - 1 || j == 0 || j == i || j == lineNumber - 1) {
          System.out.print("%");
        } else {
          System.out.print(" ");
        }
      }
    }
  }
}
