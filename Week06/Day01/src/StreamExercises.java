import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamExercises {

  public static void main(String[] args) {
    // Exercise 1 - Write a Stream Expression to get the even numbers from the following list:
    List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);
    List<Integer> evenNumbers = numbers.stream()
        .filter(number -> number % 2 == 0)
        .collect(Collectors.toList());
    System.out.println(evenNumbers);

    // Exercise 2 - Write a Stream Expression to get the squared value of the positive numbers from the following list:
    List<Integer> squaredValuesOfPositiveNumbers = numbers.stream()
        .filter(number -> number > 0)
        .map(number -> number * number)
        .collect(Collectors.toList());
    System.out.println(squaredValuesOfPositiveNumbers);

    //Exercise 3 - Write a Stream Expression to find which number squared value is more then 20 from the following list:
    List<Integer> numbers3 = Arrays.asList(3, 9, 2, 8, 6, 5);
    List<Integer> squaredValueMoreThanTwenty = numbers3.stream()
        .map(number -> number * number)
        .filter(number -> number > 20)
        .collect(Collectors.toList());
    System.out.println(squaredValueMoreThanTwenty);

    //Exercise 4 - Write a Stream Expression to get the average value of the odd numbers from the following list:
    List<Integer> numbers4 = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);
    Double averageOfOddNumbers = numbers4.stream()
        .filter(number -> number % 2 != 0)
        .mapToInt(number -> number)
        .average()
        .orElse(0.0);
    System.out.println(averageOfOddNumbers);

    //Exercise 5 - Write a Stream Expression to get the sum of the odd numbers in the following list:
    List<Integer> numbers5 = Arrays.asList(5, 9, 1, 2, 3, 7, 5, 6, 7, 3, 7, 6, 8, 5, 4, 9, 6, 2);
    int sumOfOddNumber = numbers5.stream()
        .filter(number -> number % 2 != 0)
        .mapToInt(number -> number)
        .sum();
    System.out.println(sumOfOddNumber);

    //Exercise 6 - Write a Stream Expression to find the uppercase characters in a string!
    String stringExample =
        "Write a Stream Expression to find the uppercase characters in a string!";
    List<Character> characterStream = stringExample.chars()
        .mapToObj(c -> (char) c)
        .filter(Character::isUpperCase)
        .collect(Collectors.toList());
    System.out.println(characterStream);

    //Exercise 7 - Write a Stream Expression to find the strings which starts with a given letter(as parameter), in the following list:
    List<String> cities = Arrays
        .asList("ROME", "LONDON", "NAIROBI", "CALIFORNIA", "ZURICH", "NEW DELHI", "AMSTERDAM",
            "ABU DHABI", "PARIS");
    List<String> newList = cities.stream()
        .filter(string -> string.startsWith("R"))
        .collect(Collectors.toList());
    System.out.println(newList);

    //Exercise 8 - Write a Stream Expression to concatenate a Character list to a string!
    List<Character> characterList = Arrays.asList('a', 's', 'd', 'f');
    String string = characterList.stream()
        .map(String::valueOf)
        .collect(Collectors.joining());
    System.out.println(string);

    //Exercise 9 - Write a Stream Expression to find the frequency of characters in a given string!
    Map<String, Long> charFrequency = Arrays.stream(stringExample.toLowerCase().split(""))
        .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    charFrequency.forEach((k, v) -> System.out.println(k + ":" + v));
  }
}