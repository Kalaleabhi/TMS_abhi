package com.travel.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Goibibo_calenderTest {

	public static void main(String[] args) throws InterruptedException {
		
		String month="September 2023";
		int date=1;
	
		WebDriver driver1=new FirefoxDriver();
		
		driver1.manage().window().maximize();
			
			driver1.get("https://www.goibibo.com/");
			
			driver1.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			
			driver1.findElement(By.xpath("//span[@class=/logSprite icClose']")).click();
			driver1.findElement(By.xpath("//span[text()='Departure']")).click();
			driver1.findElement(By.xpath("//div[.='"+month+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+date+"']")).click();
			driver1.findElement(By.xpath("//span[text()='Done']")).click();
			Thread.sleep(2000);
			driver1.quit();
			
			

	}

}
