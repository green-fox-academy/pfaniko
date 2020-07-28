package SharpieSet;

import java.util.ArrayList;

public class SharpieSetMain {
  public static void main(String[] args) {
    ArrayList<Sharpie> sharpieSet = new ArrayList<Sharpie>();

    sharpieSet.add(new Sharpie("green", 2,10));
    sharpieSet.add(new Sharpie("blue", 4,0));
    sharpieSet.add(new Sharpie("yellow", 3, 15));
    sharpieSet.add(new Sharpie("pink", 3, 1));

    sharpieSet.get(3).use();

    countUsable(sharpieSet);
    for (Sharpie s : sharpieSet) {
      System.out.println(s.getColor());
    }
    removeTrash(sharpieSet);
    for (Sharpie s : sharpieSet) {
      System.out.println(s.getColor());
    }
  }

  public static void countUsable(ArrayList<Sharpie> sharpieSet) {
    int counter = 0;
    for (Sharpie s : sharpieSet) {
      if (s.getInkAmount() != 0) {
        counter = counter + 1;
      }
    }
    System.out.println(counter);
  }

  public static void removeTrash (ArrayList<Sharpie> sharpieSet) {
    sharpieSet.removeIf(s -> s.getInkAmount() == 0);
  }
}