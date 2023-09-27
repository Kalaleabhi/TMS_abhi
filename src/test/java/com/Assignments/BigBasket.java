package com.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BigBasket {

	public static void main(String[] args) throws InterruptedException {
	
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bigbasket.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(5000);
	  driver.findElement(By.xpath("//button[@id='headlessui-menu-button-:R5bclm:']")).click();
	 WebElement ele = driver.findElement(By.xpath("//ul[@class='jsx-1259984711 w-56 px-2.5 bg-darkOnyx-800 text-silverSurfer-100 rounded-l-xs']/following::li[@class='jsx-1259984711']/descendant::a[.='Kitchen, Garden & Pets']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		

	}

}
