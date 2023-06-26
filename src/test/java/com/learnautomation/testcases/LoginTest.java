package com.learnautomation.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.learnautomation.constants.Constants;
import com.learnautomation.dataProvider.CustomDataProvider;
import com.learnautomation.factory.BrowserFactory;
import com.learnautomation.helper.BaseClass;
import com.learnautomation.pages.LoginPage;

public class LoginTest extends BaseClass {

	@Test(dataProvider = "Credentials", dataProviderClass=CustomDataProvider.class)
	
	public void loginToApp(String username, String password)
	{
	
		LoginPage login = new LoginPage(driver);
		login.loginpage(username, password);
		String errormsg = login.captureerrormsg();
	//	Assert.assertTrue(errormsg.contains(Constants.userDoesNotExist), "Error message did not match");
	//	boolean status = login.captureerrormsg().contains(Constants.userDoesNotExist);
		boolean status = errormsg.contains("USER Email Doesn't Exist");
		Assert.assertTrue(status, "Error message did not match");
	}
}
