package Sharpie;

public class SharpieMain {
  public static void main(String[] args) {
    Sharpie sharpie1 = new Sharpie("blue", 4);
    System.out.println("Ink amount: " + sharpie1.getInkAmount());
    sharpie1.use();
    sharpie1.use();
    System.out.println("Ink amount after " + sharpie1.counter + " use: " + sharpie1.getInkAmount());
  }
}