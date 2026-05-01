package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage
{

	public LoginPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement enterEmail;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement enterPass;
	
	@FindBy(xpath = "//button[text()='Login']")
	WebElement clickLogin;
	
	
	
	public void enterEmail(String email)
	{
		enterEmail.sendKeys(email);
	}
	
	public void enterPassword(String pass)
	{
		enterPass.sendKeys(pass);
	}
	
	public void checkAlert()
	{
		try
		{
			Alert alert = mywait.until(ExpectedConditions.alertIsPresent());
			alert.accept();
			System.out.println("Alert Present");
		}
		catch(Exception e)
		{
			System.out.println("Alert Not Present");
		}
		
	}
	
	public void clickLoginButton()
	{
		clickLogin.click();
		checkAlert();	
	}
	
}
	
