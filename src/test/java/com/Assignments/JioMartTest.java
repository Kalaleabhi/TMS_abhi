package com.Assignments;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JioMartTest {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.jiomart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(5000);
		String ele = driver.findElement(By.cssSelector("a:hover")).getText();
		System.out.println("selected category: "+ele);
		List<WebElement> allitems = driver.findElements(By.xpath("//a[text()='"+ele+"']/following-sibling::div[@class='header-nav-l3-wrapper']/descedant::li"));
		System.out.println("the items present in selected category");
		for (WebElement e : allitems)
		{
			System.out.println(e.getText());
		}
		driver.quit();
	}

}
