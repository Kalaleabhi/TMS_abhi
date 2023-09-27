package com.travel.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcel {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData51.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("location");
		sh.createRow(9).createCell(0).setCellValue("wipro");
		sh.getRow(9).createCell(1).setCellValue("mysore");
		
	 FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData51.xlsx");
	 wb.write(fos);
	 wb.close();

	}

}
