package com.test.automation.uiautomation.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.test.automation.uiautomation.constants.Constants;

public class TestConfiguration {
	
	static Properties properties=null;
	public TestConfiguration() throws IOException
	{
	
		File file=new File(Constants.CONFIG_PATH);
		FileInputStream fis=new FileInputStream(file);
		properties=new Properties();
		properties.load(fis);
		
	}
	public static String getCurrentUrl()
	{
		return properties.getProperty("URL1");
	}
	
	public static String getCurrentBrowser()
	{
		
		return properties.getProperty("browser");
	}

	
}
