package lab8;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
public class CitireExcel {
    public static void main(String[] args) {
        String input = "laborator8_input.xlsx";
        String out2 = "laborator8_output2.xlsx";
        String out3 = "laborator8_output3.xlsx";
        citesteExcel(input);
        genereazaOutputMedia(input, out2);
        genereazaOutputFormula(input, out3);
    }
    public static void citesteExcel(String numeFisier) {
        try (FileInputStream fis = new FileInputStream(new File(numeFisier))) {
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                for (Cell cell : row) {
                    if (cell.getCellType() == CellType.STRING)
                        System.out.print(cell.getStringCellValue() + "\t");
                    else if (cell.getCellType() == CellType.NUMERIC)
                        System.out.print(cell.getNumericCellValue() + "\t");
                }
                System.out.println();
            }
            workbook.close();
        } catch (Exception e) { System.out.println(e.getMessage()); }
    }
    public static void genereazaOutputMedia(String numeInput, String numeOutput) {
        try (FileInputStream fis = new FileInputStream(new File(numeInput));
             Workbook wbIn = new XSSFWorkbook(fis);
             Workbook wbOut = new XSSFWorkbook()) {
            Sheet sIn = wbIn.getSheetAt(0);
            Sheet sOut = wbOut.createSheet("Rezultate");
            for (int i = 0; i <= sIn.getLastRowNum(); i++) {
                Row rIn = sIn.getRow(i);
                Row rOut = sOut.createRow(i);
                if (rIn == null) continue;
                int lastCell = rIn.getLastCellNum();
                double suma = 0; int count = 0;
                for (int j = 0; j < lastCell; j++) {
                    Cell cIn = rIn.getCell(j);
                    Cell cOut = rOut.createCell(j);
                    if (cIn != null) {
                        if (cIn.getCellType() == CellType.STRING)
                            cOut.setCellValue(cIn.getStringCellValue());
                        else if (cIn.getCellType() == CellType.NUMERIC) {
                            double val = cIn.getNumericCellValue();
                            cOut.setCellValue(val);
                            if (j >= lastCell - 3) { suma += val; count++; }
                        }
                    }
                }
                if (count > 0) rOut.createCell(lastCell).setCellValue(suma / count);
            }
            try (FileOutputStream fos = new FileOutputStream(new File(numeOutput)))
            { wbOut.write(fos); }
        } catch (Exception e) { System.out.println(e.getMessage()); }
    }
    public static void genereazaOutputFormula(String numeInput, String numeOutput) {
        try (FileInputStream fis = new FileInputStream(new File(numeInput));
             Workbook wbIn = new XSSFWorkbook(fis);
             Workbook wbOut = new XSSFWorkbook()) {
            Sheet sIn = wbIn.getSheetAt(0);
            Sheet sOut = wbOut.createSheet("Formule");
            for (int i = 0; i <= sIn.getLastRowNum(); i++) {
                Row rIn = sIn.getRow(i);
                Row rOut = sOut.createRow(i);
                if (rIn == null) continue;
                int lastCell = rIn.getLastCellNum();
                for (int j = 0; j < lastCell; j++) {
                    Cell cIn = rIn.getCell(j);
                    Cell cOut = rOut.createCell(j);
                    if (cIn != null) {
                        if (cIn.getCellType() == CellType.STRING)
                            cOut.setCellValue(cIn.getStringCellValue());
                        else if (cIn.getCellType() == CellType.NUMERIC)
                            cOut.setCellValue(cIn.getNumericCellValue());
                    }
                }
                String formula = "AVERAGE(D" + (i + 1) + ":F" + (i + 1) + ")";
                rOut.createCell(lastCell).setCellFormula(formula);
            }
            try (FileOutputStream fos = new FileOutputStream(new File(numeOutput)))
            { wbOut.write(fos); }
        } catch (Exception e) { System.out.println(e.getMessage()); }
    }
}