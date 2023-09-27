package com.PracticeTestNG;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.WebDriverUtils.ExcelUtility;
import com.WebDriverUtils.IPathconstants;

public class DataProviderTest {
	
	@Test(dataProvider = "tv")
	public void getData(String productName, int price, String size)
	{
		System.out.println(productName+"  "+price+"  "+size);
	}
	
	@DataProvider
	
	public Object[][] mobiles()
	{
		Object[][] obj = new Object[2][2];
		
		obj[0][0] = "Sumsung";
        obj[0][1]= 10000;		
        
        obj[1][0]="Redmi";
        obj[1][1]= 15000;
        
        return obj;
		
	}
	
	@DataProvider
	
	public Object[][] tv()
	{
  Object[][] obj = new Object[2][3];
  
  obj[0][0]="LG";
  obj[0][1]= 40000;
  obj[0][2]= "45 inch";
  
  
  obj[1][0]= "Sony";
  obj[1][1]=15000;
  obj[1][2]="55 inch";
  
  return obj;
  
	}
	
	@DataProvider
	 
	public Object[][] dataFromExcel() throws Throwable, IOException

	{
		FileInputStream fis = new FileInputStream(IPathconstants.epath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("DP");
		int lastrow = sh.getLastRowNum()+1;
		int lastcell = sh.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[lastrow][lastcell];
		for (int i = 0; i < lastcell; i++)
		{
		for (int j = 0; j < lastcell; j++)
		{
		obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();	
		}
		}
		return obj;
	}
		
		
		@DataProvider
		public Object[][] dataFromexcel() throws Throwable
		{
		
		ExcelUtility eLib = new ExcelUtility();	
		Object[][] value = eLib.getMultipleSetData("DP");
		
		return value;
		
		
		}
		
		
		
	}
	
	
	
	


