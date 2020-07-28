package PetrolStation;

public class PetrolStationMain {
  public static void main(String[] args) {
    Car opel = new Car();
    Station shell = new Station(350);

    shell.refill(opel);
    System.out.println(shell.getGasAmountStation());
    System.out.println(opel.getGasAmountCar());
  }
}
