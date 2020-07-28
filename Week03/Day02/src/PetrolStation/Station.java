package PetrolStation;

public class Station {
  private int gasAmountStation;

  public Station(int gasAmount) {
    this.gasAmountStation = gasAmount;
  }

  public int getGasAmountStation() {
    return gasAmountStation;
  }

  public void refill(Car car) {
    if (gasAmountStation - car.getCapacity() >= 0) {
      gasAmountStation = gasAmountStation - car.getCapacity();
      car.setGasAmountCar(car.getCapacity());
    } else {
      car.setGasAmountCar(car.getGasAmountCar() + gasAmountStation);
      gasAmountStation = 0;
    }
  }
}