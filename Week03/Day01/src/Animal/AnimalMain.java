package Animal;

public class AnimalMain {
  public static void main(String[] args) {
    Animal animal = new Animal();
    System.out.println("Hunger: " + animal.getHunger());
    System.out.println("Thirst: " + animal.getThirst());

    animal.drink();
    animal.eat();

    System.out.println("Hunger: " + animal.getHunger());
    System.out.println("Thirst: " + animal.getThirst());

    animal.play();
    System.out.println("Hunger: " + animal.getHunger());
    System.out.println("Thirst: " + animal.getThirst());

    for (int i = 0; i < 50; i++) {
      animal.drink();
    }
    System.out.println("Thirst: " + animal.getThirst());
    animal.drink();

    for (int i = 0; i < 50; i++) {
      animal.play();
    }
    System.out.println(animal.getHunger());

    animal.play();
    System.out.println(animal.getHunger());
  }
}