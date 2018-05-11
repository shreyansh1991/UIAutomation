package com.testscripts;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.test.automation.uiautomation.uiactions.CommonWebElementPage;
import com.test.automation.uiautomation.uiactions.HomePage;
import com.test.automation.uiautomation.uiactions.MyAccountPage;
import com.test.automation.uiautomation.config.ReTryAnalyzer;
import com.test.automation.uiautomation.testbase.*;

public class LoginTest extends TestBase {

	public static final Logger logger = Logger.getLogger(LoginTest.class);

	HomePage hp = null;

	@Test(dataProvider = "getData",enabled=false)
	public void verifyLogin(String email, String pass) {

		hp = new HomePage(driver);
		hp.clickSignInLink();
		System.out.println("SignIn clicked");

		hp.enterEmailAddress(email);
		hp.enterPassword(pass);
		MyAccountPage myAccountPage = hp.clickLoginButton(driver);
		System.out.println("Title from UI " + myAccountPage.verifyTitle());

		Assert.assertEquals("MyAccount - MyStore", myAccountPage.verifyTitle(), "Mismatch in Title");

	}

	@DataProvider(name = "getData")
	public Object[][] getData() {
		String data[][] = getData("Sheet1", "TestData.xlsx");

		return data;
	}

}