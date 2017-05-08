package lib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TypeAction {
	
	public static String typeEvent(WebDriver driver,String locatortype, String locatorvalue, String inputdata)
	{
		try {
			if(locatortype.equalsIgnoreCase("id")){
			driver.findElement(By.id(locatorvalue)).sendKeys(inputdata);
			}
			if(locatortype.equalsIgnoreCase("name")){
				driver.findElement(By.name(locatorvalue)).sendKeys(inputdata);
				}
			if(locatortype.equalsIgnoreCase("xpath")){
				driver.findElement(By.xpath(locatorvalue)).sendKeys(inputdata);
				}
			if(locatortype.equalsIgnoreCase("cssselector")){
				driver.findElement(By.cssSelector(locatorvalue)).sendKeys(inputdata);
				}
			if(locatortype.equalsIgnoreCase("linktext")){
				driver.findElement(By.linkText(locatorvalue)).sendKeys(inputdata);
				}
			if(locatortype.equalsIgnoreCase("partiallinktext")){
				driver.findElement(By.partialLinkText(locatorvalue)).sendKeys(inputdata);
				}
			if(locatortype.equalsIgnoreCase("classname")){
				driver.findElement(By.className(locatorvalue)).sendKeys(inputdata);
				}
			return "pass";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
}
