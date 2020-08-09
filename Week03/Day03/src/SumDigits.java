public class SumDigits {
  public static void main(String[] args) {
//    Given a non-negative integer n, return the sum of its digits recursively (without loops).

    System.out.println(sumDigits(12345));
  }

  public static int sumDigits(int n) {
    if (n <= 0 || n % 10 == 0) {
      return 0;
    } else {
      return n % 10 + sumDigits(n / 10);
    }
  }
}