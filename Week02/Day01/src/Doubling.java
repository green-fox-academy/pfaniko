public class Doubling {

  static void main(String[] args) {
// - Create an integer variable named `baseNum` and assign the value `123` to it
// - Create a function called `doubling` that doubles it's input parameter and returns with an integer
// - Print the result of `doubling(baseNum)`
    int baseNum = 123;
    int baseNumDouble = doubling(baseNum);
    System.out.println(baseNumDouble);
  }

  public static int doubling(int x) {
//Doubles the input parameter and returns with an integer
    int y = x * x;
    return y;
  }
}