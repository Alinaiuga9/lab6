package ro.ulbs.proiectaresoftware.students;

public class AppStudents {
    public static void main(String[] args) {
        StudentBursieri student = new StudentBursieri("Popescu", 20, "Sibiu", "311AC", 850.0);

        System.out.println(student.toString());
    }
}