package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountLoginPage extends BasePage
{

	public AccountLoginPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath = "//h1[text()='My Account']")
	WebElement myAccountLoginCheck;
	
	@FindBy(xpath = "//a[@class='list-group-item'][text()='Logout']")
	WebElement clickLogOut;
	
	public String loginCheck()
	{
		try 
		{
			String AccountLogin = myAccountLoginCheck.getText();
			return AccountLogin;
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
		
	}
	
	public void clickLogOutButton()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", clickLogOut);
	}

}
