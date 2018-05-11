package com.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.automation.uiautomation.testbase.TestBase;
import com.test.automation.uiautomation.uiactions.SeleniumPracticePage;
import com.test.automation.uiautomation.utilities.GenericUtility;

public class HandleNewTab extends TestBase {
	
	@Test
	public void handleNewTab()
	{
		System.out.println("inside testscript handleNewTab");
		SeleniumPracticePage sp = new SeleniumPracticePage(driver);
		sp.clickNewTabButton();
		GenericUtility.getParentWindowID(); // to get Parent window id
		GenericUtility.switchToChildWindow();
		Assert.assertEquals("Agile Testing and ATDD Automation –  Free Tutorials", sp.getHeaderText());

		GenericUtility.closeChildWindow();
		GenericUtility.switchToParentWindow();

		
	}

}
