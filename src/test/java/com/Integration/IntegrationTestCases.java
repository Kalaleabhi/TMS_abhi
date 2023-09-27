package com.Integration;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IntegrationTestCases {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(5000);

		driver.get("http://rmgtestingserver/domain/Online_Tourism_Management_System/");

		driver.findElement(By.linkText("Enquiry")).click();

		driver.findElement(By.xpath("//form[@name='enquiry']/descendant::input[@name='fname']")).sendKeys("ABC");

		driver.findElement(By.xpath("//form[@name='enquiry']/descendant::input[@name='email']")).sendKeys("Abc@gmail.com");

		driver.findElement(By.xpath("//form[@name='enquiry']/descendant::input[@name='mobileno']")).sendKeys("9874563210");

		driver.findElement(By.xpath("//form[@name='enquiry']/descendant::input[@name='subject']")).sendKeys("Regarding package");

		driver.findElement(By.xpath("//form[@name='enquiry']/descendant::textarea[@name='description']")).sendKeys("Need more offers to the packages");

		driver.findElement(By.xpath("//form[@name='enquiry']/descendant::button[@name='submit1']")).click();

		driver.findElement(By.linkText("Admin Login")).click();

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test@123");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		driver.findElement(By.xpath("//span[.='Manage Enquiries']")).click();

		List<WebElement> allEnq = driver.findElements(By.xpath("//table[@id='table']/descendant::td[@data-th='Name']"));
		String expectedRes = "anuj";
		boolean flag = false;
		for (WebElement e : allEnq)
		{
			String actualResult = e.getText();	
			if(actualResult.equalsIgnoreCase(expectedRes)) {
				flag=true;
				break;

			}
		}
		if(flag)
		{
			System.out.println("the enquiry is successfully generated and pass");
		}
		else

			System.out.println("the enquiry is not generated and fail");
		driver.findElement(By.xpath("//i[@class='fa fa-angle-down']")).click();
		driver.findElement(By.xpath("//i[@class='fa fa-sign-out']")).click();
	}

}




