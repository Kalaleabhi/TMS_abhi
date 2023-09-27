package com.travel.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MakemytripTest {

	public static void main(String[] args) throws InterruptedException {
WebDriver driver1=new FirefoxDriver();
		
		driver1.manage().window().maximize();
			
			driver1.get("https://www.makemytrip.com/");
			
			driver1.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

			Actions a = new Actions(driver1);
			a.doubleClick().perform();
			Thread.sleep(2000);
		//	WebElement close = driver1.findElement(By.xpath("//a[@class='close']"));
		//	a.moveToElement(close).click().perform();
			a.moveByOffset(0, 80).click().perform();
			Thread.sleep(2000);
		
			driver1.findElement(By.xpath("//span[.='Departure']")).click();
			driver1.findElement(By.xpath("//div[text()='September 2023']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='12']")).click();
			driver1.close();
			
	}

}
