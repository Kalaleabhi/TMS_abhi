package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage {
	
	//declaration
	@FindBy(xpath = "//a[contains(text(),'Sign In')]")
   private WebElement SignInLink;
	
	@FindBy(xpath ="//h3[text()='Signin with your account ']/following::input[@id='email']")
	private WebElement UseremailId;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement UserPassword;
	
	@FindBy(xpath = "//input[@name='signin']")
	private WebElement SignInBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	private WebElement Logout;
	
	
	
	public WebElement getLogout() {
		return Logout;
	}


	//initialization
	public UserLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getSignInLink() {
		return SignInLink;
	}


	public WebElement getUseremailId() {
		return UseremailId;
	}


	public WebElement getUserPassword() {
		return UserPassword;
	}


	public WebElement getSignInBtn() {
		return SignInBtn;
	}
	
	
	//utilization
	
	
	public void LoginasUser(String username , String password) throws InterruptedException
	{
		SignInLink.click();
		//Thread.sleep(2000);
		UseremailId.sendKeys(username);
		UserPassword.sendKeys(password);
		SignInBtn.click();
	}
	
	
	
	
	

}
