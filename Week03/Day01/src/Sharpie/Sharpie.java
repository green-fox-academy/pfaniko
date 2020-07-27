package Sharpie;

public class Sharpie {
  private String color;
  private float width;
  private float inkAmount;
  public static int counter;

  public Sharpie(String color, float width) {
    this.color = color;
    this.width = width;
    this.inkAmount = 100;
  }

  public void use() {
    inkAmount--;
    counter++;
  }

  public String getColor() {
    return color;
  }

  public float getWidth() {
    return width;
  }

  public float getInkAmount() {
    return inkAmount;
  }
}