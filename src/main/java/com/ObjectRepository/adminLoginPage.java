package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class adminLoginPage {
	
	//declaration 
	@FindBy(xpath ="//input[@name='username']")
	private WebElement adminUsername;
	
	@FindBy(xpath ="//input[@name='password']")
	private WebElement adminPassword;
	
	@FindBy(xpath= "//input[@class='login']")
	private WebElement login;
	
	@FindBy(xpath = "//a[text()='Back to home']")
	private WebElement BackToHome;
	
	
	

	
	public WebElement getBackToHome() {
		return BackToHome;
	}



	public void setBackToHome(WebElement backToHome) {
		BackToHome = backToHome;
	}



	//Initialization
	public adminLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}



	public WebElement getAdminUsername() {
		return adminUsername;
	}



	public WebElement getAdminPassword() {
		return adminPassword;
	}



	public WebElement getLogin() {
		return login;
	}
	
	
	//Utilization
	
	public void adminLogin(String username , String password)
	{
		adminUsername.sendKeys(username);
		adminPassword.sendKeys(password);
		login.click();
	}
	public void setLogin(String adminUN, String adminPWD)
	{
		getAdminUsername().sendKeys(adminUN);
		getAdminPassword().sendKeys(adminPWD);
		getLogin().click();
	}
	
	
	
	
	
	
	
	
	

}
