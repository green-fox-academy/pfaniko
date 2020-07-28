package TeacherStudent;

public class Teacher {

  public Teacher() {
  }

  public String answer() {
    return "Teacher is answering the question";
  }

  public String teach(Student student) {
    return student.learn();
  }
}