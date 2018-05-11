package com.test.automation.uiautomation.uiactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;
	@FindBy(css = "a[title='Log in to your customer account']")
	private WebElement signInLink;
	
	@FindBy(id ="email")
	private WebElement emailAddressTextBox;
	
	@FindBy(id ="passwd")
	private WebElement passwordTextBox;
	
	@FindBy(id ="SubmitLogin")
	private WebElement signInButton;
	
	

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickSignInLink() {
		signInLink.click();
	}
	
	public void enterEmailAddress(String userName) {
		emailAddressTextBox.sendKeys(userName);
	}
	
	public void enterPassword(String password) {
		passwordTextBox.sendKeys(password);
	}
	
	public MyAccountPage clickLoginButton(WebDriver driver) {
		signInButton.click();
		return new MyAccountPage(driver);
	}

}
