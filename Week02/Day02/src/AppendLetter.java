import java.util.*;

public class AppendLetter {
  public static void main(String... args) {
    List<String> far = Arrays.asList("bo", "anacond", "koal", "pand", "zebr");
    // Create a method called "appendA()" that adds "a" to every string in the "far" list.
    // The parameter should be a list.

    System.out.println(appendA(far));
  }

  public static List<String> appendA(List<String> list) {
    List<String> animalsWithA = new ArrayList<>();
    for (String animal : list) {
      animal += "a";
      animalsWithA.add(animal);
    }
    return animalsWithA;
  }
}

// The output should be: "boa", "anaconda", "koala", "panda", "zebra"