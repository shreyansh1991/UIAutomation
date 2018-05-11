package com.test.automation.uiautomation.uiactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	
	WebDriver driver=null;
	MyAccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
public String verifyTitle()
{
	return driver.getTitle();
}
}
