package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyTourHistoryPage {
	
	//declaration
	@FindBy(xpath = "//a[text()='My Tour History']")
	private WebElement MyTourHistory;
	
	public MyTourHistoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getMyTourHistory() {
		return MyTourHistory;
	}
	
	
	
	
	
	
	
	
	
	//Initialization
	//Utilization
	

}
