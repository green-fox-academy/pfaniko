package GreenFox;

public class Student extends Person {
  private String previousOrganization;
  private int skippedDays;

  public void introduce() {
    System.out.println(
        "Hi, I'm " + super.getName() + ", a " + super.getAge() + " year old " + super.getGender() +
            " from " + previousOrganization +
            " who skipped " + skippedDays + " days from the course already.");
  }

  public void getGoal() {
    System.out.println("My goal is: Be a junior software developer");
  }

  public Student(String name, int age, String gender, String previousOrganization) {
    super(name, age, gender);
    this.previousOrganization = previousOrganization;
    this.skippedDays = 0;
  }

  public Student() {
    super.setName("Jane Doe");
    super.setAge(30);
    super.setGender("female");
    this.previousOrganization = "The School of Life";
    this.skippedDays = 0;
  }

  public void skipDays(int numberOfDays) {
    skippedDays = skippedDays + numberOfDays;
  }
}