package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilitiesClasses.DataProviders;

public class TC003LoginDataDrivenTesting extends BaseClass
{
	@Test(dataProvider = "LoginData" , dataProviderClass=DataProviders.class, groups = {"datadriven"})
	public void loginDDT(String email, String password , String checkVaildation)
	{
		logger.info("On Home Page");
		HomePage homepage = new HomePage(driver);
		logger.info("Clicking on Account");
		homepage.clickMyAccount();
		logger.info("Clicking on Login");
		homepage.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		logger.info("Entering Email");
		lp.enterEmail(email);
		logger.info("Entering Password");
		lp.enterPassword(password);
		logger.info("Clicking on Login Button");
		lp.clickLoginButton();
		
		
		AccountLoginPage alp = new AccountLoginPage(driver);
		logger.info("Checking My Account");
		String loginAccountcheck = alp.loginCheck();
		boolean targetPage = loginAccountcheck.equals("My Account");
		
		if(checkVaildation.equalsIgnoreCase("vaild") )
			{
				if(targetPage==true)
				{
					logger.info("Clicking on LogOut");
					alp.clickLogOutButton();
					Assert.assertTrue(true);
				}
				else 
				{
					Assert.assertTrue(false);
				}
			}
		
		if(checkVaildation.equalsIgnoreCase("invalid") )
		{
			if(targetPage==true)
			{
				logger.info("Clicking on LogOut");
				alp.clickLogOutButton();
				Assert.assertTrue(false);
			}
			else 
			{
				Assert.assertTrue(true);
			}
		}
	}
}
