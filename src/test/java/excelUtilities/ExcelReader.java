package excelUtilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    public static List<List<String>> getData(String path , String sheetName, int number){
        List<List<String>> data=new ArrayList<>();
        try {
            FileInputStream inputStream=new FileInputStream(path);
            Workbook workbook= WorkbookFactory.create(inputStream);
            Sheet sheet= workbook.getSheet(sheetName);

            for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++){
                List<String> rowData=new ArrayList<>();
                for (int j = 0; j < number; j++) {
                    rowData.add(sheet.getRow(i).getCell(j).toString());
                }
                data.add(rowData);
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    public static void writeToExcel(String path ,String testName,String testResult){
        File file=new File(path);
        if (file.exists()){
            try {
                FileInputStream inputStream = new FileInputStream(path);
                Workbook workbook = WorkbookFactory.create(inputStream);
                Sheet sheet = workbook.getSheetAt(0);

                int endRow = sheet.getPhysicalNumberOfRows();
                Row newRow = sheet.createRow(endRow);
                Cell newCell = newRow.createCell(0);
                newCell.setCellValue(testName);

                newCell = newRow.createCell(1);
                newCell.setCellValue(testResult);

                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            try {
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("Sheet1");

                Row newRow = sheet.createRow(0);
                Cell newCell = newRow.createCell(0);
                newCell.setCellValue(testName);

                newCell = newRow.createCell(1);
                newCell.setCellValue(testResult);


                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
