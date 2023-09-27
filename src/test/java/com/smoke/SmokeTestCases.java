package com.smoke;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SmokeTestCases {

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://rmgtestingserver/domain/Online_Tourism_Management_System/");
		driver.findElement(By.xpath("//a[.='Admin Login']")).click();
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("Test@123");
		driver.findElement(By.xpath("//input[@class='login']")).click();
		
	//to get the title of the page and validate login
		String expectedtitle = "TMS | Admin Dashboard";
		String actualtitle = driver.getTitle();
		if(actualtitle.equalsIgnoreCase(expectedtitle))
			System.out.println("login successfull and passed");
		else {
			System.out.println("login unsuccessful and failed");
		}
		
			
		driver.quit();

	}

}
