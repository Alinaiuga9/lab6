package lab7;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student("Ana", 20, "Str. A", "Nedistribuit"));
        students.add(new Student("Bogdan", 21, "Str. B", "Nedistribuit"));
        students.add(new Student("Cristi", 20, "Str. C", "Nedistribuit"));
        students.add(new Student("Diana", 22, "Str. D", "Nedistribuit"));
        students.add(new Student("Elena", 21, "Str. E", "Nedistribuit"));

        List<Student> distributedStudents = new ArrayList<>();
        int mid = (students.size() + 1) / 2;

        for (int i = 0; i < students.size(); i++) {
            String targetGroup = (i < mid) ? "Grupa 1" : "Grupa 2";

            Student updatedStudent = students.get(i).moveToGroup(targetGroup);
            distributedStudents.add(updatedStudent);
        }

        System.out.println("Lista dupa impartirea in formatii de studiu egale:");
        for (Student s : distributedStudents) {
            System.out.println(s);
        }

        System.out.println("\nMutam pe Bogdan din Grupa 1 in Grupa 2:");

        Student bogdan = distributedStudents.get(1);
        Student bogdanMutat = bogdan.moveToGroup("Grupa 2");
        distributedStudents.set(1, bogdanMutat);

        System.out.println("Lista finala:");
        for (Student s : distributedStudents) {
            System.out.println(s);
        }
    }
}