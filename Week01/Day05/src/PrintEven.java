public class PrintEven {
  public static void main(String[] args) {
    int a = 0;
    while (a < 501) {
      if (a % 2 == 0) {
        System.out.println(a);
      }
      a += 1;
    }
  }
}
