package com.WebDriverUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections4.iterators.EntrySetMapIterator;
import org.apache.commons.collections4.map.UnmodifiableEntrySet;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mysql.cj.jdbc.Driver;

public class ExcelUtility {
	/**
	 * This method is used to fetch data from ExcelSheet
	 * SheetName
	 * rowNo
	 * cellNo
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws EncryptedDocumentException 
	 * 
	 */
	public String readDataFromExcelSheet(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		Workbook workbook = WorkbookFactory.create(new FileInputStream(IPathconstants.epath));
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		
		
		String data = cell.toString();
		return data;
	}
/**
 * This method is used to write data inside excel sheet
 * sheetName
 * rowNo
 * cellNo
 * value
 * @throws IOException 
 * @throws FileNotFoundException 
 * @throws EncryptedDocumentException 
 * 
 */
	public void writeDataIntoExcel(String sheetName,int rowNo,int cellNo,String value) throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		Workbook workbook = WorkbookFactory.create(new FileInputStream(IPathconstants.epath));
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.createRow(rowNo);
		Cell cell = row.createCell(cellNo);
		cell.setCellValue(value);
		
		FileOutputStream fout = new FileOutputStream(IPathconstants.epath);
		workbook.write(fout);
		workbook.close();
		
		
	}
	/**
	 * This method will fetch count rows created in excel sheet
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws EncryptedDocumentException 
	 * 
	 */
	public int getRowCount(String sheetName) throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		Workbook workbook = WorkbookFactory.create(new FileInputStream(IPathconstants.epath));
		Sheet sheet = workbook.getSheet(sheetName);
		int row = sheet.getLastRowNum();
		return row;
	}
	/**
	 * fetching the data from excel
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 * 
	 */
	public int readDataFromExcelSheet(String sheet) throws Throwable, IOException
	{
		FileInputStream fis = new FileInputStream(IPathconstants.epath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheet);
		int lastRownum = sh.getLastRowNum();
		return lastRownum;
	}
	public HashMap<String, String> getMultipleDataFromExcel(String sheetName, int keyColumn,int valueColumn,WebDriver driver) throws EncryptedDocumentException, IOException
	{
		//fetching the data from excel
		FileInputStream fi = new FileInputStream(IPathconstants.epath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getLastRowNum();
		HashMap<String	, String> map = new HashMap();
		for (int i = 0; i <count; i++)
		{
		String key = sh.getRow(i).getCell(keyColumn).getStringCellValue();
		String value = sh.getRow(i).getCell(valueColumn).getStringCellValue();
		map.put(key, value);	
		}
		/*for(Entry<String, String> s:map.entrySet())
		{
			if(s.getKey().contains(expectedvalue))
			{
				driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
				
			}
			else
			{
				driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
			}
		}*/
		return map;
	}
		public Object[][]  getMultipleSetData(String sheetName) throws Throwable
		{
			FileInputStream fis = new FileInputStream(IPathconstants.epath);
			Workbook book = WorkbookFactory.create(fis);
			Sheet sh1 = book.getSheet(sheetName);
			int lastRow = sh1.getLastRowNum();
			int lastcell = sh1.getRow(0).getLastCellNum();
			
			Object[][] obj = new Object[++lastRow][lastcell];
			
			for (int i = 0; i < lastRow; i++)
			{
			
				for (int j = 0; j <lastcell; j++)
				{
					obj[i][j]=sh1.getRow(i).getCell(j).getStringCellValue();
				}
			}
			
			return obj;
		}
		
		
	}
	

