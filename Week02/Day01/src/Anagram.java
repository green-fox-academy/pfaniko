import java.util.Arrays;

public class Anagram {
  public static void main(String[] args) {
//    Create a function named is anagram following your current language's style guide. It should take two strings and return a boolean value depending on whether its an anagram or not.
    String input1 = "god";
    String input2 = "dog";
    System.out.println(isAnagram(input1, input2));
  }

  public static Boolean isAnagram(String input1, String input2) {
    char[] charactersOfInput1 = input1.toCharArray();
    char[] charactersOfInput2 = input2.toCharArray();
    Arrays.sort(charactersOfInput1);
    Arrays.sort(charactersOfInput2);

    return Arrays.equals(charactersOfInput1, charactersOfInput2);
  }
}