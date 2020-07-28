package SharpieSet;

public class SharpieSetMain {
  public static void main(String[] args) {
    SharpieSet sharpieSet = new SharpieSet();

    sharpieSet.add(new Sharpie("green", 2, 10));
    sharpieSet.add(new Sharpie("blue", 4, 0));
    sharpieSet.add(new Sharpie("yellow", 3, 15));
    sharpieSet.add(new Sharpie("pink", 3, 1));

    sharpieSet.printOutListOfColors();
    System.out.println(sharpieSet.countUsable());
    sharpieSet.removeTrash();
    sharpieSet.printOutListOfColors();
  }
}