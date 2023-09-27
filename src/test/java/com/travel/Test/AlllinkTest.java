package com.travel.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlllinkTest {

	public static void main(String[] args) {
		WebDriver driver1=new FirefoxDriver();

		driver1.manage().window().maximize();

		driver1.get("https://www.epfindia.gov.in/site_en/index.php");

		driver1.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		List<WebElement> listlinks = driver1.findElements(By.xpath("//a"));
		System.out.println(listlinks.size());

		ArrayList<String> link = new ArrayList<String>();
		for(int i=0; i<listlinks.size(); i++)
		{
			String eachlink=listlinks.get(i).getAttribute("href");
			URL url=null;
			int statusCode=0;
			try
			{
				url=new URL(eachlink);
				HttpURLConnection httpConn=(HttpURLConnection) url.openConnection();
				statusCode=httpConn.getResponseCode();
				if(statusCode>=400)
				{
					link.add(eachlink);
					System.out.println(eachlink);
				}
			}
			catch (Exception e)
			{
				link.add(eachlink);

				{

				}
			}
		

		}

	}
}
