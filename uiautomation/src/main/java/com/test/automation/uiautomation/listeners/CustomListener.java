package com.test.automation.uiautomation.listeners;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.test.automation.uiautomation.testbase.TestBase;

public class CustomListener extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	public static String timestamp() throws IOException {

		return new SimpleDateFormat(File.separator + "yyyy-MM-dd HH-mm-ss").format(new Date());
	}

	public void onTestFailure(ITestResult result) {
		try {

			String format = "jpg";
		

			String scriptName=result.getName();
			System.out.println("Script Name =>"+scriptName);
			String fileName = scriptName+"FullScreenshot." + format;
			File path = new File(System.getProperty("user.dir") + File.separator +
					"screenshot" + File.separator
					+ new SimpleDateFormat("dd_MM_YYYY").format(new Date()));
			String pathInString = path.toString();

			File file = new File(pathInString);
			file.mkdirs();
			Robot robot = new Robot();

			Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
			try {
				ImageIO.write(screenFullImage, format,
						new File(pathInString + File.separator +timestamp() + fileName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		System.out.println("A full screenshot saved!");

		
	}
	
}
