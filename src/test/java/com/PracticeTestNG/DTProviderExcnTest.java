package com.PracticeTestNG;

import org.testng.annotations.Test;

public class DTProviderExcnTest {
	
	@Test(dataProviderClass = DataProviderTest.class,dataProvider  = "dataFromexcel")
	
	public void getData(String pName, String price, String size)
	{
		System.out.println(pName+"  "+price+" "+size);
		
	}

}
