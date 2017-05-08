package lib;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.ReportManager;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dataProvider.Xls_Reader;


public class Engine {
	static Xls_Reader excel;
	public static WebDriver driver;
	static ExtentReports reports = ReportManager.getReports();
	
	static ExtentTest test;

	public Engine(WebDriver driver) {
		this.driver = driver;
	}

	public static WebDriver configurator(String uname,String pword) throws FileNotFoundException, IOException {
		
		test = reports.startTest("AvactisTest");
		
		
		excel = new Xls_Reader("C:\\Users\\Rai\\workspace\\NewKey1\\KDF1\\TestCases\\AvactisData.xlsx");
		int rows = excel.getRowCount("LoginForm");

		for (int i = 1; i < rows; i++) {
			String description = excel.getCellData("LoginForm", "Description", i);
			String action = excel.getCellData("LoginForm", "Action", i);
			String locatortype = excel.getCellData("LoginForm", "LocatorType", i);
			String locatorvalue = excel.getCellData("LoginForm", "LocatorValue", i);
			String data = excel.getCellData("LoginForm", "TestData", i);

			if (data.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
							"C:\\Users\\Waqas\\Desktop\\Drivers\\chromedriver.exe");
					driver = new ChromeDriver();
					test.log(LogStatus.INFO,"Browser is Up and Running.");
				}
			
		else if (data.equalsIgnoreCase("firefox")) {
				
					System.setProperty("webdriver.gecko.driver",
							"C:\\Users\\Waqas\\Desktop\\Drivers\\geckodriver.exe");
					driver = new FirefoxDriver();
					test.log(LogStatus.INFO,"Browser is Up and Running.");
				}
			
			
		else if (data.equalsIgnoreCase("edge")) {
				
					System.setProperty("webdriver.edge.driver",
							"C:\\Users\\Waqas\\Desktop\\Drivers\\MicrosoftWebDriver.exe");
					driver = new EdgeDriver();
					test.log(LogStatus.INFO,"Browser is Up and Running.");
					}
			if (action.equalsIgnoreCase("openapplication")) {
				BrowserAction.openApplication(driver, data);
				test.log(LogStatus.INFO,"Application is Up and Running.");
			}
			if (action.equalsIgnoreCase("click")) {
				ClickAction.clickEvent(driver, locatortype, locatorvalue);

			}
			if (data.equalsIgnoreCase("username"))
			{
				data=uname;
			}
			else if(data.equalsIgnoreCase("password")){
				data=pword;
			}
			if (action.equalsIgnoreCase("type")) {
				TypeAction.typeEvent(driver, locatortype, locatorvalue, data);
			}
			
			/*if (action.equalsIgnoreCase("closebrowser")) {
				BrowserAction.closeApplication(driver)*/
		}
	
		return driver;
	
	}

	

}
