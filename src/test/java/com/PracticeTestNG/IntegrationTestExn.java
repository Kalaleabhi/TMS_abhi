package com.PracticeTestNG;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ObjectRepository.EnquiryPage;
import com.ObjectRepository.HomePage;
import com.ObjectRepository.ManageEnquiryPage;
import com.ObjectRepository.adminDashboard;
import com.ObjectRepository.adminLoginPage;
import com.WebDriverUtils.BaseClass;
import com.WebDriverUtils.ListenerImpClass;
import com.WebDriverUtils.PropertyFileUtility;
import com.WebDriverUtils.WebdriverUtility;
@Listeners(com.WebDriverUtils.ListenerImpClass.class)
public class IntegrationTestExn extends BaseClass {
@Test(groups = {"smoke" , "regression"})
public void test() throws EncryptedDocumentException, IOException, InterruptedException
{
//	public static void main(String[] args) throws InterruptedException, IOException {

		
		WebdriverUtility wLib = new WebdriverUtility();
		PropertyFileUtility pLib = new PropertyFileUtility();
//		ChromeDriver driver = new ChromeDriver();
//		wLib.maximizeTheBrowser(driver);

//		wLib.implicitWait(driver, 10);
		Thread.sleep(5000);

//		 String URL = pLib.getPropertyKeyValues("url");
//		driver.get(URL);

		EnquiryPage enq = new EnquiryPage(driver);
		enq.generateEnquiry(driver);
		HomePage hp = new HomePage(driver);
		hp.getEnquiryLink().click();
		
		EnquiryPage enq1 = new EnquiryPage(driver);

		enq1.getFirstName().sendKeys("ABC");

		enq1.getEmailId().sendKeys("Abc@gmail.com");

		enq1.getMobileNo().sendKeys("9874563210");
		
		enq1.getSubject().sendKeys("Regarding package");


		enq1.getDecription().sendKeys("Need more offers to the packages");

		enq1.getSubmitBtn().click();  
		
		Thread.sleep(5000);

		hp.getadminloginlink().click();

		adminLoginPage alp = new adminLoginPage(driver);
		alp.getAdminUsername().sendKeys("admin");
		alp.getAdminPassword().sendKeys("Test@123");
		alp.getLogin().click();
		
		adminDashboard adb = new adminDashboard(driver);
		adb.getManageEnquiries().click();
 
		ManageEnquiryPage menq = new ManageEnquiryPage(driver);
		List<WebElement> allEnq = menq.getAllEnquiries();
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
		adb.getDropdowntoggle().click();
		adb.getSignout().click();
		//driver.quit();
	}

}




