package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.learnautomation.helper.Utility;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private By username = By.xpath("//input[@type='email']");
	
	private By password = By.xpath("//input[@type='password']");
	
	private By signinbutton = By.xpath("//button[@type='submit']");
	
	private By signuplink = By.xpath("//a[text()='New user? Signup']");
	
	private By errormsg = By.xpath("//h2[@class='errorMessage']");
	
	public void loginpage(String usernameval, String passwordval)
	{
		Utility.WebElementwait(driver, username).sendKeys(usernameval);
		Utility.WebElementwait(driver, password).sendKeys(passwordval);
		Utility.WebElementwait(driver, signinbutton).click();
	}
	
	public void signup()
	{
		
		Utility.WebElementwait(driver, signuplink).click();
	}

	public String captureerrormsg()
	{
	
		String errmsg = Utility.WebElementwait(driver, errormsg).getText();
		return errmsg;
	}
}
