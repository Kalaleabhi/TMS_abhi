package Practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ObjectRepository.UserLoginPage;
import com.ObjectRepository.adminLoginPage;
import com.WebDriverUtils.ExcelUtility;
import com.WebDriverUtils.JavaUtility;
import com.WebDriverUtils.PropertyFileUtility;
import com.WebDriverUtils.WebdriverUtility;

public class UserLoginTest {

	public static void main(String[] args) throws Throwable {
		
		ExcelUtility eLib = new ExcelUtility();
		PropertyFileUtility fLib = new PropertyFileUtility();
		JavaUtility jLib = new JavaUtility();
		WebdriverUtility wLib = new WebdriverUtility();
		
		WebDriver driver = null;
		
	String BROWSER = fLib.getPropertyKeyValues("browser");
		String URL = fLib.getPropertyKeyValues("url");
		String USERNAME = fLib.getPropertyKeyValues("Username");
		String PASSWORD = fLib.getPropertyKeyValues("Password");
		
		driver = new ChromeDriver();
		
		driver.get(URL);
		wLib.maximizeTheBrowser(driver);
		wLib.implicitWait(driver, 10);
		UserLoginPage ul = new UserLoginPage(driver);
				ul.LoginasUser(USERNAME, PASSWORD);
				
		
		
		
		
	}

}
