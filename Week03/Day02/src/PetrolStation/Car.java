package PetrolStation;

public class Car {
  private int gasAmountCar;
  private int capacity;

  public Car() {
    this.gasAmountCar = 0;
    this.capacity = 100;
  }

  public int getGasAmountCar() {
    return gasAmountCar;
  }

  public void setGasAmountCar(int gasAmountCar) {
    this.gasAmountCar = gasAmountCar;
  }

  public int getCapacity() {
    return capacity;
  }
}
