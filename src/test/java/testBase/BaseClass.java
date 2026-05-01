package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


	public class BaseClass 
	{
		public static WebDriver driver;
		public Logger logger;
		public Properties properties;
		
	
	@BeforeClass(groups = {"sanity","regression"})
	@Parameters({"os", "browser"})
	public void setUp(String os , String browser) throws IOException
	{
		System.out.println("I m in the Base class");
		System.out.println("I m in the Base class value of Driver : " + driver);
		logger = LogManager.getLogger(this.getClass());
		FileReader f = new FileReader("./src//test//resources//config.properties");
		properties = new Properties();
		properties.load(f);
		
		switch(browser.toLowerCase())
		{
		case "chrome" : driver = new ChromeDriver(); break;
		case "edge"	  : driver = new EdgeDriver(); break;
		case "firefox" : driver = new FirefoxDriver(); break;
		default : System.out.println(" Invalid Browser Name"); return ;
		}
		
		System.out.println("I m in the Base class value of After Initiate Driver : " + driver);
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(properties.getProperty("URL"));
		driver.manage().window().maximize();	
	}
	
	@AfterClass(groups = {"sanity","regression"})
	public void tearDown()
	{
		driver.quit();
	}
	
}
