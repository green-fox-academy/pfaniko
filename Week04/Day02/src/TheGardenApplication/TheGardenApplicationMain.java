package TheGardenApplication;

public class TheGardenApplicationMain {
  public static void main(String[] args) {
    Garden garden = new Garden();
    Plant yellowFlower = new Flower("yellow");
    Plant blueFlower = new Flower("blue");
    Plant purpleTree = new Tree("purple");
    Plant orangeTree = new Tree("orange");
    garden.addPlant(yellowFlower);
    garden.addPlant(blueFlower);
    garden.addPlant(purpleTree);
    garden.addPlant(orangeTree);

    garden.infoGarden();
    garden.wateringGarden(40);
    garden.infoGarden();
    garden.wateringGarden(70);
    garden.infoGarden();
  }
}