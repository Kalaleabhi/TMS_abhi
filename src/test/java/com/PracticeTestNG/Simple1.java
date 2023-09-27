package com.PracticeTestNG;

import org.testng.annotations.Test;

public class Simple1 {
	
	@Test(groups = {"regression" , "smoke"})
	public void simpletest()
	{
		System.out.println("--Simple1--");
	}
	@Test(groups = "smoke")
	public void puntertest()
	{
		System.out.println("--punter--");
	}
	@Test(groups ="regional")
	public void tester() 
	{
	System.out.println("tester");	
	}

}
