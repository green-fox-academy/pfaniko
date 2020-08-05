import java.util.HashMap;
import java.util.Map;

public class ProductDatabase2 {
  public static void main(String[] args) {
    HashMap<String, Integer> productDatabase2 = new HashMap<>();
    productDatabase2.put("Eggs", 200);
    productDatabase2.put("Milk", 200);
    productDatabase2.put("Fish", 400);
    productDatabase2.put("Apples", 150);
    productDatabase2.put("Bread", 50);
    productDatabase2.put("Chicken", 550);

    System.out.println(getProductsBelowPrice(productDatabase2, 201));
    System.out.println(getProductsAbovePrice(productDatabase2, 150));
  }

  public static String getProductsBelowPrice(HashMap<String, Integer> productDatabase2, int price) {
    String productNames = "";
    for (Map.Entry<String, Integer> entry : productDatabase2.entrySet()) {
      if (entry.getValue() < price) {
        productNames = productNames + entry.getKey() + "\n";
      }
    }
    return "The following product/products costs below " + price + ":\n" + productNames;
  }

  public static String getProductsAbovePrice(HashMap<String, Integer> productDatabase2, int price) {
    String productNames = "";
    for (Map.Entry<String, Integer> entry : productDatabase2.entrySet()) {
      if (entry.getValue() > price) {
        productNames = productNames + entry.getKey() + ": " + entry.getValue() + "\n";
      }
    }
    return "The following product/products costs above " + price + ":\n" + productNames;
  }
}