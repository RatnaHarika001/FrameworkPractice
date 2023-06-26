package com.learnautomation.helper;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.learnautomation.dataProvider.ConfigReader;
import com.learnautomation.factory.BrowserFactory;

public class BaseClass {
	
	public WebDriver driver;
	
	@BeforeClass
	public void startApplication()
	{
		System.out.println("LOG:INFO - Running Before Class - Setting up Application");
     	 driver =	BrowserFactory.startbrowser(ConfigReader.getProperty("browser"), ConfigReader.getProperty("url"));
		
	}
	
	//@AfterClass
	public void teardown()
	{
		System.out.println("LOG:INFO - Running After Class - Terminating Application");
         driver.quit();
	}

}
