package com.PracticeTestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.WebDriverUtils.ExcelUtility;

public class Practice1 {

	@DataProvider
	public Object[][] getExcelFData() throws Throwable
	{
		ExcelUtility eLib = new ExcelUtility();
		Object[][] res = eLib.getMultipleSetData("newDP");
		return res;
	}
	
	@Test(dataProvider ="getExcelFData" )
	public void dataSetTest(String pName,String price,String cc,String brand,String kmph,String color)
	{
		System.out.println(pName+">>>>>"+price+">>>>>>"+cc+">>>>>>>"+brand+">>>>>>"+kmph+">>>>>>>"+color);
	}
	
}
