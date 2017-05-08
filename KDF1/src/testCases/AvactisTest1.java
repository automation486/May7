package testCases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import util.ReportManager;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dataProvider.Xls_Reader;
import lib.BrowserAction;
import lib.Engine;

public class AvactisTest1 {

	static Xls_Reader excel;
	static WebDriver driver;
	static ExtentReports reports = ReportManager.getReports();
	static ExtentTest test;
	static String landingPage;

	@Test(dataProvider = "loginData")
	public static void mainq(String uname, String pword)
			throws FileNotFoundException, IOException {
		// SoftAssert assertion = new SoftAssert();
		test = reports.startTest("AvactisTest");
		test.log(LogStatus.INFO, "TestStartsHere");

		driver = Engine.configurator(uname, pword);
		String logoutLinkText = driver.findElement(
				By.xpath("//a[text()='Log Out']")).getText();
		
		Assert.assertEquals(logoutLinkText,"Log Out"); 
			test.log(LogStatus.PASS,"valid UserName=Seleniumhq1@gmail.com and Password=Seleniumhq1@gmail.com-Test is Passed.");
		}
	@Test(dataProvider = "loginData")
	public static void maina(String uname, String pword)
			throws FileNotFoundException, IOException {
		SoftAssert assertion = new SoftAssert();
		test = reports.startTest("AvactisTest");
		test.log(LogStatus.INFO, "TestStartsHere");

		driver = Engine.configurator(uname, pword);
		String logoutLinkText = driver.findElement(
				By.xpath("//a[text()='Log Out']")).getText();
		
		assertion.assertEquals(logoutLinkText,"Log Out"); 
			test.log(LogStatus.FAIL,"Invalid User Name and Password-Test is Failed.");
			assertion.assertAll();
		}

	@DataProvider
	public Object[][] loginData() {
		excel = new Xls_Reader(
				"C:\\Users\\Rai\\workspace\\NewKey1\\KDF1\\TestCases\\AvactisData.xlsx");
		int rowsNum = excel.getRowCount("LoginData");
		int colsNum = excel.getColumnCount("LoginData");
		System.out.println(rowsNum);
		System.out.println(colsNum);
		Object[][] appdata = new Object[rowsNum][colsNum];
		for (int i = 0; i < rowsNum; i++) {
			for (int j = 0; j < colsNum; j++) {

				String username = excel.getCellData("LoginData", j, i);
				String password = excel.getCellData("LoginData", j, i);

				appdata[i][j] = username;
				appdata[i][j] = password;

			}

		}
		return appdata;
	}

	@AfterMethod
	public void tearDown() {
		BrowserAction.closeApplication(driver);
	}

	@AfterTest
	public void flush() {
		reports.endTest(test);
		reports.flush();

	}

}
