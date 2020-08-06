package AircraftCarrier;

public class Aircrafts {
  private String type;
  private int maxAmmo;
  private int currentAmmo;
  private int baseDamage;

  public Aircrafts(String type, int maxAmmo, int baseDamage) {
    this.type = type;
    this.maxAmmo = maxAmmo;
    this.currentAmmo = 0;
    this.baseDamage = baseDamage;
  }
  
  public Integer fight() {
    int damagePerAircraft = damageDealt();
    currentAmmo = 0;
    return damagePerAircraft;
  }

  public Integer damageDealt() {
    return baseDamage * currentAmmo;
  }

  public Integer refill(int availableAmmo) {
    int ammoNeeded = maxAmmo - currentAmmo;
    if (availableAmmo >= ammoNeeded) {
      currentAmmo += ammoNeeded;
      availableAmmo -= ammoNeeded;
    } else {
      currentAmmo += availableAmmo;
      availableAmmo = 0;
    }
    return availableAmmo;
  }

  public void getStatus() {
    System.out.println(
        "Type: " + this.type + ", Ammo: " + this.currentAmmo + ", Base Damage: " +
            this.baseDamage +
            ", All Damage: " + damageDealt());
  }

  public Boolean isPriority() {
    return this.type.equals("F35");
  }

  public int getMaxAmmo() {
    return maxAmmo;
  }

  public int getCurrentAmmo() {
    return currentAmmo;
  }
}