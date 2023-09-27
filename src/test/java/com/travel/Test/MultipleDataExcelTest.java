package com.travel.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class MultipleDataExcelTest {

	public static void main(String[] args) throws Throwable {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of row do you want to enter the data");
		int row_count=sc.nextInt();
		System.out.println("Enter the number of coloumn   do you want to enter the data");
		int col_count=sc.nextInt();
		String path = "src\\test\\resources\\TestData51.xlsx";
		
		
		//step1: create object for representation of physical file
		
		FileInputStream fis = new FileInputStream(path);
		
		
		// load excel to run time
		
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		
		for (int i = 0; i < row_count; i++) {
			sh.createRow(i);
			
			for (int j = 0; j <col_count; j++)
			{
				System.out.println("Enter the data for "+i+" row and "+j+" cell");
				String celldata = sc.next();
				sh.getRow(j).createCell(j).setCellValue(celldata);
								
				
			}
			
		}
		
		FileOutputStream fos = new FileOutputStream("src\\test\\resources\\TestData51.xlsx");
		wb.write(fos);
		wb.close();

	}

}
