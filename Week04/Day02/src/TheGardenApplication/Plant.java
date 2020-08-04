package TheGardenApplication;

public class Plant {
  private final String color;
  private int waterAmount;
  private final int absorbingPercentage;

  public Plant(String color, int absorbingPercentage) {
    this.color = color;
    this.waterAmount = 0;
    this.absorbingPercentage = absorbingPercentage;
  }

  public Boolean needsWater() {
    return waterAmount < 5;
  }

  public String textForNeedsWater() {
    String text = "";
    if (needsWater()) {
      text = "needs water";
    } else {
      text = "doesn't need water";
    }
    return text;
  }

  public int getWaterAmount() {
    return waterAmount;
  }

  public void setWaterAmount(int waterAmount) {
    this.waterAmount = waterAmount;
  }

  public int getAbsorbingPercentage() {
    return absorbingPercentage;
  }

  public void info() {
    System.out.println(
        "The " + this.color + " " + this.getClass().getSimpleName() + " " + textForNeedsWater());
  }
}