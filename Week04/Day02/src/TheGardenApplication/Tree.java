package TheGardenApplication;

public class Tree extends Plant {
  public Tree(String color) {
    super(color, 40);
  }

  @Override
  public Boolean needsWater() {
    return super.getWaterAmount() < 10;
  }
}