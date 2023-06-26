package com.learnautomation.helper;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v109.io.IO;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.learnautomation.dataProvider.ConfigReader;

public class Utility {
	
	// Find the element until its clickable and it will be highlighted as well
   public static WebElement WebElementwait(WebDriver driver, By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		
		if(ConfigReader.getProperty("highlightElement").equals("true"))
		{
			return WebElementwait(driver, element);
		}
           return element;
	}
   
   public static WebElement WebElementwait(WebDriver driver, WebElement element)
  	{
  	//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
  		JavascriptExecutor js = (JavascriptExecutor) driver;
  		js.executeScript("arguments[0].setAttribute('style','background:yellow; border : 2px solid red');", element);
  		waitforseconds(2);
  		js.executeScript("arguments[0].setAttribute('style','border : 2px solid white');", element);
  		return element;
  	}
   
	
	
	public static void takess(WebDriver driver)
	{
		try
		{	TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File Destn = new File(System.getProperty("user.dir") + "/screenshots/sam2" + Utility.CurrentTimeStamp() + ".png");
		FileHandler.copy(src, Destn);
			
		}
		catch(IOException e)
		{
			System.out.println("IO Exception" + e.getMessage());
		}
	
	}
	
	public static void eless(WebDriver driver, WebElement ele)
	{
		try
		{
			File src = ele.getScreenshotAs(OutputType.FILE);
			File Destn = new File(System.getProperty("user.dir") + "/screenshots/ele" + Utility.CurrentTimeStamp() + ".png");
			FileHandler.copy(src, Destn);
			}catch(IOException e)
		{
				System.out.println("IO Exception" + e.getMessage());
		}
	}
	
	
	
	public static WebElement WebElementwait(WebDriver driver, By locator, int time)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		return element;
		
	}
	
	
	
	public static Alert AlertWait(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		Alert alt = wait.until(ExpectedConditions.alertIsPresent());
		return alt;

	}
	
	public static String AlertWait1(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Alert alt = wait.until(ExpectedConditions.alertIsPresent());
		String text = alt.getText();
		alt.accept();
		return text;
		
	}
	
	
	public static WebElement WebDriverWait(WebDriver driver,By locator)
	{
		WebElement ele = driver.findElement(locator);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.elementToBeClickable(ele));
		return ele;
	}

	public static void selectValuesFromList(WebDriver driver, By locator, String value)
	{
		List<WebElement> list1 = driver.findElements(locator);
		for(WebElement ele : list1)
		{
		     if(ele.getText().contains(value))
		     {
		    	 ele.click();
		    	 System.out.println("TC Passed");
		    	 break;

		     }
			
		}

	}
	
	public static void selectfuturedate(WebDriver driver, By locator1, By locator2, String text)
	{
		driver.findElement(locator1).click();
		List<WebElement> list1 = driver.findElements(locator2);
		for(WebElement abc : list1)
		{
			String value = abc.getText();
			if(value.contains(text))
			{
				abc.click();
			}
		}
		
		
	}
	

	public static void Alert(WebDriver driver)
	{
		
		for(int i=0;i<15;i++)
		try
		{
			driver.switchTo().alert().accept();
			break;
		}catch(NoAlertPresentException e)
		{
			try
			{
				Thread.sleep(1000);
			}catch(Exception e1)
			{
				
			}
			System.out.println("Alert not found");
			
		}
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static String captureScreenshotAsBase64(WebDriver driver)
	{
	TakesScreenshot ts = (TakesScreenshot) driver;
	 String screenshot = ts.getScreenshotAs(OutputType.BASE64);
	 return screenshot;
	}	
	
	public static void CaptureScreenshot(WebDriver driver, WebElement ele1)
	{
		
		File src = ele1.getScreenshotAs(OutputType.FILE);
		File Dstn = new File(System.getProperty("user.dir") + "/screenshots/ele1" + Utility.CurrentTimeStamp() + ".png");
		try {
			FileHandler.copy(src, Dstn);
		} catch (IOException e) {
			
			System.out.println("IOException" + e.getMessage());
		}
		
        
	}
		public static String CurrentTimeStamp()
		{
			String date = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss").format(new Date());
			return date;
		}
	
public static void JSclick(WebDriver driver, By Locator)
{
	try
	{
		driver.findElement(Locator).click();;
	}
	catch(Exception e)
	{
		System.out.println("Normal click failed using JS Executor" );
		waitforseconds(2);
		JavascriptExecutor JS = (JavascriptExecutor) driver;
		JS.executeScript("arguments[0].click()", driver.findElement(Locator));
	}
}

public static void JSsendkeys(WebDriver driver, By Locator, String text)
{
	try
	{
		driver.findElement(Locator).sendKeys(text);
	}
	catch(Exception e)
	{
		System.out.println("Normal click failed using JS Executor" + e.getMessage());
		waitforseconds(2);
		JavascriptExecutor JS = (JavascriptExecutor) driver;
		JS.executeScript("arguments[0].value=arguments[1]", driver.findElement(Locator),text);
		
	}
}
	
	public static void waitforseconds(int seconds)
	{
		System.out.println("Waiting for" + seconds + "seconds");
 	
		try
		{
		Thread.sleep(seconds * 1000);
		
		}catch(InterruptedException e)
		{
			}
	}
	
	public static WebElement HighlightElement(WebDriver driver, By locator)
	{
		WebElement ele = driver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','background:yellow; border : 2px solid red');", ele);
		waitforseconds(3);
		js.executeScript("arguments[0].setAttribute('style','border : 2px solid white');", ele);
		return ele;
		
		
		
		
		}
	
	public static WebElement Highlight(WebDriver driver, By locator)
	{
		WebElement ele = driver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style','background:yellow; border : 2px solid red');", ele);
		waitforseconds(3);
		js.executeScript("arguments[0].setAttribute('style','border : 2px solid white');", ele);
		return ele;
		}
	}

		
	

		
	

		
	


		
	











