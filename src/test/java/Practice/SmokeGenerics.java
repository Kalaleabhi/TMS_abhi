package Practice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.WebDriverUtils.DatabaseUtility;
import com.WebDriverUtils.ExcelUtility;
import com.WebDriverUtils.JavaUtility;
import com.WebDriverUtils.PropertyFileUtility;
import com.WebDriverUtils.WebdriverUtility;

public class SmokeGenerics {

	public static void main(String[] args) throws Throwable {
		
		
		DatabaseUtility dLib = new DatabaseUtility(); 
		PropertyFileUtility fLib = new PropertyFileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebdriverUtility wLib = new WebdriverUtility();
		
		
		
		
		ChromeDriver driver = new ChromeDriver();
		wLib.maximizeTheBrowser(driver);
		wLib.implicitWait(driver,10);
           String URL = fLib.getPropertyKeyValues("url");
           String ADMIN = fLib.getPropertyKeyValues("username");
           String PASSWORD = fLib.getPropertyKeyValues("password");

		driver.get("http://rmgtestingserver/domain/Online_Tourism_Management_System/");
		driver.findElement(By.xpath("//a[.='Admin Login']")).click();
		driver.findElement(By.name("username")).sendKeys(ADMIN);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
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
