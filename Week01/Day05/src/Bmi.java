import jdk.nashorn.internal.objects.NativeMath;

public class Bmi {
  public static void main(String[] args) {
    double massInKg = 81.2;
    double heightInM = 1.78;

    // Print the Body mass index (BMI) based on these values

    double bmi = massInKg / (heightInM * heightInM);
    System.out.printf("BMI: %.2f", bmi);
  }
}