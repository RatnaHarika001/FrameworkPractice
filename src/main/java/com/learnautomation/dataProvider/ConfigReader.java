package com.learnautomation.dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public static String getProperty(String key) {
		

		 Properties po = new Properties();
		 try {
			po.load(new FileInputStream(new File(System.getProperty("user.dir") + "/Config/Config.properties")));
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
		
		}
		 String value = po.getProperty(key);
		return value;
	}
	
	public static String getProperty(String key, String configname)
	{
		 Properties po = new Properties();
		 try {
			po.load(new FileInputStream(new File(System.getProperty("user.dir") + "/Config/" + configname +".properties")));
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
		
		}
		 String value = po.getProperty(key);
		return value;
		
	}
}
