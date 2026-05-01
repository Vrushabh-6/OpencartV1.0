package reportListener;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import testBase.BaseClass;
import utilitiesClasses.ExtentReportManager;
import utilitiesClasses.ScreenshotUtil;

public class ListenerReportClass implements ITestListener
{
	public static ExtentReports extent;
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	
	@Override 
	public void onStart(ITestContext context)
	{
		System.out.println("===== Test Execution Started =====");
		
		System.out.println("Printing suite " + context.getSuite());
		
	}
	
	@Override 
	public void onTestStart(ITestResult result)
	{
		String TestName = result.getTestName();
		System.out.println("Test Name : " + TestName);
		String methodName = result.getMethod().getMethodName();
		System.out.println("Method Name : " + methodName);
		String className = result.getTestClass().getRealClass().getSimpleName();
		System.out.println("Class Name : " + className);
		String name = className +"_" + methodName;
		System.out.println("Name : " + name);
		extent = ExtentReportManager.getInstance(name);
		ExtentTest extentTest = extent.createTest(name) ;
		extentTest.assignCategory(result.getMethod().getGroups());
		test.set(extentTest);
	}
	
	
	
	@Override 
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("===== Test Success =====");
		test.get().pass("Test Passed ✅");
	}
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		System.out.println("===== Test Failed =====");
		test.get().fail(result.getTestName());
		test.get().fail(result.getThrowable().getMessage());
		
		
		WebDriver driver = BaseClass.driver;

		System.out.println("Value of driver " + driver);
			System.out.println("I will capture ScreenShot");
			String 	screenShotPath = ScreenshotUtil.captureScreenshot(driver, result.getMethod().getMethodName());
			test.get().addScreenCaptureFromPath(screenShotPath);
			System.out.println("I have captured ScreenShot");

	}
	
	@Override
	public void onTestSkipped(ITestResult result)
	{
		test.get().skip("Test Skipped ⚠️");
	}
	
	@Override
	public void onFinish(ITestContext context)
	{
		extent.flush();
		System.out.println("===== Report Generated =====");
	}

}
