package com.travel.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class KSRTC_calenderTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver1=new FirefoxDriver();
		
	driver1.manage().window().maximize();
		
		driver1.get("https://www.ksrtc.in/oprs-web/");
		
		driver1.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver1.findElement(By.id("txtJourneyDate")).click();
		
		driver1.findElement(By.xpath("//div[@id='ui-datepicker-div']/descendant::a[text()='31']")).click();
		
		Thread.sleep(2000);
		driver1.quit();
		

	}

}
