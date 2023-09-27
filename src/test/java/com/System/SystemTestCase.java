package com.System;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SystemTestCase {

	public static void main(String[] args) throws InterruptedException, Throwable {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(3000);
		driver.get("http://rmgtestingserver/domain/Online_Tourism_Management_System/");
		
		//user login code 
		driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
		driver.findElement(By.xpath("//h3[.='Signin with your account ']/following-sibling::input[@name='email']")).sendKeys("anuj@gmail.com");
		driver.findElement(By.xpath("//h3[.='Signin with your account ']/following-sibling::input[@name='password']")).sendKeys("Test@123");
		driver.findElement(By.xpath("//input[@name='signin']")).click();
		
		//to book the tour packages
		
		String packname = "Package Name: Kerla";
		String fromMonth = "September";
		int fromYear = 2023;
		int fromDate = 20;
		String toMonth = "October";
		int toYear = 2023;
		int toDate = 10;
		driver.findElement(By.xpath("//a[.='Tour Packages']")).click();
		driver.findElement(By.xpath("//h4[text()='"+packname+"']/ancestor::div[@class='rom-btm']/descendant::a")).click();
		driver.findElement(By.id("datepicker")).click();
		for(;;)
		{
			try {
				driver.findElement(By.xpath("//span[.='"+fromMonth+"']//span[.='September']/following-sibling::span[.='"+fromYear+"']/ancestor::div[@id='ui-datepicker-div']/descendant::a[@class='ui-state-default' and text()='"+toDate+"']")).click();
				break;
			}
			catch (Exception e) {
				
				driver.findElement(By.xpath("//a[@data-handler='next']")).click();
			}
		}
		driver.findElement(By.id("datepicker1")).click();
		for(;;)
		{
			try {
				driver.findElement(By.xpath("//span[.='"+toMonth+"']/following-sibling::span[.='"+toYear+"']/ancestor::div[@id='ui-datepicker-div']/descendant::a[@class='ui-state-default' and text()='"+toDate+"']")).click();
		break;
			}
			catch (Exception e)
			{
				driver.findElement(By.xpath("//a[@data-handler='next']")).click();
			}
		}
		
		
		String comment="Hello";
		WebElement ele = driver.findElement(By.xpath("//input[@name='comment']"));
		Actions a = new Actions(driver);
		a.scrollToElement(ele).perform();
		ele.sendKeys(comment);
		driver.findElement(By.xpath("//button[.='Book']")).click();
		String text = driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
		System.out.println(text);
		
		if(text.contains("SUCCESS:Booked Successfully"))
		System.out.println("the package booking request generated successfully");
		else
			System.out.println("the package booking request is not  generated successfully");
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		
		
		//admin login code
		driver.findElement(By.xpath("//a[.='Admin Login']")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test@123");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		driver.findElement(By.xpath("//span[.=' Tour Packages']")).click();
		driver.findElement(By.xpath("//a[.='Create']")).click();
		
		
		//to read the data from the excel file to create your package
		
		String path = "\\src\\test\\resources\\TestData51.xlsx";
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int row_count=sh.getLastRowNum();
		HashMap<String, String> map = new HashMap<>();
		for (int i = 1; i < row_count; i++)
		{
		String key = sh.getRow(i).getCell(0).getStringCellValue();
		String value = sh.getRow(i).getCell(1).getStringCellValue();
		map.put(key, value);
		}
		for(Entry<String, String> set:map.entrySet())
		{
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
			
		File f = new File("");
		String imgpath = f.getAbsolutePath();
		driver.findElement(By.xpath("//input[@='packageimage']")).sendKeys(imgpath);
		WebElement createBtn = driver.findElement(By.xpath("//button[text()='Create']"));
		Actions a1 = new Actions(driver);
		a1.scrollToElement(createBtn).perform();
		a1.click(createBtn).perform();
		String expctedRes = "SUCCESS:Package Created Successfully";
		String actualRes = driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
		if(actualRes.contains(expctedRes))
			System.out.println("Package Created Successsfully");
		else
		{
		System.out.println("Package is not Created Successsfully");		
		driver.findElement(By.xpath("//span[.=' Tour Packages']")).click();
		driver.findElement(By.xpath("//a[text()='Manage']")).click();
		String modifyPackName = "South India Tour";
		WebElement modifica = driver.findElement(By.xpath("//span[@class='bt-content' and text()='"+modifyPackName+"']"));
		a.scrollToElement(modifica).perform();
		driver.findElement(By.xpath("//span[@class='bt-content' and text()='"+modifyPackName+"']/ancestor::tr/descendant::button[text()='View Details']")).click();
		String modificationFieldname = "packageprice";
		String modificationvalue = "500";
		driver.findElement(By.xpath("//input[@name='"+modificationFieldname+"']")).clear();
		driver.findElement(By.xpath("//input[@name='"+modificationFieldname+"']")).sendKeys(modificationvalue);
		WebElement updateBtn = driver.findElement(By.xpath("//button[text()='Upadate']"));
		a.scrollToElement(updateBtn).perform();
		a.click(updateBtn).perform();
		String expectedUpdatedValue = "SUCCESS:Package Updated Successfully";
		String actualUpdatedValue = driver.findElement(By.xpath("//div[@class='succWrap']")).getText();
		if(actualUpdatedValue.contains(expectedUpdatedValue))
		{
			System.out.println("the package details are updated succesfully");
		}
		else 
			{
				System.out.println("unable to update the package details");
			
			}
				
		//to confirm the booking request
		
		
		
		
		
		
		
		
		
		
		
		
		}
				}
				
		


	}


