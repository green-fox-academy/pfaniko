import java.util.HashMap;

public class MapIntroduction1 {
  public static void main(String[] args) {
    HashMap<Integer, Character> numbers = new HashMap<Integer, Character>();
    System.out.println(numbers.isEmpty());
    numbers.put(97, 'a');
    numbers.put(98, 'b');
    numbers.put(99, 'c');
    numbers.put(65, 'A');
    numbers.put(66, 'B');
    numbers.put(67, 'C');
    System.out.println(numbers.keySet());
    System.out.println(numbers.values());
    numbers.put(68, 'D');
    System.out.println(numbers.size());
    System.out.println(numbers.get(99));
    numbers.remove(97);
    System.out.println(numbers.containsKey(100));
    numbers.clear();
    System.out.println(numbers.isEmpty());
  }
}