package TeacherStudent;

public class Student {

  public Student() {
  }

  public String learn() {
    return "Student is learning something new";
  }

  public String question(Teacher teacher) {
    return teacher.answer();
  }
}
