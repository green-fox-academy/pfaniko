import java.util.Arrays;

public class Unique {
  public static void main(String[] args) {
    //  Create a function that takes a list of numbers as a parameter
    //  Returns a list of numbers where every number in the list occurs only once

    //  Example
    System.out.println(unique(new int[] {1, 11, 34, 11, 52, 61, 1, 34}));
    //  should print: `[1, 11, 34, 52, 61]`
  }

  public static String unique(int[] listOfNumbers) {
    int[] numbersOnlyOnce = new int[listOfNumbers.length];
    int index = 0;
    for (int number : listOfNumbers) {
      if (!Arrays.toString(numbersOnlyOnce).contains(Integer.toString(number))) {
        numbersOnlyOnce[index] = number;
        index++;
      }
    }
    return Arrays.toString(Arrays.copyOf(numbersOnlyOnce, index));
  }
}