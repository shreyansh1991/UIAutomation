package com.testscripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.uiautomation.testbase.TestBase;

public class TestScenarioWithMultipleData extends TestBase{

	
	@Test(dataProvider="getData")
	public void demo(String userName,String password,String runMode)
	{
		System.out.println(userName +""+password + ""+ runMode);
		
		System.out.println("\n");
	}
	@DataProvider(name="getData")
	public String[][] getData() {
		String data[][]=getData("Sheet1","TestData.xlsx");
		return data;
		
	}
}
