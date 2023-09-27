package com.Integration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.ObjectRepository.HomePage;

public class IntegrationTestCase1 {

	public static void main(String[] args) throws InterruptedException, Throwable {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://rmgtestingserver/domain/Online_Tourism_Management_System/");
		
		
		
	/*	WebDriver driver=null;
		//Fetch the common data using property file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\com.properties");
		
		Properties pobj = new Properties();
		
		pobj.load(fis);
		String BROWSER = pobj.getProperty("browser");
		 String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		
		// read the data from Excel sheet
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TestData51.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Sheet1");
		int count=sh.getLastRowNum();
		
		// launch the browser 
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new ChromeDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		

		driver.manage().window().maximize();
		
		// enter the url
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));*/
		
		//enter valid username and password
		
	

		driver.findElement(By.xpath("//a[.='Admin Login']")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test@123");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		String bookingId = "#BK-21";
		driver.findElement(By.xpath("//span[.='Manage Booking']")).click();
		WebElement ele = driver.findElement(By.xpath("//table/tbody/tr/td[1]/span[text()='"+bookingId+"']"));
		Actions a = new Actions(driver);
		a.moveToElement(ele).perform();
		List<WebElement> allele = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		//	System.out.println(elem.size());
		for (int i = 0; i < allele.size(); i++)
		{
			if(bookingId.contains(allele.get(i).getText()))	
			{
				//System.out.println(i);
				a.click(driver.findElement(By.xpath("//table/tbody/tr/td[1]/span[text()='"+bookingId+"']/parent::td/following-sibling::td[8]/descendant::a[2]"))).perform();
				driver.switchTo().alert().accept();
				driver.findElement(By.xpath("//div[@class='succWrap' and contains(text(),':Booking Confirm successfully')]"));
				break;
			}
		}
		driver.findElement(By.xpath("//i[@class='fa fa-angle-down']")).click();
		driver.findElement(By.xpath("//i[@class='fa fa-sign-out']")).click();
		driver.findElement(By.xpath("//a[text()='Back to home']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
		driver.findElement(By.xpath("//h3[text()='Signin with your account ']/following-sibling::input[@name='email']")).sendKeys("anuj@gmail.com");
		driver.findElement(By.xpath("//h3[text()='Signin with your account ']/following-sibling::input[@name='password']")).sendKeys("Test@123");
		driver.findElement(By.xpath("//input[@name='signin']")).click();
		driver.findElement(By.xpath("//a[text()='My Tour History']")).click();
		a.moveToElement(driver.findElement(By.xpath("//div[@class='copy-right']"))).perform();
		List<WebElement> allstatus = driver.findElements(By.xpath("//table/tbody/tr/td[7]"));
		boolean flag = false;
		for (int i = 0; i < allstatus.size(); i++)
		{
			if(i==allstatus.size()-1)
			{
				flag=true;
				break;
			}
		}

		if(flag)
			System.out.println("the admin confirmed booking is updating in 'My tour history' model of user and test case pass");
		else
		{
			System.out.println("admin confirmed booking is not get updating in 'My tour history' of user model test case fail");
		}
		a.scrollToElement(driver.findElement(By.xpath("//a[contains(text(),'Logout')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		driver.quit();

	}

}




