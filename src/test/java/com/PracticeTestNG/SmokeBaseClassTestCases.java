package com.PracticeTestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.WebDriverUtils.BaseClass;

public class SmokeBaseClassTestCases extends BaseClass

{
@Test(groups = {"smoke", "regression"})
	public void demo()
	{
		System.out.println("--admin login successfull--");
	}


	}


