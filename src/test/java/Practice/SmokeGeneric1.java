package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.WebDriverUtils.DatabaseUtility;
import com.WebDriverUtils.ExcelUtility;
import com.WebDriverUtils.JavaUtility;
import com.WebDriverUtils.PropertyFileUtility;
import com.WebDriverUtils.WebdriverUtility;

public class SmokeGeneric1 {

	public static void main(String[] args) {
		DatabaseUtility dLib = new DatabaseUtility(); 
		PropertyFileUtility fLib = new PropertyFileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebdriverUtility wLib = new WebdriverUtility();

		ChromeDriver driver = new ChromeDriver();
		//	driver.manage().window().maximize();
		wLib.maximizeTheBrowser(driver);

		wLib.implicitWait(driver,10);
		//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://rmgtestingserver/domain/Online_Tourism_Management_System/");

		driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
		driver.findElement(By.xpath("//input[@id='email' and @placeholder='Enter your Email']")).sendKeys("anuj@gmail.com");


		driver.findElement(By.id("password")).sendKeys("Test@123");

		driver.findElement(By.xpath("//input[@name='signin']")).click();
		driver.findElement(By.xpath("//a[.='Tour Packages']")).click();
		String expectedvalue = "TMS | Package List";
		String actualvalue = driver.getTitle();
		if(actualvalue.equalsIgnoreCase(expectedvalue))
		{
			System.out.println("Tour packages is displayed");

		}
		else {
			System.out.println("Tour packages is not displayed");
		}
	}
}

