package lib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class BrowserAction {

	public static String openApplication(WebDriver driver, String url) {
		try {
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(url);
			return "pass";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public static String closeApplication(WebDriver driver) {
		try {
			driver.quit();
			return "pass";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public static String navigateBack(WebDriver driver) {
		try {
			driver.navigate().back();
			return "pass";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	public static String navigateForward(WebDriver driver) {
		try {
			driver.navigate().forward();
			return "pass";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	public static String navigateRefresh(WebDriver driver) {
		try {
			driver.navigate().refresh();
			return "pass";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

}
