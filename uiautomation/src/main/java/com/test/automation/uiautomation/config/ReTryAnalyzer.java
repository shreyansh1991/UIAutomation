package com.test.automation.uiautomation.config;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ReTryAnalyzer implements IRetryAnalyzer{

	int count=0;
	int reTryCount=1;
	public boolean retry(ITestResult result) {
		if(count<reTryCount)
		{
			count++;
			return true;
		}
		return false;
	}

}
