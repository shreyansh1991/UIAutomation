package com.test.automation.uiautomation.uiactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumPracticePage {
	WebDriver driver = null;
	@FindBy(id = "button1")
	private WebElement newBrowserWindowButton;

	@FindBy(xpath = "//strong[contains(text(),'Agile Testing')]")
	private static WebElement header;

	@FindBy(xpath = "//button[text()='New Message Window']")
	private WebElement newMessageWindow;

	@FindBy(xpath = "//body[contains(text(),'This message window is only for viewing purposes')]")
	private WebElement headerText;

	@FindBy(id = "alert")
	private WebElement alertBoxButton;

	@FindBy(xpath = "//button[contains(text(),'New Browser Tab')]")
	private WebElement newBrowserTab;

	public SeleniumPracticePage(WebDriver driver) {
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickNewBrowserButtonWindow() {
		newBrowserWindowButton.click();
		
	}

	public static String getHeaderText() {
		return header.getText();
	}

	public void clickNewMessageWindow() {
		newMessageWindow.click();
	}

	public String getHeaderTextInDeveloperToolsPage() {
		return headerText.getText();
	}

	public void clickAlertBox() {
		alertBoxButton.click();
	}
	
	public void clickNewTabButton()
	{
		newBrowserTab.click();
	}

}
