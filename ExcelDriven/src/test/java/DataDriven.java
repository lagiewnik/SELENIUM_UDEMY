import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class DataDriven {

    public ArrayList<String> getTestCase(String testCaseName) {
        ArrayList<String> arr = new ArrayList<String>();
        //fileInputStream argument
        File file;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("src/test/resources/data.xlsx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int sheetsCount = workbook.getNumberOfSheets();

        for (int i = 0; i < sheetsCount; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                //System.out.println(workbook.getSheetName(i));

                Iterator<Row> rows = sheet.iterator();
                Row firstRow = rows.next();

                Iterator<Cell> ce = firstRow.cellIterator();

                int k = 0; //column index
                int column = 0;
                while (ce.hasNext()) {
                    Cell cellValue = ce.next();
                    if (cellValue.getStringCellValue().equalsIgnoreCase("TestCases")) {
                        column = k;
                    }
                    k++;
                }
                System.out.println(column);

                while (rows.hasNext()) {
                    Row r = rows.next();
                    if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)) {
                        //grab all data from this row
                        Iterator<Cell> cv = r.cellIterator();
                        while (cv.hasNext()) {
                            Cell c = cv.next();
                            if (c.getCellTypeEnum() == CellType.STRING) {
                                arr.add(c.getStringCellValue());
                            }
                            else
                            {
                                arr.add(NumberToTextConverter.toText(c.getNumericCellValue()));

                            }
                        }
                    }
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {


    }
}
