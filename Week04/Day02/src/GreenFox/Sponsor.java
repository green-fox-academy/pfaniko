package GreenFox;

public class Sponsor extends Person {
  private String company;
  private int hiredStudents;

  public void introduce() {
    System.out.println(
        "Hi, I'm " + super.getName() + ", a " + super.getAge() + " year old " + super.getGender() +
            " who represents " + company +
            " and hired " + hiredStudents + " students so far.");
  }

  public void getGoal() {
    System.out.println("My goal is: Hire brilliant junior software developers.");
  }

  public void hire() {
    hiredStudents++;
  }

  public Sponsor(String name, int age, String gender, String company) {
    super(name, age, gender);
    this.company = company;
    this.hiredStudents = 0;
  }

  public Sponsor() {
    super.setName("Jane Doe");
    super.setAge(30);
    super.setGender("female");
    this.company = "Google";
    this.hiredStudents = 0;
  }
}