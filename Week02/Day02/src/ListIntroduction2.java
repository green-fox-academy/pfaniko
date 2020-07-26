import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListIntroduction2 {
  public static void main(String[] args) {
    ArrayList<String> ListA = new ArrayList<String>();
    ListA.add("Apple");
    ListA.add("Avocado");
    ListA.add("Blueberries");
    ListA.add("Durian");
    ListA.add("Lychee");
    ArrayList<String> ListB = new ArrayList<String>(ListA);
    System.out.println(ListA.contains("Durian"));
    ListB.remove("Durian");
    ListA.add(4, "Kiwifruit");

    if (ListA.size() > ListB.size()) {
      System.out.println("List A is longer");
    } else if (ListA.size() == ListB.size()) {
      System.out.println("List A is the same size as List B");
    } else {
      System.out.println("List B is longer");
    }

    System.out.println(ListA.indexOf("Avocado"));

    if (ListB.contains("Durian")) {
      System.out.println(ListB.indexOf("Durian"));
    } else {
      System.out.println("Durian is not included in the list");
    }

    ArrayList<String> newList = new ArrayList<String>();
    ListB.addAll(Arrays.asList("Passion Fruit", "Pomelo"));
    System.out.println(ListA.get(2));
  }
}