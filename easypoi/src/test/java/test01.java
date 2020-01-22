import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class test01 {
    //需求:使用POI可以从一个已经存在的Excel文件中读取数据


    @Test
    public void fun01() throws IOException {

        //1 创建工作簿对象
        XSSFWorkbook workbook = new XSSFWorkbook("C:\\Users\\_xu_\\Desktop\\read.xlsx");

        //2 获得工作表对象
        XSSFSheet sheetAt = workbook.getSheetAt(0);

        //3 遍历工作表 获得行对象
        for (Row cells : sheetAt) {
            //4 遍历行对象 获得列对象
            for (Cell cell : cells) {
        //5 获得列里面的内容
                System.out.println(cell.getStringCellValue());
            }
        }
        //6.关闭
        workbook.close();
    }

    @Test
    public void fun02() throws IOException {
        //使用POI可以在内存中
        // 创建一个Excel文件并将数据写入到这个文件，
        //最后通过输出流将内存中的Excel文件下载到磁盘

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        XSSFRow row = sheet.createRow(0);
        row.createCell(1).setCellValue("1");
        row.createCell(2).setCellValue(2);

        XSSFRow row2 = sheet.createRow(1);
        row2.createCell(1).setCellValue("3");
        row2.createCell(2).setCellValue(4);

        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\_xu_\\Desktop\\1.xlsx");
        workbook.write(fileOutputStream);

        fileOutputStream.close();
        workbook.close();

    }
}
