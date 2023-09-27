package com.travel.Test;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {

	public static void main(String[] args) throws Throwable {
		
		String path="src\\test\\resources\\TestData51.xlsx";
		FileInputStream fis = new FileInputStream(path);
		
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("location");
		int count= sh.getLastRowNum();
		 int lastcell=sh.getRow(1).getLastCellNum();
		
		for (int i = 1; i <= count; i++)
		{
			
			for (int k = 0; k <lastcell; k++)
			{
			
		String value = sh.getRow(i).getCell(k).getStringCellValue();
		System.out.print(value+"   ");
			
		}
   System.out.println();
		}
	}

}
