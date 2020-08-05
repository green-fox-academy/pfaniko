import java.util.ArrayList;
import java.util.List;

public class ShoppingList {
  public static void main(String[] args) {
    List<String> shoppingList = new ArrayList<>();
    shoppingList.add("Eggs");
    shoppingList.add("Milk");
    shoppingList.add("Fish");
    shoppingList.add("Bread");
    shoppingList.add("Chicken");
    shoppingList.add("Apples");

    System.out.println(doesTheListContain(shoppingList, "Milk"));
    System.out.println(doesTheListContain(shoppingList, "Bananas"));
  }

  public static String doesTheListContain(List shoppingList, String food) {
    if (shoppingList.contains(food)) {
      return "Yes, we have " + food + " on the list";
    } else {
      return "No, we do not have " + food + " on the list";
    }
  }
}
