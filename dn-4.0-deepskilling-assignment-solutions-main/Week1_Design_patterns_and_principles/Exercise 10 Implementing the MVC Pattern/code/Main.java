public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("kolin");
        student.setId("129");
        student.setGrade("A");

        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);

        controller.updateView();
        controller.setStudentName("Rahul");
        controller.updateView();
    }
}
