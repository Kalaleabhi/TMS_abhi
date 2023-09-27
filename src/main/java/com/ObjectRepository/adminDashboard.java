package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.WebDriverUtils.WebdriverUtility;

public class adminDashboard {
   @FindBy(xpath = "//span[.='Dashboard']")
	private WebElement Dashboard;
	
	@FindBy(xpath = "//span[.=' Tour Packages']")
	private WebElement TourPackages;
	
	@FindBy(xpath = "//span[.='Manage Users']")
	private WebElement Manageusers;
	
	@FindBy(xpath = "//span[.='Manage Booking']")
	private WebElement Managebooking;
	
	@FindBy(xpath = "//span[.='Manage Issues']")
	private WebElement ManageIssues;
	
	@FindBy(xpath = "//span[.='Manage Enquiries']")
	private WebElement ManageEnquiries;
	
	//declaration
	
	@FindBy(xpath = "//i[@class='fa fa-angle-down']")
	private WebElement dropdowntoggle;
	
	@FindBy(xpath = "//i[@class='fa fa-sign-out']")
	private WebElement Signout;
	
	
	
	//Initialization
	
	public adminDashboard(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}



	public WebElement getDashboard() {
		return Dashboard;
	}



	public WebElement getTourPackages() {
		return TourPackages;
	}



	public WebElement getManageusers() {
		return Manageusers;
	}



	public WebElement getManagebooking() {
		return Managebooking;
	}



	public WebElement getManageIssues() {
		return ManageIssues;
	}



	public WebElement getManageEnquiries() {
		return ManageEnquiries;
	}



	public WebElement getDropdowntoggle() {
		return dropdowntoggle;
	}



	public WebElement getSignout() {
		return Signout;
	}
	
	public void setSignout(WebDriver driver)
	{
		WebdriverUtility wLib = new WebdriverUtility();
		wLib.scrollUsingActionClass(driver, getDropdowntoggle());
		getDropdowntoggle().click();
		getSignout().click();
	}



	}

	
	// Utilization
	
	
	
	
	
	
	
	

