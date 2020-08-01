import java.util.ArrayList;
import java.util.Arrays;

public class SubInt {
  public static void main(String[] args) {
    //  Create a function that takes a number and an array of integers as a parameter
    //  Returns the indices of the integers in the array of which the first number is a part of
    //  Or returns an empty array if the number is not part of any of the integers in the array

    //  Example:
//    System.out.println(subInt(1, new int[] {1, 11, 34, 52, 61}));
    //  should print: `[0, 1, 4]`
//    System.out.println(subInt(9, new int[] {1, 11, 34, 52, 61}));
    //  should print: '[]'

    System.out.println(Arrays.toString(subInt(1, new int[] {1, 11, 34, 52, 61})));
    System.out.println(Arrays.toString(subInt(9, new int[] {1, 11, 34, 52, 61})));
  }

  public static Integer[] subInt(int a, int[] listOfNumbers) {
    ArrayList<Integer> tempArray = new ArrayList<>();
    for (int i = 0; i < listOfNumbers.length; i++) {
      String tempString = Integer.toString(listOfNumbers[i]);
      if (tempString.contains(Integer.toString(a))) {
        tempArray.add(i);
      }
    }
    Integer[] result = new Integer[tempArray.size()];
    return tempArray.toArray(result);
  }
}