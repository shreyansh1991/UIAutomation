package com.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.automation.uiautomation.testbase.TestBase;
import com.test.automation.uiautomation.uiactions.SeleniumPracticePage;
import com.test.automation.uiautomation.utilities.GenericUtility;

public class SecondTest extends TestBase {
	@Test()
	public void handleChildWindow() {
		SeleniumPracticePage sp = new SeleniumPracticePage(driver);
		sp.clickNewBrowserButtonWindow();
		GenericUtility.getParentWindowID(); // to get Parent window id
		GenericUtility.switchToChildWindow();
		Assert.assertEquals("Agile Testing and ATDD Automation –  Free Tutorials", sp.getHeaderText());

		GenericUtility.closeChildWindow();
		GenericUtility.switchToParentWindow();
		sp.clickNewMessageWindow();
		GenericUtility.getParentWindowID();
		GenericUtility.switchToChildWindow();
		String text=sp.getHeaderTextInDeveloperToolsPage();
		Assert.assertEquals("This message window is only for viewing purposes", text,"Text Mismatch");
	
		GenericUtility.closeChildWindow();
		GenericUtility.switchToParentWindow();
	
	
	}
	
	
}
