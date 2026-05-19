package lab10;

import java.util.List;

public class StudentiInFisierXlsx implements IStudentiExport {
    private String fileName;

    public StudentiInFisierXlsx(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void doExport(List<Student> studenti) {
        System.out.println("Simulare export in Excel (" + fileName + ") pentru " + studenti.size() + " studenti.");
    }
}