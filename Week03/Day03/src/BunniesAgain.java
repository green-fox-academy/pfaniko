public class BunniesAgain {
  public static void main(String[] args) {
//    We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3, ..) have the normal 2 ears. The even bunnies (2, 4, ..) we'll say have 3 ears, because they each have a raised foot. Recursively return the number of "ears" in the bunny line 1, 2, ... n (without loops or multiplication).

    System.out.println(countEars(5));
  }

  public static int countEars(int n) {
    int earOddBunnies = 2;
    int earEvenBunnies = 3;
    if (n == 0) {
      return 0;
    } else if (n % 2 == 0) {
      return (countEars(n - 1)) + earEvenBunnies;
    } else {
      return (countEars(n - 1)) + earOddBunnies;
    }
  }
}