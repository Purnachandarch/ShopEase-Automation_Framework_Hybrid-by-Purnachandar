
package com.shopease.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

    public static Object[][] getExcelData(
            String filePath, String sheetName) throws IOException {

        FileInputStream file = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(file);

        Sheet sheet = workbook.getSheet("Sheet1");

        int rowCount = sheet.getLastRowNum();
        int columnCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount][columnCount];

        DataFormatter formatter = new DataFormatter();

        for (int i = 1; i <= rowCount; i++) {

            Row row = sheet.getRow(i);

            for (int j = 0; j < columnCount; j++) {
                data[i - 1][j] =
                        formatter.formatCellValue(row.getCell(j));
            }
        }

        workbook.close();
        file.close();

        return data;
    }
}
