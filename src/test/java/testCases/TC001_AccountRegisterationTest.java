package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegisterationTest extends BaseClass
{
//This is TC001_accountClass
	@Test(groups = {"sanity"})
	public void createAccountRegister()
	{
		logger.info("On Home Page");
		HomePage homepage = new HomePage(driver);
		logger.info("Clicking on Account");
		homepage.clickMyAccount();
		logger.info("Clicking on Register");
		homepage.clickRegister();
		
		logger.info("On Account Register Page");
		
		AccountRegistrationPage accRegPage = new AccountRegistrationPage(driver);
		
		logger.info("Entering First Name");
		accRegPage.firstName("ABCD");
		logger.info("Entering Last Name");
		accRegPage.lastName("ABCD");
		logger.info("Entering Email");
		accRegPage.email("AB12@gmail.com");
		logger.info("Entering Password");
		accRegPage.password("ABCD111");
		logger.info("Clicking on Privacy");
		accRegPage.privacyPolicy();
		logger.info("Clicking on Continue Button");
		accRegPage.continueClick();
		String confirm = accRegPage.getConfirmationMsg();
		logger.info("Validating the meassage");
		Assert.assertEquals(confirm, "Your Account Has Been Created!");
	}
	
	
}
