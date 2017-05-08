package lib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClickAction {
	
	public static String clickEvent(WebDriver driver,String locatortype,String locatorvalue)
	{
		try {
			if(locatortype.equalsIgnoreCase("id"))
			{
				driver.findElement(By.id(locatorvalue)).click();
			}
			if(locatortype.equalsIgnoreCase("name"))
			{
				driver.findElement(By.name(locatorvalue)).click();
			}
			if(locatortype.equalsIgnoreCase("xpath"))
			{
				driver.findElement(By.xpath(locatorvalue)).click();
			}
			if(locatortype.equalsIgnoreCase("cssselector"))
			{
				driver.findElement(By.cssSelector(locatorvalue)).click();
			}
			if(locatortype.equalsIgnoreCase("linktext"))
			{
				driver.findElement(By.linkText(locatorvalue)).click();
			}
			if(locatortype.equalsIgnoreCase("partiallinktext"))
			{
				driver.findElement(By.partialLinkText(locatorvalue)).click();
			}
			if(locatortype.equalsIgnoreCase("classname"))
			{
				driver.findElement(By.className(locatorvalue)).click();
			}
			return "pass";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

}
