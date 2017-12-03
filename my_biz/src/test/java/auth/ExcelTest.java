package auth;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.aspectj.weaver.ast.Var;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelTest {
    @Test
    public void excelTest() throws IOException {

//        FileInputStream stream = new FileInputStream("classpath:excel/template.xlsx");
        FileInputStream stream = new FileInputStream("D:\\IdeaProjects\\my_root\\my_biz\\src\\test\\resources\\excel\\template.xlsx");
        Workbook workbook = new XSSFWorkbook(stream);
        Sheet sheet = workbook.getSheetAt(0);
        if (null == sheet){
            System.out.println("整包不存在");
            return;
        }
        Row row = sheet.getRow(2);
        String value = row.getCell(0).getStringCellValue();
        System.out.println(value);
        row.getCell(1).setCellValue("刘毅");
        FileOutputStream outputStream = new FileOutputStream("D:\\123.xlsx");
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

    }
}
