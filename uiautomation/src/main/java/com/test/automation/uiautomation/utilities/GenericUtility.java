package com.test.automation.uiautomation.utilities;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.automation.uiautomation.constants.Constants;
import com.test.automation.uiautomation.testbase.TestBase;
import com.test.automation.uiautomation.testbase.WebDriverBase;

public class GenericUtility extends TestBase {
	static String parentWindow="";
	static int numberwindow = 1;

	public static void switchToChildWindow() {
		numberwindow = numberwindow + 1;
		switchToRequiredWindow(numberwindow);

	}

	public static void switchToParentWindow() {
		System.out.println("number " + numberwindow);
		numberwindow = numberwindow - 1;
		switchToRequiredWindow(numberwindow);

	}

	public static void closeChildWindow() {
		driver.close();

	}
	
	public static void getParentWindowID()
	{
		 parentWindow=driver.getWindowHandle();
	}

	private static void switchToRequiredWindow(int numberwindow) {
		int i = 0;
		Set<String> setOfString = driver.getWindowHandles();

		System.out.println("set =>" + setOfString.size());
		Iterator<String> it = setOfString.iterator();
		while (it.hasNext() && setOfString.size() > 1) {
			String window = it.next();
			System.out.println("Window - " + window);
			i++;
			if (i == numberwindow) {
				System.out.println("Window Title : " + driver.getTitle());
				driver.switchTo().window(window);
				break;
			} else
				System.out.println("Window Title : " + driver.getTitle());
		}
			if (numberwindow == 1) {
				driver.switchTo().window(parentWindow);
			}

	}
	
	public static void waitForAlertDisplayed()
	{
		WebDriverWait wait=new WebDriverWait(driver,Constants.TIME_OUT);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static void acceptAlert() throws IOException
	{
		if(driver!=null)
		driver.switchTo().alert().accept();
		else
		{
			WebDriverBase.getCurrentDriver().switchTo().alert().accept();
		}
	}
	
	public static String getTextFromAlert() throws IOException
	{
		
		Alert alert=driver.switchTo().alert();
		String alertText=alert.getText();
		System.out.println("Alert - "+alert.getText());
		return alertText;
		 
		
	}
}
