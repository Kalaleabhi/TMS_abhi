package com.ObjectRepository;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.WebDriverUtils.ExcelUtility;

public class EnquiryPage {


	@FindBy(xpath = "//form[@name='enquiry']/descendant::input[@name='fname']")
	private WebElement FirstName;

	@FindBy(xpath = "//form[@name='enquiry']/descendant::input[@name='email']")
	private WebElement EmailId;

	@FindBy(xpath = "//form[@name='enquiry']/descendant::input[@name='mobileno']")
	private WebElement MobileNo;

	@FindBy(xpath = "//form[@name='enquiry']/descendant::input[@name='subject']")
	private WebElement Subject;

	@FindBy(xpath = "//form[@name='enquiry']/descendant::textarea[@name='description']")
	private WebElement Decription;

	@FindBy(xpath = "//form[@name='enquiry']/descendant::button[@name='submit1']")
	private WebElement SubmitBtn;

	public EnquiryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getFirstName() {
		return FirstName;
	}

	public WebElement getEmailId() {
		return EmailId;
	}

	public WebElement getMobileNo() {
		return MobileNo;
	}

	public WebElement getSubject() {
		return Subject;
	}

	public WebElement getDecription() {
		return Decription;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}

	//bussiness libraries
	public void generateEnquiry(WebDriver driver) throws EncryptedDocumentException, IOException, InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.getEnquiryLink().click();
		ExcelUtility eLib = new ExcelUtility();
		HashMap<String, String> map = eLib.getMultipleDataFromExcel("EnquiryDetails", 0, 1, driver);
		System.out.println("****************");
		for(Entry<String, String> s:map.entrySet())
		{
			Thread.sleep(3000);
			driver.findElement(By.xpath("//form[@name='enquiry']/descendant::input[@name='"+s.getKey()+"']")).sendKeys(s.getValue());
		} 
	getDecription().sendKeys("Need more bookings");
	getSubmitBtn().click();
}








}
