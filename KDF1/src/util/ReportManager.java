package util;

import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ReportManager{
	
	private static ExtentReports reports;
	private static ExtentTest test;
	
	
	public static ExtentReports getReports()
	{
		Date d =new Date();
		
		String path= d.toString().replace(" ", "_").replace(":", "_")+".html";
		reports=new ExtentReports(".\\Reports\\"+path,true);
		return reports;
		
	}
	
}

