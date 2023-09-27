package Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.WebDriverUtils.DatabaseUtility;
import com.WebDriverUtils.ExcelUtility;
import com.WebDriverUtils.JavaUtility;
import com.WebDriverUtils.PropertyFileUtility;
import com.WebDriverUtils.WebdriverUtility;

public class CreateConUsingGenerics {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver=null;
		
		DatabaseUtility dLib = new DatabaseUtility(); 
		PropertyFileUtility fLib = new PropertyFileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebdriverUtility wLib = new WebdriverUtility();
		
		
		
		// Writing Data
		Properties prop = new Properties();
		prop.setProperty("username", "admin");
		prop.setProperty("password", "Test@123");
		prop.setProperty("url", "http://rmgtestingserver/domain/Online_Tourism_Management_System/admin/index.php");
		prop.setProperty("browser", "chrome");
		
		FileOutputStream fout = new FileOutputStream(".\\src\\test\\resources\\com.properties");
		prop.store(fout, "write data");
		
		// Reading the data
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\com.properties");
		prop.load(fis);
		
		String USERNAME = fLib.getPropertyKeyValues("username");
		String PASSWORD = fLib.getPropertyKeyValues("password");
		String URL =  fLib.getPropertyKeyValues("url");
		String BROWSER =  fLib.getPropertyKeyValues("browser");
		
		
		 driver=new ChromeDriver();
		driver.get(URL);
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@name='login']")).click();
		

	}

}
