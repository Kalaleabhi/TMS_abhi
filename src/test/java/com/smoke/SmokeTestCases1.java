package com.smoke;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SmokeTestCases1 {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://rmgtestingserver/domain/Online_Tourism_Management_System/");
		
		driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
		driver.findElement(By.xpath("//input[@id='email' and @placeholder='Enter your Email']")).sendKeys("anuj@gmail.com");
		
		
		driver.findElement(By.id("password")).sendKeys("Test@123");
		
		driver.findElement(By.xpath("//input[@name='signin']")).click();
		driver.findElement(By.xpath("//a[.='Tour Packages']")).click();
		String expectedvalue = "TMS | Package List";
		String actualvalue = driver.getTitle();
		if(actualvalue.equalsIgnoreCase(expectedvalue))
		{
		System.out.println("Tour packages is displayed");
		
	}
		else {
			System.out.println("Tour packages is not displayed");
		}
		}

}
