package org.wuxinshui.boosters.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class ExcelReadUtil {

    private static Logger log = LoggerFactory.getLogger(ExcelReadUtil.class);

    private static final DecimalFormat numberFormat = new DecimalFormat("0");


    public static <T> List<T> readExcelData(InputStream is, Class<T> clazz) throws Exception {

        log.info("读取Xlsx文件内容-------------");
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        Sheet xssfSheet = xssfWorkbook.getSheetAt(0);
        List<T> dataList = new ArrayList<>(xssfSheet.getLastRowNum());
        try {
            if (null == xssfSheet) {
                return List.of();
            }


            for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                Row xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow != null) {
                    T instance = clazz.getDeclaredConstructor().newInstance();
                    Field[] fields = instance.getClass().getDeclaredFields();


                    for (int i = 0; i < fields.length; i++) {
                        Cell cell = xssfRow.getCell(i);
                        String content = (String) getXlsValue(cell);

                        Field field = fields[i];
                        if (!field.canAccess(instance)) {
                            field.setAccessible(true);
                            field.set(instance, content);
                            field.setAccessible(false);
                        } else {
                            field.set(field, content);
                        }


                    }

                    dataList.add(instance);

                }
            }
        } catch (Exception e) {
            log.error("readXlsx Exception: {}", e);
            throw new Exception("excel 数据格式不正确,请检查!");
        } finally {
            if (null != is) {
                is.close();
            }
        }
        return dataList;
    }

    @SuppressWarnings("static-access")
    public static Object getXlsValue(Cell xssfRow) {
        if (null != xssfRow) {
            if (xssfRow.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {
                return String.valueOf(xssfRow.getBooleanCellValue());
            } else if (xssfRow.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
                return numberFormat.format(xssfRow.getNumericCellValue());
            } else {
                return String.valueOf(xssfRow.getStringCellValue());
            }
        }
        return null;
    }

}
