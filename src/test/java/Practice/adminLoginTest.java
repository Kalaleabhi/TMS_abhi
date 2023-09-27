package Practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ObjectRepository.adminLoginPage;
import com.WebDriverUtils.ExcelUtility;
import com.WebDriverUtils.JavaUtility;
import com.WebDriverUtils.PropertyFileUtility;
import com.WebDriverUtils.WebdriverUtility;

public class adminLoginTest {

	public static void main(String[] args) throws Throwable {
		
		ExcelUtility eLib = new ExcelUtility();
		PropertyFileUtility fLib = new PropertyFileUtility();
		JavaUtility jLib = new JavaUtility();
		WebdriverUtility wLib = new WebdriverUtility();
		
		WebDriver driver = null;
		
	String BROWSER = fLib.getPropertyKeyValues("browser");
		String URL = fLib.getPropertyKeyValues("url");
		String USERNAME = fLib.getPropertyKeyValues("username");
		String PASSWORD = fLib.getPropertyKeyValues("password");
		
		driver = new ChromeDriver();
		
		driver.get(URL);
		adminLoginPage al= new adminLoginPage(driver);
		al.adminLogin(USERNAME, PASSWORD);
		 
		
		
		
		
	}

}
