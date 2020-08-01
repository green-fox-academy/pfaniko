public class PalindromeBuilder {
  public static void main(String[] args) {
    String input1 = "greenfox";
    System.out.println(palindromeBuilder(input1));
  }

  public static String palindromeBuilder(String input1) {
    String reverse = "";
    for (int i = input1.length() - 1; i >= 0; i--) {
      reverse = reverse.concat(Character.toString(input1.charAt(i)));
    }
    return input1 + reverse;
  }
}