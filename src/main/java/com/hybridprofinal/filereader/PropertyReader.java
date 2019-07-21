package com.hybridprofinal.filereader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	
FileInputStream fis;
	
	Properties prop;
	
	public PropertyReader() 
	{
		
			try
			{
				File file=new File("./src/main/resources/PropertyReader/SmokeTestData.properties");
				
				fis=new FileInputStream(file);
				
				prop=new Properties();
				
				prop.load(fis);
			}
			catch (Exception e) {
				System.out.println("Property Reader failed due to "+ e);
			}
			
	}
	
	
	
	
	public String getBrowserName()
	{	
		String	browsername=prop.getProperty("BrowserName");			
		return browsername;	
	}
	
	public String getEnvironment()
	{
		String	environment=prop.getProperty("Environment");
		return environment;
	}
	
	
	public String getAppliactionUrl()
	{
		
		
		String	url=prop.getProperty("ApplicationUrl");
		return url;
		
	}
	
	


	public String getTestDataExcelPath()
	{
		String excelfilepath="";
		try
		{
			excelfilepath=prop.getProperty("ExcelTestData");
		}
		catch (Exception e) {
			System.out.println("Get Excel Path failed due to "+ e);
		}
		return excelfilepath;
	}
	
	public String getScreenshotPath()
	{
		String screenshotPath=prop.getProperty("Screnshots");
		
		return screenshotPath;
	}
	


}
