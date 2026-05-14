package lab8;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CitireExcel {
    public static void main(String[] args) {
        String input = "laborator8_input.xlsx";
        String output = "laborator8_output2.xlsx";

        System.out.println("--- Continut Fisier Input ---");
        citesteExcel(input);

        System.out.println("\n--- Generare Fisier Output2 ---");
        genereazaOutputMedia(input, output);
    }

    public static void citesteExcel(String numeFisier) {
        try (FileInputStream fis = new FileInputStream(new File(numeFisier))) {
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                for (Cell cell : row) {
                    if (cell.getCellType() == CellType.STRING) {
                        System.out.print(cell.getStringCellValue() + "\t");
                    } else if (cell.getCellType() == CellType.NUMERIC) {
                        System.out.print(cell.getNumericCellValue() + "\t");
                    }
                }
                System.out.println();
            }
            workbook.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void genereazaOutputMedia(String numeInput, String numeOutput) {
        try (FileInputStream fis = new FileInputStream(new File(numeInput));
             Workbook workbookInput = new XSSFWorkbook(fis);
             Workbook workbookOutput = new XSSFWorkbook()) {

            Sheet sheetInput = workbookInput.getSheetAt(0);
            Sheet sheetOutput = workbookOutput.createSheet("Rezultate");

            for (int i = 0; i <= sheetInput.getLastRowNum(); i++) {
                Row rowInput = sheetInput.getRow(i);
                Row rowOutput = sheetOutput.createRow(i);
                if (rowInput == null) continue;

                int lastCellNum = rowInput.getLastCellNum();
                double suma = 0;
                int countNote = 0;

                for (int j = 0; j < lastCellNum; j++) {
                    Cell cellIn = rowInput.getCell(j);
                    Cell cellOut = rowOutput.createCell(j);

                    if (cellIn != null) {
                        if (cellIn.getCellType() == CellType.STRING) {
                            cellOut.setCellValue(cellIn.getStringCellValue());
                        } else if (cellIn.getCellType() == CellType.NUMERIC) {
                            double valoare = cellIn.getNumericCellValue();
                            cellOut.setCellValue(valoare);
                            if (j >= lastCellNum - 3) {
                                suma += valoare;
                                countNote++;
                            }
                        }
                    }
                }

                if (countNote > 0) {
                    Cell cellMedia = rowOutput.createCell(lastCellNum);
                    cellMedia.setCellValue(suma / countNote);
                }
            }

            try (FileOutputStream fos = new FileOutputStream(new File(numeOutput))) {
                workbookOutput.write(fos);
                System.out.println("Fisierul " + numeOutput + " a fost generat cu succes.");
            }
        } catch (Exception e) {
            System.out.println("Eroare la generare: " + e.getMessage());
        }
    }
}