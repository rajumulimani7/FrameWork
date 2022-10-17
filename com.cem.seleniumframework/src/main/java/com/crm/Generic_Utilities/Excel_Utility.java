package com.crm.Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class Excel_Utility {
	/**
	 * 
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * @author Raju
	 */
	
	public String grtExcelValue(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fin=new FileInputStream("./workbook.xlsx");
		Workbook book = WorkbookFactory.create(fin);
		String data = book.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		return data;
	}

}
