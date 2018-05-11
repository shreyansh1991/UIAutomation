package com.test.automation.uiautomation.uiactions;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonWebElementPage {
	WebDriver driver = null;

	@FindBy(css = "a[title='Log me out']")
	private WebElement signOutLink;

	public CommonWebElementPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickSignOutLink() {
		try {
			if (signOutLink.isDisplayed()) {
				signOutLink.click();

			}
		} catch (NoSuchElementException e) {
			System.out.println("SignOut link is not displayed!" + e);

		}

		
	}
}