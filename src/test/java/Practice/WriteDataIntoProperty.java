package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WriteDataIntoProperty {

	public static void main(String[] args) throws Throwable {
		
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
		
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		String URL = prop.getProperty("url");
		String BROWSER = prop.getProperty("browser");
		
		
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@name='login']")).click();
		

	}

}
