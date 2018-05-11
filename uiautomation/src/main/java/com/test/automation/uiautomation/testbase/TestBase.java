package com.test.automation.uiautomation.testbase;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.log4testng.Logger;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.uiautomation.constants.Constants;
import com.test.automation.uiautomation.excelreader.Excel_Reader;
import com.test.automation.uiautomation.uiactions.HomePage;

public class TestBase {

	public static final Logger logger = Logger.getLogger(TestBase.class);

	protected static WebDriver driver = null;

	Excel_Reader excelReader = null;
	HomePage hp = null;

	public ExtentReports extent;
	public ExtentTest extentTest;

	@BeforeTest
	public void setExtent() {
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReport.html", true);
		/*
		 * extent.addSystemInfo("Host Name", "Naveen Mac");
		 * extent.addSystemInfo("User Name", "Naveen Automation Labs");
		 * extent.addSystemInfo("Environment", "QA");
		 */
	}

	@BeforeMethod
	public void setUp() throws IOException {

		driver = WebDriverBase.getCurrentDriver();
		WebDriverBase.getCurrentUrl();

		logger.info("Navigated to Required URL");

	}

	@AfterMethod()
	public void clickSignOut(ITestResult result) {

		/*
		 * CommonWebElementPage common = new CommonWebElementPage(driver);
		 * 
		 * common.clickSignOutLink();
		 */

		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(LogStatus.FAIL, "Test Script Failed" + result.getName());
			extentTest.log(LogStatus.FAIL, "Test Script Failed" + result.getThrowable());

		}

	}

	@AfterTest
	public void endReport() {
		extent.flush();
		extent.close();
	}

	@AfterSuite
	public void tearDown() {
		if (driver != null) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			driver.quit();
		}
	}

	public String[][] getData(String sheetName, String excelName) {

		excelReader = new Excel_Reader(Constants.EXCEL_PATH);
		String data[][] = excelReader.getDataFromSheet(sheetName, excelName);
		return data;
	}

	public int getRowCount(String sheetName, String excelName) {

		excelReader = new Excel_Reader(Constants.EXCEL_PATH);
		return excelReader.getRowCount(sheetName, excelName);

	}

	public int getCellCount(String sheetName, String excelName) {

		excelReader = new Excel_Reader(Constants.EXCEL_PATH);
		return excelReader.getCellCount(sheetName, excelName);

	}

	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException, AWTException {
		/*
		 * String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		 * TakesScreenshot ts = (TakesScreenshot) driver; File source =
		 * ts.getScreenshotAs(OutputType.FILE); // after execution, you could see a
		 * folder "FailedTestsScreenshots" // under src folder String destination =
		 * System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName
		 * + dateName + ".png"; File finalDestination = new File(destination);
		 * FileUtils.copyFile(source, finalDestination); return destination;
		 */

		String format = "jpg";

		// // String scriptName=result.getName();
		// System.out.println("Script Name =>"+scriptName);
		String fileName = "FullScreenshot." + format;
		File path = new File(System.getProperty("user.dir") + File.separator + "screenshot" + File.separator
				+ new SimpleDateFormat("dd_MM_YYYY").format(new Date()));
		String pathInString = path.toString();

		File file = new File(pathInString);
		file.mkdirs();
		Robot robot = new Robot();

		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
		try {
			ImageIO.write(screenFullImage, format, new File(pathInString + File.separator + timestamp() + fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("A full screenshot saved!");
		return pathInString;

	}

	private static String timestamp() {
		return "";

	}
}
