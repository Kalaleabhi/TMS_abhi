package com.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.WebDriverUtils.WebdriverUtility;

public class ManageEnquiryPage {

	@FindBy(xpath = "//span[.='Manage Enquiries']")
	private WebElement ManageEnquiry;
	
	@FindBy(xpath="//table[@id='table']/descendant::td[@data-th='Name']")
	private List<WebElement> allEnquiries;
	
	public  ManageEnquiryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getManageEnquiry() {
		return ManageEnquiry;
	}

	public List<WebElement> getAllEnquiries() {
		return allEnquiries;
	}
	
}
