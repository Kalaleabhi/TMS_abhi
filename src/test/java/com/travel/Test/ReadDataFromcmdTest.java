package com.travel.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ReadDataFromcmdTest {
	@Test
	public void cmdTest()
	{
	String browser = System.getProperty("browser");
	String url = System.getProperty("url");
	String username = System.getProperty("username");
	String password = System.getProperty("password");
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();

	driver.get(url);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.findElement(By.xpath("//a[text()='Admin Login']")).click();
	
	driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
	
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	
	driver.findElement(By.xpath("//input[@class='login']")).click();
	
	driver.quit();
		
	}

}

