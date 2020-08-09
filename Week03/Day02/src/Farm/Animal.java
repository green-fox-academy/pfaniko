package Farm;

public class Animal {
  private int hunger;
  private int thirst;

  public Animal() {
    this.hunger = 50;
    this.thirst = 50;
  }

  public void eat() {
    if (hunger > 0) {
      hunger--;
    } else {
      System.out.println("Not hungry");
    }
  }

  public void drink() {
    if (thirst > 0) {
      thirst--;
    } else {
      System.out.println("Not thirsty");
    }
  }

  public void play() {
    if (hunger >= 100 || thirst >= 100) {
      System.out.println("Too hungry/thirsty to play");
    } else {
      hunger++;
      thirst++;
    }
  }

  public int getHunger() {
    return hunger;
  }

  public int getThirst() {
    return thirst;
  }
}