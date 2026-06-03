package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.DashboardPage;
import Pages.LoginPage;
import SetUp.BaseClass;
import Utilities.TakeScreenshot;

public class LoginPageTests extends BaseClass{
	
	LoginPage loginPage;
	DashboardPage dashBoard;
	public static final String DASHBOARD_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	
	@BeforeMethod
	public void launchOrangeHRMInBrowser() {
		super.launchOrangeHRM();
		loginPage = new LoginPage(driver);
	}
	
	@Test
	public void verifyLoginUsingValidCredentials() {
		dashBoard = loginPage.login("Admin","admin123");
		Assert.assertEquals(DASHBOARD_URL, driver.getCurrentUrl());
	}
	
	@Test
	public void verifyLoginUsingInValidCredentials() {
		loginPage.login("Admin","admin1234");
		Assert.assertEquals(loginPage.getInvalidCredentialsErrorMessage(), "Invalid credentials");
	}
	
	@Test
	public void verifyLoginUsingEmptyCredentials() {
		loginPage.login("","");
		Assert.assertTrue(loginPage.isRequiredMsgDisplayedUnderInputFields());
	}
	
	@Test
	public void verifyForgetYourPasswordLink() {
		loginPage.clickForgetYouPassword();
		Assert.assertTrue(driver.getCurrentUrl().contains("PasswordResetCode"));
	}
	
	@AfterMethod
	void tearDown() {
		driver.quit();
	}
}
