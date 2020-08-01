import java.util.Arrays;

public class Bubble {
  public static void main(String[] args) {
    //  Create a function that takes a list of numbers as parameter
    //  Returns a list where the elements are sorted in ascending numerical order
    //  Make a second boolean parameter, if it's `true` sort that list descending

    //  Example:
    System.out.println(Arrays.toString(bubble(new int[] {34, 12, 24, 9, 5})));
    //  should print [5, 9, 12, 24, 34]
    System.out.println(Arrays.toString(advancedBubble(new int[] {34, 12, 24, 9, 5}, true)));
    //  should print [34, 24, 12, 9, 5]

  }

  public static int[] bubble(int[] listOfNumbers) {
    int temp;
    for (int i = 0; i < listOfNumbers.length; i++) {
      for (int j = 0; j < listOfNumbers.length; j++) {
        if (listOfNumbers[j] > listOfNumbers[i]) {
          temp = listOfNumbers[i];
          listOfNumbers[i] = listOfNumbers[j];
          listOfNumbers[j] = temp;
        }
      }
    }
    return listOfNumbers;
  }

  public static int[] advancedBubble(int[] listOfNumbers, Boolean isDescending) {
    int[] reverse = new int[listOfNumbers.length];
    int index = 0;
    if (isDescending) {
      bubble(listOfNumbers);
      for (int i = listOfNumbers.length - 1; i >= 0; i--) {
        reverse[index] = listOfNumbers[i];
        index++;
      }
      return reverse;
    } else {
      bubble(listOfNumbers);
      return listOfNumbers;
    }
  }
}