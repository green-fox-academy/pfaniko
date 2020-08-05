import java.util.HashMap;
import java.util.Map;

public class ProductDatabase {
  public static void main(String[] args) {
    HashMap<String, Integer> productDatabase = new HashMap<>();
    productDatabase.put("Eggs", 200);
    productDatabase.put("Milk", 200);
    productDatabase.put("Fish", 400);
    productDatabase.put("Apples", 150);
    productDatabase.put("Bread", 50);
    productDatabase.put("Chicken", 550);

    System.out.println(howMuchDoesItCost(productDatabase, "Fish"));
    System.out.println(whatIsTheMostExpensiveProduct(productDatabase));
    System.out.println(calculateAveragePrice(productDatabase));
    System.out.println(countProductsBelowSpecificPrice(productDatabase, 300));
    System.out.println(findProductForSpecificPrice(productDatabase, 125));
    System.out.println(whatIsTheCheapestProduct(productDatabase));
  }

  public static String howMuchDoesItCost(HashMap productDatabase, String food) {
    if (productDatabase.containsKey(food)) {
      return "The " + food + " costs " + productDatabase.get(food);
    } else {
      return "The list does not contain this food";
    }
  }

  public static String whatIsTheMostExpensiveProduct(HashMap<String, Integer> productDatabase) {
    String mostExpensiveKey = "";
    int mostExpensiveValue = 0;
    for (Map.Entry<String, Integer> entry : productDatabase.entrySet()) {
      if (entry.getValue() > mostExpensiveValue) {
        mostExpensiveKey = entry.getKey();
        mostExpensiveValue = entry.getValue();
      }
    }
    return "The most expensive product is: " + mostExpensiveKey;
  }

  public static String calculateAveragePrice(HashMap<String, Integer> productDatabase) {
    int sumPrice = 0;
    for (Map.Entry<String, Integer> entry : productDatabase.entrySet()) {
      sumPrice += entry.getValue();
    }
    return "The average price is: " + sumPrice / productDatabase.size();
  }

  public static String countProductsBelowSpecificPrice(HashMap<String, Integer> productDatabase,
                                                       int specificPrice) {
    int counter = 0;
    for (Map.Entry<String, Integer> entry : productDatabase.entrySet()) {
      if (entry.getValue() < 300) {
        counter++;
      }
    }
    return "There are " + counter + " product/products below " + specificPrice;
  }

  public static String findProductForSpecificPrice(HashMap<String, Integer> productDatabase,
                                                   int specificPrice) {
    String s = "";
    for (Map.Entry<String, Integer> entry : productDatabase.entrySet()) {
      if (entry.getValue() == specificPrice) {
        return "We can buy " + entry.getKey() + " for " + specificPrice;
      }
    }
    return "We can not buy anything for " + specificPrice;
  }

  public static String whatIsTheCheapestProduct(HashMap<String, Integer> productDatabase) {
    String cheapestProductKey = "";
    int cheapestProductValue = Integer.MAX_VALUE;
    for (Map.Entry<String, Integer> entry : productDatabase.entrySet()) {
      if (entry.getValue() < cheapestProductValue) {
        cheapestProductKey = entry.getKey();
        cheapestProductValue = entry.getValue();
      }
    }
    return "The cheapest product is: " + cheapestProductKey;
  }
}