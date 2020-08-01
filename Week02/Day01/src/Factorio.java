public class Factorio {
  public static void main(String[] args) {
    int a = 8;
    System.out.println(factorio(a));
  }

  public static int factorio(int a) {
    int factorial = 1;
    for (int i = 1; i <= a; i++) {
      factorial = factorial * i;
    }
    return factorial;
  }
}