package avci.murat.step_definitions;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExelTask {

    @Test
    public static void exelTask(){
        String filePath = "C:\\Users\\murat\\OneDrive\\Belgeler\\SaatTaskExel.xlsx";
        int columnIndexA = 0;// A kolonu için
        int columnIndexB = 1;// B kolonu için

        //yazılacak exel dosyasının  bilgileri
        String filePathW = "C:\\Users\\murat\\OneDrive\\Belgeler\\SaatTaskExelW.xlsx";
        String sheetName = "Sheet1";
        int rowCount = 0; // Verilerin yazılacağı satırın indeksi
        int columnIndex = 0; // Verilerin yazılacağı sütunun indeksi
        Workbook workbookW = new XSSFWorkbook();//verilerin dosyaya yazılmasını sağlayacak çalışmaKtabını hazırlar
        Sheet sheetW = workbookW.createSheet(sheetName);//Çalışma sayfasını hazırlar
        //---------------------------------------------

        try (FileInputStream fis = new FileInputStream(filePath)) {//Exel dosyasından okuma
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet("Sayfa1");
            if (sheet == null) {//Exel dosyasında ilgili çalışma sayfası yoksa
                System.out.println("Belirtilen sayfa bulunamadı.");
                System.exit(1);
            }
            for (Row row : sheet) {
                Cell cellA = row.getCell(columnIndexA);//kaynak exel dosyasının A sütunundaki veriyi okur
                Cell cellB = row.getCell(columnIndexB);//B sütunundaki veriyi okur
                if (cellA != null) {
                    int cellValueB = (int) cellB.getNumericCellValue();//hücredeki nümerik değeri int değerine dönüştürür
                    if (isPrimeNumber(cellValueB)) {//Okunan değerin asal olup olmadığını kontrol eder
                        //eğer değer asal ise
                        // Yeni Exel dosyasına veri yazma
                        Row rowWA = sheetW.createRow(rowCount);
                        Cell cell = rowWA.createCell(columnIndex);
                        Cell cellWB = rowWA.createCell(1);
                        cell.setCellValue(cellA.getRichStringCellValue());//kaynak dosyadaki harf
                        cellWB.setCellValue( cellValueB);//kaynak dosyadaki asal sayı
                        rowCount++; //sonraki satıra geçer
                    }
                }
            }
            try (FileOutputStream fos = new FileOutputStream(filePathW)) {
                workbookW.write(fos);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    workbookW.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static boolean isPrimeNumber(int num){
        boolean result=true;
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= num/2; i++) {
            if (num%i==0) return false;
        }
        return result;
    }
}
