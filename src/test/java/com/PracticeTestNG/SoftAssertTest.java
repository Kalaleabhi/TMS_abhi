package com.PracticeTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {
@Test
	public void Softasserttest()
	{
	String exp = "Tourism Management System";
	WebDriver driver = new ChromeDriver();
	driver.get("http://rmgtestingserver/domain/Online_Tourism_Management_System");
	String actual  = driver.getTitle();
	System.out.println(actual);
	SoftAssert sa = new SoftAssert();
	sa.assertEquals(actual, exp);
	System.out.println("--application launched--");
	
	
		
	}
	
}
