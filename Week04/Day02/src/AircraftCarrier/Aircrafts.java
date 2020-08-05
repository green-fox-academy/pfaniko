package AircraftCarrier;

public class Aircrafts {
  private String type;
  private int maxAmmo;
  private int ammoStorage;
  private int baseDamage;

  public Aircrafts(String type, int maxAmmo, int baseDamage) {
    this.type = type;
    this.maxAmmo = maxAmmo;
    this.ammoStorage = 0;
    this.baseDamage = baseDamage;
  }


  public Integer fight() {
    int damagePerAircraft = damageDealt();
    ammoStorage = 0;
    return damagePerAircraft;
  }

  public Integer damageDealt() {
    return baseDamage * ammoStorage;
  }

  public Integer refill(int availableAmmo) {
    int ammoNeeded = maxAmmo - ammoStorage;
    if (availableAmmo >= ammoNeeded) {
      ammoStorage += ammoNeeded;
      availableAmmo -= ammoNeeded;
    } else {
      ammoStorage += availableAmmo;
      availableAmmo = 0;
    }
    return availableAmmo;
  }

  public void getStatus() {
    System.out.println(
        "Type: " + this.type + ", Ammo: " + this.ammoStorage + ", Base Damage: " +
            this.baseDamage +
            ", All Damage: " + damageDealt());
  }

  public Boolean isPriority() {
    return this.type.equals("F35");
  }

  public int getMaxAmmo() {
    return maxAmmo;
  }

  public int getAmmoStorage() {
    return ammoStorage;
  }
}