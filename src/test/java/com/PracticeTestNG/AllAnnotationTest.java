package com.PracticeTestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AllAnnotationTest {
	
	@Test
	public void sample()
	{
		System.out.println("--TestScript--1--");
	}
	
	@BeforeSuite
	public void configBS()
	{
		System.out.println("-- connecet to the DataBase");
	}
	
	@BeforeClass
	public void configBC()
	{
		System.out.println("--launch the browser--");

	}
	
	@BeforeMethod
	public void configBM()
	{
		System.out.println("--login to the application--");
	}
	
	@AfterMethod
	public void configAM()
	{
		System.out.println("--logout from the application--");
	}
	
	@AfterSuite
	public void configAS()
	{
		System.out.println("--disconnect from the DataBase");
	}
	
	@AfterClass
	public void configAC()
	{
		System.out.println("--close the browser--");
	}
	
	@Test
public void demo()
{
	System.out.println("--TestScript--2--");
}
	
	@Test
	public void punter()
	{
		System.out.println("--TestScript--3--");
	}
	
}
