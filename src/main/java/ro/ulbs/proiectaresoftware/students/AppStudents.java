package ro.ulbs.proiectaresoftware.students;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AppStudents {

    public static void salveazaInFisier(String numeFisier, Collection<? extends Student> studenti) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(numeFisier))) {
            for (Student student : studenti) {
                writer.write(student.toString());
                writer.newLine();
            }
            System.out.println("Datele au fost salvate cu succes în fișierul: " + numeFisier);
        } catch (IOException e) {
            System.err.println("Eroare la scrierea în fișierul " + numeFisier + ": " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        List<StudentBursieri> bursieri = new ArrayList<>();

        bursieri.add(new StudentBursieri(1025, "Andrei", "Popa", "ISM141/2", 8.70, 725.50));
        bursieri.add(new StudentBursieri(1024, "Ioan", "Mihalcea", "ISM141/1", 9.80, 801.10));
        bursieri.add(new StudentBursieri(1026, "Anamaria", "Prodan", "TI131/1", 8.90, 745.50));
        bursieri.add(new StudentBursieri(1029, "Bianca", "Popescu", "TI131/1", 9.10, 780.80));
        salveazaInFisier("bursieri_out.txt", bursieri);
    }
}