package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountRegistrationPage extends BasePage
{

	public AccountRegistrationPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement emailID;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement policyCheck;
	
	@FindBy(xpath = "//button[text()='Continue']")
	WebElement continueButton;
	
	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	
	
	public void firstName(String firstname)
	{
		
		firstName.sendKeys(firstname);
	}
	
	public void lastName(String lastname)
	{
		lastName.sendKeys(lastname);
	}
	
	public void email(String email)
	{
		emailID.sendKeys(email);
	}
	
	public void password(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void privacyPolicy()
	{
		WebElement checkpoily = mywait.until(ExpectedConditions.elementToBeClickable(policyCheck));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", checkpoily);
	}
	
	public void continueClick()
	{
		
		mywait.until(ExpectedConditions.elementToBeClickable(continueButton)).submit();
	}
	
	public String getConfirmationMsg()
	{
		try
		{
		return msgConfirmation.getText();
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
		
	}
	
	
	
}
