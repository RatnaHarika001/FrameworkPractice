package com.learnautomation.dataProvider;

import org.testng.annotations.DataProvider;



public class CustomDataProvider {
	
	@DataProvider(name="Credentials")
	public static Object[][] test2()
	{
		
		Object arr[][] = ExcelReader.getDataFromSheet("LoginNew");
		return arr;
		
	}

}
