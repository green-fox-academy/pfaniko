package Fox;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FoxMain {

  public static void main(String[] args) {
    List<Fox> foxes = Arrays.asList(
        new Fox("Fox1", "brown", 2),
        new Fox("Fox2", "purple", 5),
        new Fox("Fox3", "green", 15),
        new Fox("Fox4", "green", 4),
        new Fox("Fox5", "yellow", 7));

    List<Fox> greenFoxes = foxes.stream()
        .filter(fox -> fox.getColor().equals("green"))
        .collect(Collectors.toList());
    System.out.println(greenFoxes);

    List<Fox> greenAndYoungFoxes = foxes.stream()
        .filter(fox -> fox.getColor().equals("green") && fox.getAge() < 5)
        .collect(Collectors.toList());
    System.out.println(greenAndYoungFoxes);
  }
}
