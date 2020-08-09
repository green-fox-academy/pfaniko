package Farm;

public class FarmMain {
  public static void main(String[] args) {
    Farm farm = new Farm(5);

    farm.breed(new Animal());
    farm.breed(new Animal());
    farm.breed(new Animal());

    farm.slaughter();
    farm.slaughter();
    farm.slaughter();
    farm.slaughter();

    System.out.println(farm.getEmptySlots());
  }
}