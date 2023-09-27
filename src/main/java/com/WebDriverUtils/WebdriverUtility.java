package com.WebDriverUtils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * this class provides generic methods for Webdriver methods
 * @author admin
 * 
 */

public class WebdriverUtility
{
		public Object maximizeTheBrowser;
		/**
		 * this method is used to maximize the browser
		 * @author admin
		 * 
		 */
	public void maximizeTheBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
		
	}
	/**
	 * this method is used minimize the browser
	 * @author admin
	 * 
	 */
	public void minimizeTheBrowser(WebDriver driver)
	{
		driver.manage().window().minimize();
	}

	/**
	 * this method will wait until elements in the page gets load
	 * 
	 */
	public void implicitWait(WebDriver driver,int duration)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
	}
	/**
	 * this method will wait until the url of the page gets load
	 * 
	 */
	public void waitUntilUrlLoads(WebDriver driver,int duration,String expectedurl)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.urlContains(expectedurl));
	}
	/**
	 * this method will wait until the title of the page gets load
	 */
	public void waitUntilTitleLoads(WebDriver driver,int duration,String expectedTitle)
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
	wait.until(ExpectedConditions.urlContains(expectedTitle));
	}
	/**
	 * This method will wait until the element in the page gets load
	 * 
	 */
	public void waitUntilElementToBeClickable(WebDriver driver,int duration, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method will ignore NoSuchElementException and continues the execution
	 * 
	 */
	public void ignoreNoSuchElementException(WebDriver driver,int duration)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.ignoring(NoSuchElementException.class);
	}
	/**
	 * This method will wait until the element to be visible in the page 
	 * @throws InterruptedException 
	 * 
	 */
	public void customWait(WebElement element) throws InterruptedException
	{
		int count=0;
		while(count<20)
		{
			try {
				element.click();
				break;
			}catch (Exception e) 
			{
				Thread.sleep(1000);
				count++;
			}
		}
	}
	/**
	 * This method will select the dropdown element based on index 
	 * 
	 */
	public void selectDropDown(WebElement element,int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * This method will select a dropdown element based on value
	 * 
	 */
	public void selectDropDown(WebElement element,String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * This method will select a dropdown element based on visibleText
	 * 
	 */
	public void selectDropDown(String text,WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * This method is used to mouseOver on an element
	 * 
	 */
	public void mouseOverOnElement(WebDriver driver,WebElement element)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	/**
	 * This method is used to rightclick on an element
	 * 
	 */
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}
	/**
	 * This method is used to click on enter button
	 * 
	 */
	public void clickOnEnterKey(WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * This method is used to switch from one frame to another using index
	 * 
	 */
	public void switchFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This method is used to switch from one frame to another using id
	 * 
	 */
	public void switchFrame(WebDriver driver,String id)
	{
		driver.switchTo().frame(id);
	}
	/**
	 * This method is used to switch from one frame to another using webelement
	 * 
	 */
	public void switchFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * This method is used to switch to main frame
	 * 
	 */
	public void switchToMainFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * This method is used to accept popup
	 * 
	 */
	public void acceptAlertpopup(WebDriver driver, String expectedMsg)
	{
		Alert alt = driver.switchTo().alert();
		if(alt.getText().equalsIgnoreCase(expectedMsg))
		{
			System.out.println("alert msg is verified");
		}
			else
			{
				System.out.println("alert msg is not verified");
			}
			alt.accept();
			}
		/**
		 * This method is used to dismiss the alert popup
		 * 
		 */
	public void dismissAlertPopup(WebDriver driver,String expectedMsg)
	{
		Alert alt = driver.switchTo().alert();
		if(alt.getText().equalsIgnoreCase(expectedMsg))
		{
			System.out.println("alert msg is verified");
		}
			else
			{
				System.out.println("alert msg is not verified");
			}
			alt.dismiss();
			}
	/**
	 * This method is used to switch from one window to another based on title
	 * 
	 */
	public void switchWindowBasedOnTitle(WebDriver driver,String expectedTitle)
	{
		Set<String> set = driver.getWindowHandles();
		for (String str : set)
		{
			driver.switchTo().window(str);
			String title = driver.getTitle();
			if(title.contains(expectedTitle))
			{
				break;
			}
		}
	}
	/**
	 *This method is used to switch from one window to another based on url
	 * 
	 *
	 */
	public void switchWindowBasedOnUrl(WebDriver driver,String expectedUrl)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
			String wid = it.next();
			driver.switchTo().window(wid);
			String url = driver.getCurrentUrl();
			if(url.contains(expectedUrl))
			{
				break;
			}
		}
	}
	/**
	 * This method is used to take screenshot whenever the testscript getting failed
	 * 
	 */
	public static String takeScreenShot(WebDriver driver, String screenShotname)
	{
		TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
		File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenShots/"+screenShotname+".png");
		try {
			Files.copy(src, dst);
		}
		catch (IOException e)
		{
		e.printStackTrace();	
		}
		return screenShotname;
		
	}
	/**
	 * This method is used to scrollTo particular element
	 * 
	 */
	public void scrollToParticularElement(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
		
	}
	/**
	 * This method is used to drag and drop the element
	 * 
	 */
	public void dragAnddrop(WebDriver driver,WebElement src, WebElement dsc)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dsc);
	}
	/**
	 * This element will double click on webpages
	 * 
	 */
	public void doubleClickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	/**
	 * This method will press the enter key
	 * @throws Throwable 
	 * 
	 */
	public void enteKey(WebDriver driver) throws Throwable
	{
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}
	/**
	 * This method is used to release the key
	 * @throws AWTException 
	 * 
	 */
	public void enterRealease(WebDriver driver) throws AWTException
	{
		Robot rb = new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	/**
	 * This method will perform random scroll
	 * 
	 */
	public void scrollBarAction(WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,800)", "");
	}
	/**
	 * This method will scroll until specified element is found 
	 * 
	 */
	public void scrollAction(WebDriver driver,WebElement element)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		int y = element.getLocation().getY();
		jse.executeScript("window.scrollBy(0,"+y+")", element);
	}
	
	public void scrollUsingActionClass(WebDriver driver , WebElement element)
	{
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}
}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


