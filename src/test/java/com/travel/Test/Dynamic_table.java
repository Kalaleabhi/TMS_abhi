package com.travel.Test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Dynamic_table {

	public static void main(String[] args) {
		FirefoxDriver driver1 = new FirefoxDriver();

		driver1.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		driver1.manage().window().maximize();

		driver1.get("https://www.icc-cricket.com/rankings/mens/team-rankings");

		List<WebElement> allTeams = driver1.findElements(By.xpath("//table/descendant::span[@class='u-hide-phablet']"));

		String Expectedteam = "Scotland";

		int count = 0;

		for(WebElement e:allTeams)
		{

			if(Expectedteam.equalsIgnoreCase(e.getText()));
			{
				System.out.println(Expectedteam+ " is present in the list");
				count++;
				break;
			}

		}
		if(count==0)
			System.out.println(Expectedteam+ "is not present in the list ");
		driver1.quit();

	
}
}

