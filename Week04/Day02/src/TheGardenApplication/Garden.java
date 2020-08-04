package TheGardenApplication;

import java.util.ArrayList;
import java.util.List;

public class Garden {
  List<Plant> garden;

  public Garden() {
    this.garden = new ArrayList<>();
  }

  public void addPlant(Plant plant) {
    this.garden.add(plant);
  }

  public Integer calculateWateringAmountForEachPlant(int wateringAmount) {
    return wateringAmount / garden.size();
  }

  public void wateringGarden(int wateringAmount) {
    System.out.println("Watering with " + wateringAmount);
    for (Plant plant : garden) {
      int currentWaterAmount = plant.getWaterAmount();
      if (plant.needsWater()) {
        plant.setWaterAmount(currentWaterAmount +
            calculateWateringAmountForEachPlant(wateringAmount) * plant.getAbsorbingPercentage() /
                100);
      }
    }
  }

  public void infoGarden() {
    for (Plant plant : garden) {
      plant.info();
    }
    System.out.println("");
  }
}