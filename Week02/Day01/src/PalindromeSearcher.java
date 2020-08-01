import java.util.ArrayList;

public class PalindromeSearcher {
  public static void main(String[] args) {
    String input1 = "dog goat dad duck doodle never";
    System.out.println(searchPalindrome(input1));
  }

  public static ArrayList<String> searchPalindrome(String input1) {
    ArrayList<String> listOfPalindromes = new ArrayList<>();
    int palindromeMinLength = 3;
    for (int i = 0; i < input1.length(); i++) {
      for (int j = 0; j <= input1.length(); j++) {
        if (j - i >= palindromeMinLength) {
          String partOfInput1 = input1.substring(i, j);
          if (isPalindrome(partOfInput1)) {
            listOfPalindromes.add(partOfInput1);
          }
        }
      }
    }
    return listOfPalindromes;
  }

  public static Boolean isPalindrome(String partOfInput1) {
    Boolean isPalindrome = null;
    for (int i = 0; i < partOfInput1.length(); i++) {
      int indexOfLastLetter = partOfInput1.length() - 1 - i;
      if (partOfInput1.charAt(i) == partOfInput1.charAt(indexOfLastLetter)) {
        isPalindrome = true;
      } else {
        isPalindrome = false;
        break;
      }
    }
    return isPalindrome;
  }
}