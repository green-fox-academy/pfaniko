import java.util.HashMap;
import java.util.Map;

public class ShoppingList2 {
  public static void main(String[] args) {
    HashMap<String, Double> products = new HashMap<>();
    products.put("Milk", 1.07);
    products.put("Rice", 1.59);
    products.put("Eggs", 3.14);
    products.put("Cheese", 12.60);
    products.put("Chicken Breasts", 9.40);
    products.put("Apples", 1.31);
    products.put("Tomato", 2.58);
    products.put("Potato", 1.75);
    products.put("Onion", 1.10);

    HashMap<String, Integer> shoppingListBob = new HashMap<>();
    shoppingListBob.put("Milk", 3);
    shoppingListBob.put("Rice", 2);
    shoppingListBob.put("Eggs", 1);
    shoppingListBob.put("Cheese", 1);
    shoppingListBob.put("Chicken Breasts", 4);
    shoppingListBob.put("Apples", 1);
    shoppingListBob.put("Tomato", 2);
    shoppingListBob.put("Potato", 1);

    HashMap<String, Integer> shoppingListAlice = new HashMap<>();
    shoppingListAlice.put("Rice", 1);
    shoppingListAlice.put("Eggs", 5);
    shoppingListAlice.put("Chicken Breasts", 2);
    shoppingListAlice.put("Apples", 1);
    shoppingListAlice.put("Tomato", 10);

    System.out.println("Bob pays: " + howMuchOnePays(products, shoppingListBob));
    System.out.println("Alice pays: " + howMuchOnePays(products, shoppingListAlice));
    System.out.println(findWhoBuysMore(shoppingListAlice, shoppingListBob, "Rice"));
    System.out.println(findWhoBuysMore(shoppingListAlice, shoppingListBob, "Potato"));
    System.out.println(findWhoBuysMorDifferentProducts(shoppingListAlice, shoppingListBob));
    System.out.println(findWhoBuysMoreProduct(shoppingListAlice, shoppingListBob));
  }

  public static Double howMuchOnePays(HashMap<String, Double> products,
                                      HashMap<String, Integer> shoppingList) {
    double sum = 0;
    for (Map.Entry<String, Double> entry : products.entrySet()) {
      for (Map.Entry<String, Integer> item : shoppingList.entrySet()) {
        if (entry.getKey().equals(item.getKey())) {
          sum += entry.getValue() * item.getValue();
        }
      }
    }
    return sum;
  }

  public static String findWhoBuysMore(HashMap<String, Integer> shoppingListAlice,
                                       HashMap<String, Integer> shoppingListBob, String food) {
    if (!shoppingListAlice.containsKey(food) && shoppingListBob.containsKey(food)) {
      return "Bob buys more " + food + ".";
    } else if (!shoppingListBob.containsKey(food) && shoppingListAlice.containsKey(food)) {
      return "Alice buys more " + food + ".";
    } else if (!shoppingListBob.containsKey(food) && !shoppingListAlice.containsKey(food)) {
      return "Neither of them buys " + food + ".";
    } else if (shoppingListAlice.get(food) > shoppingListBob.get(food)) {
      return "Alice buys more " + food + ".";
    } else {
      return "Bob buys more " + food + ".";
    }
  }

  public static String findWhoBuysMorDifferentProducts(HashMap shoppingListAlice,
                                                       HashMap shoppingListBob) {
    if (shoppingListAlice.size() > shoppingListBob.size()) {
      return "Alice buys more different products.";
    } else {
      return "Bob buys more different products.";
    }
  }

  public static String findWhoBuysMoreProduct(HashMap shoppingListAlice,
                                              HashMap shoppingListBob) {
    if (calculateSumOfProducts(shoppingListAlice) > calculateSumOfProducts(shoppingListBob)) {
      return "They are buying the same amount of products";
    } else if (calculateSumOfProducts(shoppingListAlice) >
        calculateSumOfProducts(shoppingListBob)) {
      return "Alice buys more products.";
    } else {
      return "Bob buys more products.";
    }
  }

  public static Integer calculateSumOfProducts(HashMap<String, Integer> shoppingList) {
    int sum = 0;
    for (Map.Entry<String, Integer> entry : shoppingList.entrySet()) {
      sum += entry.getValue();
    }
    return sum;
  }
}