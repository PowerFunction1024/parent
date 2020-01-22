/*
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

*/
/**
 * 通用json获取工具
 *//*

public class Test {


    public static void main(String[] args){
        List<ApiDto> list = new ArrayList<>();
        ApiDto apiDto1 = new ApiDto("1","2","3","42222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222","5","6","186ms","8","9");
        ApiDto apiDto2 = new ApiDto("1","2","3","4","5","6","822ms","8","9");
        ApiDto apiDto3 = new ApiDto("1","2","asd","4","5","6","456ms","8","9");
        list.add(apiDto1);
        list.add(apiDto2);
        list.add(apiDto3);
        //Workbook就是在内存中的Excel对应的对象
        Workbook wb = ExcelExportUtil.exportExcel(new ExportParams("dnc_test","test"),
                ApiDto.class, list);

        //获取到你这个Excel的长和宽

        Sheet sheet = wb.getSheetAt(0);
//        sheet.autoSizeColumn((short)0); //调整第一列宽度
//        sheet.autoSizeColumn((short)1); //调整第二列宽度
//        sheet.autoSizeColumn((short)3); //调整第二列宽度
//        sheet.autoSizeColumn((short)4); //调整第二列宽度

//
//        autoSizeColumn;// 自动调整列宽 要求poi3.0以上
        Row row = sheet.getRow(0);
        int rowNum = sheet.getLastRowNum();
        int colNum = row.getPhysicalNumberOfCells();

        //创建字体对象，注意这不是awt包下的，是poi给我们封装了一个
        Font font = wb.createFont();
        font.setBold(true);
        short index = HSSFColor.HSSFColorPredefined.RED.getIndex();
        font.setColor(index);
        font.setFontHeightInPoints((short) 12);
        font.setFontName("宋体");

        //效率非常低的二次循环遍历
        for (int i = 1; i <= rowNum; i++) {
            row = sheet.getRow(i);
            int j = 0;
            while (j < colNum) {
                //这里我们就获得了Cell对象，对他进行操作就可以了
                Cell cell = row.getCell((short) j);
                String value = row.getCell((short) j).toString();
                value = value.trim();
                if(value.endsWith("ms")){
                    Integer time = Integer.parseInt(value.substring(0,value.length()-2));
                    HSSFCellStyle style = (HSSFCellStyle) wb.createCellStyle();
                    style.setAlignment(HorizontalAlignment.CENTER);
//                    style.setWrapText(true);//自动换行

                    style.setFont(font);
                    cell.setCellStyle(style);
                }
                j++;
            }
        }

        //把内存中的Excel写到磁盘中去
        File file = new File("E:/test.xls");
        if(file.exists()){
            file.delete();
        }
        try {
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            wb.write(fileOutputStream);
            System.out.println("xls文件写入成功，地址:"+file.getAbsolutePath());
            wb.close();
        } catch (IOException e) {
            System.out.println("xls文件写入失败，地址:"+file.getAbsolutePath());
            e.printStackTrace();
        }
    }




}

*/
