package com.learnautomation.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.learnautomation.dataProvider.ConfigReader;


public class BrowserFactory {
	
	public static WebDriver startbrowser(String browsername, String applicationurl)
	{
		WebDriver driver = null;
		
		if(browsername.equalsIgnoreCase("chrome") || browsername.equalsIgnoreCase("GC") || browsername.equalsIgnoreCase("Google Chrome"))
				{
			ChromeOptions opt = new ChromeOptions();
		if(ConfigReader.getProperty("headless").equals("true"))
			{
				opt.addArguments("--headless=new");
			}

			   driver = new ChromeDriver(opt);
				}else if(browsername.equalsIgnoreCase("Edge") || (browsername.equalsIgnoreCase("Microsoft Edge")))
						
				{
					//add the headless check for edge
					driver = new EdgeDriver();
				}else if(browsername.equalsIgnoreCase("Firefox") || browsername.equalsIgnoreCase("Mozilla Firefox") || browsername.equalsIgnoreCase("FF"))
		{
					//add the headless check for firefox
			driver = new FirefoxDriver();
		}else if(browsername.equalsIgnoreCase("Safari"))
		{
			driver = new SafariDriver();
			}else
			{
				driver = new ChromeDriver();
			}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(ConfigReader.getProperty("pageLoad"))));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Integer.parseInt(ConfigReader.getProperty("scriptTimeOut"))));
		driver.get(applicationurl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigReader.getProperty("implicitWait"))));
		
		return driver;
				
	}
				

}
