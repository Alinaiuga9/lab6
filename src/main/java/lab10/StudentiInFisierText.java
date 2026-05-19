package lab10;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class StudentiInFisierText implements IStudentiExport {
    private String fileName;

    public StudentiInFisierText(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void doExport(List<Student> studenti) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Student s : studenti) {
                writer.write(s.toString() + "\n");
            }
            System.out.println("Exportul in fisierul text " + fileName + " s-a realizat cu succes!");
        } catch (IOException e) {
            System.err.println("Eroare la scrierea in fisierul text: " + e.getMessage());
        }
    }
}