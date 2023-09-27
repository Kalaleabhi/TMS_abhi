package com.travel.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Goibibo_calenderTest1 {

	public static void main(String[] args) throws InterruptedException {
		String month="September 2023";
		int date=1;
		
WebDriver driver1=new FirefoxDriver();
		
		driver1.manage().window().maximize();
			
			driver1.get("https://www.goibibo.com/");
			
			driver1.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			
			driver1.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
			driver1.findElement(By.xpath("//span[text()='Departure']")).click();
			String actualDate="//div[.='"+month+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+date+"']";
			String next="//span[@aria-label='Next Month']";
			for(;;)
			{
				try
				{
					driver1.findElement(By.xpath(actualDate)).click();
					break;
			
				}
				catch (Exception e) {
					driver1.findElement(By.xpath(next)).click();
				}
			}
			driver1.findElement(By.xpath("//span[text()='Done']")).click();
			Thread.sleep(5000);
			driver1.quit();
			
			
			
			
	}

}
