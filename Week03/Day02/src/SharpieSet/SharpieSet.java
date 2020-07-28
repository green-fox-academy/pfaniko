package SharpieSet;

import java.util.ArrayList;
import java.util.List;

public class SharpieSet {
  private List<Sharpie> sharpieSet = new ArrayList<Sharpie>();

  public SharpieSet() {
  }

  public void add(Sharpie sharpie) {
    this.sharpieSet.add(sharpie);
  }

  public Integer countUsable() {
    int counter = 0;
    for (Sharpie s : sharpieSet) {
      if (s.getInkAmount() != 0) {
        counter = counter + 1;
      }
    }
    return counter;
  }

  public void removeTrash() {
    sharpieSet.removeIf(s -> s.getInkAmount() == 0);
  }

  public void printOutListOfColors() {
    for (Sharpie s : sharpieSet) {
      System.out.println(s.getColor());
    }
  }
}