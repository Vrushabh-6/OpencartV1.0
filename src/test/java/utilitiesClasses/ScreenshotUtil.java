package utilitiesClasses;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil 

{
	public static String captureScreenshot(WebDriver driver, String testname)
	{
		String timeStamp = new SimpleDateFormat("yyyy.mm.dd.HH.mm,ss").format(new Date());
		String path = System.getProperty("user.dir") + ".\\screenshots\\ScreenShot_" + testname +timeStamp +".png";
		System.out.println("Path of Screen Shoot :" + path );
		TakesScreenshot  ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		try
		{
			FileUtils .copyFile(src, dest);
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		return path;
		
	}
}
