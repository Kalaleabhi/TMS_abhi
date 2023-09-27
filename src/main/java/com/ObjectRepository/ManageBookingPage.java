package com.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageBookingPage {
	
	//initialization
	
	@FindBy(xpath = "//span[.='Manage Booking']")
	private WebElement ManageBooking;
	
	@FindBy(xpath = "//table/tbody/tr/td[1]/span[.='#BK-21']")
	private WebElement ManageBookingId;
	
	
	@FindBy(xpath = "//table/tbody/tr/td[1]/span[text()='#BK-21']/parent::td/following-sibling::td[8]/descendant::a[2]")
	private WebElement Confirm;
	
	@FindBy(xpath = "//div[@class='succWrap' and contains(text(),':Booking Confirm successfully')]")
	private WebElement BookingConfirm;
	
	
	public ManageBookingPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getManageBooking() {
		return ManageBooking;
	}


	public WebElement getManageBookingId() {
		return ManageBookingId;
	}


	public WebElement getConfirm() {
		return Confirm;
	}


	public WebElement getBookingConfirm() {
		return BookingConfirm;
	}

	public void confirmBooking(WebDriver driver,String bookingId)
	{
		
		WebElement ele = driver.findElement(By.xpath("//table/tbody/tr/td[1]/span[text()='"+bookingId+"']"));
		Actions a = new Actions(driver);
		a.moveToElement(ele).perform();
				a.click(driver.findElement(By.xpath("//table/tbody/tr/td[1]/span[text()='"+bookingId+"']/parent::td/following-sibling::td[8]/descendant::a[2]"))).perform();
				driver.switchTo().alert().accept();
				driver.findElement(By.xpath("//div[@class='succWrap' and contains(text(),':Booking Confirm successfully')]"));
	}
}
