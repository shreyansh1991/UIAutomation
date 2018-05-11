package com.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.automation.uiautomation.testbase.TestBase;
import com.test.automation.uiautomation.uiactions.SeleniumPracticePage;
import com.test.automation.uiautomation.utilities.GenericUtility;

public class ThirdTest extends TestBase {
	@Test()
	public void handleAlert() throws IOException {
		SeleniumPracticePage sp = new SeleniumPracticePage(driver);
		sp.clickAlertBox();
		GenericUtility.waitForAlertDisplayed();
		Assert.assertEquals(
				"Please share this website with your friends and in your organization.",GenericUtility.getTextFromAlert(),"Mismatch in Alert text");
		
		GenericUtility.acceptAlert();
		
	
	}
}
