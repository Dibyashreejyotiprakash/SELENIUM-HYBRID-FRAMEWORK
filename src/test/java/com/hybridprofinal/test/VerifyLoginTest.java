package com.hybridprofinal.test;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.PageFactory;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.hybridpro.pageobjects.HomePage;
import com.hybridpro.pageobjects.LoginPage;
import com.hybridprofinal.commonutility.*;
import com.hybridprofinal.filereader.JsonReader;
import com.hybridprofinal.initiate.Base;

@Listeners(com.hybridprofinal.listener.ScreenShotListners.class)
public class VerifyLoginTest extends Base
{
	LoginPage loginpage = new LoginPage(driver);
	HomePage homepage = new HomePage(driver);
	Interaction action = new Interaction(driver);
	@Test
	public void VerifyLogin(Method result) throws IOException, ParseException
	{
		
		try
		{
			GetUrl("ADMIN");
			logger.info("Application launched");
			extentTest.log(Status.INFO, result.getName()+"Application launched");
			loginpage.VerifyLogin();
			extentTest.log(Status.INFO, result.getName()+"Logged in Successfully.");
			homepage.VerifyHomePage();
			extentTest.log(Status.INFO, result.getName()+"Home Page verified in Successfully.");
		}
		catch(Exception e)
		{
			System.out.println("Verify Login failed due to "+ e);
		}
	}
	
	
	
	
	
}
