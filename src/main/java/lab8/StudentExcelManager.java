package lab8;

import lab7.Student;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import java.io.*;
import java.util.*;

public class StudentExcelManager {

    public static void main(String[] args) {
        List<Student> listaInitiala = new ArrayList<>();
        listaInitiala.add(new Student("Popescu Ion", 20, "Sibiu", "311AC"));
        listaInitiala.add(new Student("Ionescu Maria", 21, "Cluj", "312AC"));

        String fisier = "laborator8_students.xls";

        exportaStudenti(listaInitiala, fisier);

        List<Student> listaCitita = importaStudenti(fisier);
        System.out.println("Studenti cititi din Excel:");
        for (Student s : listaCitita) {
            System.out.println(s.toString());
        }
    }

    public static void exportaStudenti(List<Student> studenti, String numeFisier) {
        try (Workbook workbook = new HSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Studenti");
            int rowNum = 0;

            for (Student s : studenti) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(s.getNume());
                row.createCell(1).setCellValue(s.getVarsta());
                row.createCell(2).setCellValue(s.getAdresa());
                row.createCell(3).setCellValue(s.getGrupa());
            }

            try (FileOutputStream fileOut = new FileOutputStream(numeFisier)) {
                workbook.write(fileOut);
                System.out.println("Export finalizat: " + numeFisier);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static List<Student> importaStudenti(String numeFisier) {
        List<Student> studenti = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(new File(numeFisier));
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                String nume = row.getCell(0).getStringCellValue();
                int varsta = (int) row.getCell(1).getNumericCellValue();
                String adresa = row.getCell(2).getStringCellValue();
                String grupa = row.getCell(3).getStringCellValue();

                studenti.add(new Student(nume, varsta, adresa, grupa));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return studenti;
    }
}