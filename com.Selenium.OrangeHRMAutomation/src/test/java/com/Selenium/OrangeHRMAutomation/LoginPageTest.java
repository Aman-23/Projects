package com.Selenium.OrangeHRMAutomation;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.LoginPage;
import SetUp.BaseClass;
import Utilities.TakeScreenshot;

public class LoginPageTest extends BaseClass{
	
	LoginPage loginPage = new LoginPage(driver);
	public static final String DASHBOARD_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	
	@BeforeMethod
	@Override
	public void launchOrangeHRM() {
		super.launchOrangeHRM();
	}
	
	@Test
	public void loginTest() {
		loginPage.login("Admin","admin123");
		TakeScreenshot.takeScreenshot(driver);
		Assert.assertEquals(DASHBOARD_URL, driver.getCurrentUrl());
	}
	
	@AfterMethod
	void tearDown() {
		driver.quit();
	}

}
