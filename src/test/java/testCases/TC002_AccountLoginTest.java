package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC002_AccountLoginTest extends BaseClass
{
	@Test(groups = {"regression"})
	public void loginToAccount()
	{
		logger.info("On Home Page");
		HomePage homepage = new HomePage(driver);
		logger.info("Clicking on Account");
		homepage.clickMyAccount();
		logger.info("Clicking on Login");
		homepage.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		logger.info("Entering Email");
		lp.enterEmail("vrushabhsawant2315@gmail.com");
		logger.info("Entering Password");
		lp.enterPassword("Vrushabh@1213");
		logger.info("Clicking on Login Button");
		lp.clickLoginButton();
		
		AccountLoginPage alp = new AccountLoginPage(driver);
		logger.info("Checking My Account");
		String loginAccountcheck = alp.loginCheck();
		if(loginAccountcheck.equals("My Account"))
		{
			logger.info("Clicking on LogOut");
			alp.clickLogOutButton();
		}
		Assert.assertEquals(loginAccountcheck, "My Account");
		
	}
}
