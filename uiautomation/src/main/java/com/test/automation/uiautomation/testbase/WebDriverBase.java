package com.test.automation.uiautomation.testbase;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.log4testng.Logger;

import com.test.automation.uiautomation.config.TestConfiguration;

public class WebDriverBase {

	public static final Logger logger = Logger.getLogger(WebDriverBase.class);
	private static WebDriver driver = null;

	private WebDriverBase() {
	}

	public static WebDriver getCurrentDriver() throws IOException {

		String browserName = new TestConfiguration().getCurrentBrowser();
		System.out.println("browserName ==>" + browserName);
		if (driver == null) {
			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator
						+ "driver_exe" + File.separator + "chromedriver.exe");
				driver = new ChromeDriver();

			} else if (browserName.equalsIgnoreCase("firefox")) {
				// write Code here
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//			String log4jConfigPath = "log4j.properties";
//			PropertyConfigurator.configure(log4jConfigPath);
			return driver;

		} else {
			return driver;
		}

	}

	public static void getCurrentUrl() {
		System.out.println("TestConfiguration.getCurrentUrl() ===> " + TestConfiguration.getCurrentUrl());
		driver.get(TestConfiguration.getCurrentUrl());

		logger.info("Inside getCurrentUrl Method");
	}

}
