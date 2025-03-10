package com.shopifyapptest.utility;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class utility {
    public static String getCellData(int RowNum, int ColNum) throws EncryptedDocumentException, IOException {

        FileInputStream file = new FileInputStream("E:\\SOS_TD.xlsx");
        Workbook a = WorkbookFactory.create(file);
        Sheet s = a.getSheet("Sheet1");
        Row r = s.getRow(RowNum);
        Cell c = r.getCell(ColNum);
        String value = c.getStringCellValue();
        return value;

    }
}
