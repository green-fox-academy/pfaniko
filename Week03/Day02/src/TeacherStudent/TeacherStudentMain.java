package TeacherStudent;

public class TeacherStudentMain {

  public static void main(String[] args) {
    Teacher teacher = new Teacher();
    Student student = new Student();

    System.out.println(student.question(teacher));
    System.out.println(teacher.teach(student));
  }
}