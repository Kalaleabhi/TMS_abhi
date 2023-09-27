package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(linkText = "Enquiry")
	private WebElement EnquiryLink;
	
	@FindBy(xpath = "//a[text()='Admin Login']")
	private WebElement adminloginlink;
	
	@FindBy(xpath = "//i[@class='fa fa-angle-down']")
	private WebElement admintoggelangle;
	
	public WebElement getAdminloginlink() {
		return adminloginlink;
	}

	public WebElement getAdmintoggelangle() {
		return admintoggelangle;
	}

	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getEnquiryLink() {
		return EnquiryLink;
	}

	public WebElement getadminloginlink() {
		return adminloginlink;
	}

	
	
}
