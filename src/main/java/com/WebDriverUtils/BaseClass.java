package com.WebDriverUtils;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.ObjectRepository.HomePage;
import com.ObjectRepository.adminDashboard;
import com.ObjectRepository.adminLoginPage;

public class BaseClass {
	
		
	
	WebdriverUtility wLib = new WebdriverUtility();
	ExcelUtility eLib = new ExcelUtility();
	PropertyFileUtility pLib = new PropertyFileUtility();
	DatabaseUtility dLib = new DatabaseUtility();
	
	
	public WebDriver driver;
	public static WebDriver sdriver;
	
	
	@BeforeSuite(alwaysRun =  true)
	public void configBS() throws SQLException
	{
		dLib.getDBConnect();
		System.out.println("---connect to database-----");
	}
//	@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void configBC() throws IOException
	{
	//String BROWSER = pLib.getPropertyKeyValues("browser");
	/*if(BROWSER.equalsIgnoreCase("chrome"))
	{
		driver= new ChromeDriver();
		System.out.println("Launching chrome browser");
	}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver= new FirefoxDriver();
			System.out.println("launching firefox browser");
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver= new EdgeDriver();
			System.out.println("launching edge browser");
		}
		else 
		System.out.println("--invalid browser--");*/
	

	
		String URL = pLib.getPropertyKeyValues("url");
		driver=new ChromeDriver();
		sdriver = driver;
		
		driver.get(URL);
		
		wLib.maximizeTheBrowser(driver);
		wLib.implicitWait(driver, 10);
		System.out.println("---browser opened----");
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void configBM() throws IOException
	{
	String adminUN = pLib.getPropertyKeyValues("username");
	String adminPWD = pLib.getPropertyKeyValues("Password");
	adminLoginPage alp = new adminLoginPage(driver);
	HomePage hp = new HomePage(driver);
	hp.getadminloginlink().click();
	alp.setLogin(adminUN, adminPWD);
		System.out.println("---Admin Login done---");
	}
	@AfterMethod(alwaysRun = true)
	public void configAM()
	{
		adminDashboard adb = new adminDashboard(driver);
		adb.setSignout(driver);
		System.out.println("--Logout Done--");
	}
	@AfterClass(alwaysRun = true)
	public void configAC()
	{
		driver.quit();
		System.out.println("--Browser closed--");
	}
	@AfterSuite(alwaysRun = true)
	public void configAS() throws SQLException
	{
		dLib.closeDB();
		System.out.println("--Disconnected to DataBase--");
	}
	
	}


