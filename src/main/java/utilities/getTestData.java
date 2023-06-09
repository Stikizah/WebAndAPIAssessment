package utilities;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class getTestData {

    public static Object[][] getTestDataFromExcel(String sheetName)
    {
        XSSFWorkbook workbook = null;
        File excelFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\testData\\testData.xlsx");
        try {
            FileInputStream fisExcel = new FileInputStream(excelFile);
            workbook = new XSSFWorkbook(fisExcel);
        }catch (Throwable e){
            e.getMessage();
            e.printStackTrace();
        }

        XSSFSheet sheet = workbook.getSheet(sheetName);

        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rows][cols];

        for (int i=0; i<rows; i++)
        {
            XSSFRow row = sheet.getRow(i+1);

            for (int j=0;j<cols;j++)
            {
                XSSFCell cell = row.getCell(j);
                CellType cellType = cell.getCellType();

                switch (cellType){
                    case STRING:
                        data[i][j] = cell.getStringCellValue();
                        break;
                    case NUMERIC:
                        data[i][j] = Integer.toString((int)cell.getNumericCellValue());
                        break;
                    case BOOLEAN:
                        data[i][j] = cell.getBooleanCellValue();
                        break;

                }
            }
        }
        return data;
    }
}
