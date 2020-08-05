package AircraftCarrier;

import java.util.ArrayList;
import java.util.List;

public class Carrier {
  List<Aircrafts> listOfPlanes;
  int storeOfAmmo;
  int healthPoints;

  public Carrier(int storeOfAmmo, int healthPoints) {
    this.storeOfAmmo = storeOfAmmo;
    this.healthPoints = healthPoints;
    this.listOfPlanes = new ArrayList<>();
  }

  public void addAircraft(Aircrafts aircraft) {
    listOfPlanes.add(aircraft);
  }

  public void fill() {
    for (Aircrafts aircraft : listOfPlanes) {
      if (aircraft.isPriority()) {
        storeOfAmmo = aircraft.refill(storeOfAmmo);
      }
    }
    for (Aircrafts aircraft : listOfPlanes) {
      if (!aircraft.isPriority()) {
        storeOfAmmo = aircraft.refill(storeOfAmmo);
      }
    }
  }

  public void fight(Carrier carrier1) {
    for (Aircrafts aircraft : this.listOfPlanes) {
      carrier1.healthPoints -= aircraft.fight();
    }
    for (Aircrafts aircraft : carrier1.listOfPlanes) {
      this.healthPoints -= aircraft.fight();
    }
  }

  public Integer totalDamage() {
    int totalDamage = 0;
    for (Aircrafts aircraft : listOfPlanes) {
      totalDamage = totalDamage + aircraft.damageDealt();
    }
    return totalDamage;
  }

  public void getStatus() {
    if (healthPoints > 0) {
      System.out.println(
          "HP: " + healthPoints + " Aircraft count: " + listOfPlanes.size() + " Ammo Storage: " +
              storeOfAmmo + " Total damage: " + totalDamage() + '\n' + "Aircrafts:");
      for (Aircrafts aircraft : listOfPlanes) {
        aircraft.getStatus();
      }
    } else {
      System.out.println("It's dead Jim :(");
    }
    System.out.println("");
  }
}