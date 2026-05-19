package lab10;

import java.util.List;

public class StudentiInConsola implements IStudentiExport {
    @Override
    public void doExport(List<Student> studenti) {
        System.out.println("--- Afisare Studenti in Consola ---");
        for (Student s : studenti) {
            System.out.println(s);
        }
    }
}