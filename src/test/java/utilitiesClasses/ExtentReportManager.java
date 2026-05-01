package utilitiesClasses;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager 
{
	public static ExtentReports extent;
	
	public static ExtentReports getInstance(String name)
	{
		System.out.println("Value of extent :" + extent);
		
		if(extent == null)
		{
			String timeStamp = new SimpleDateFormat("yyyy.mm.dd.HH.mm.ss").format(new Date());
			
			String path = System.getProperty("user.dir") + ".\\reports\\Report_" + name + timeStamp + ".html";
			System.out.println("Path of ExtentReport :" + path );
			
			
			ExtentSparkReporter spark = new ExtentSparkReporter(path);
			
			spark.config().setDocumentTitle("Automation Report");
			spark.config().setReportName("Selenium Execution Report");
			spark.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.DARK);
			
			extent = new ExtentReports();
			extent.attachReporter(spark);
			
			//System Info
			extent.setSystemInfo("OS" , System.getProperty("os.name"));
			extent.setSystemInfo("User" , System.getProperty("user.name"));
			extent.setSystemInfo("Java Version" , System.getProperty("java.version"));
			extent.setSystemInfo("Environment", "QA");
		}
		return extent;
		
	}
	
}
