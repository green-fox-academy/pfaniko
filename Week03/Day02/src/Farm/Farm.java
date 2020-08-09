package Farm;

import java.util.ArrayList;
import java.util.List;

public class Farm {
  private List<Animal> listAnimals = new ArrayList<Animal>();
  private int emptySlots;

  public Farm(int emptySlots) {
    this.emptySlots = emptySlots;
  }

  public int getEmptySlots() {
    return emptySlots;
  }

  public void breed(Animal animal) {
    if (emptySlots > 0) {
      listAnimals.add(animal);
      System.out.println("New animal added");
      emptySlots--;
    } else {
      System.out.println("No empty slot available");
    }
  }

  public void slaughter() {
    int leastHungry = 100;
    int indexOfLeastHungry = 0;
    if (listAnimals.size() != 0) {
      for (Animal a : listAnimals) {
        if (a.getHunger() < leastHungry) {
          indexOfLeastHungry = listAnimals.indexOf(a);
        }
      }
      listAnimals.remove(indexOfLeastHungry);
      emptySlots++;
    } else {
      System.out.println("No animal to slaughter");
    }
  }
}