package com.hybridprofinal.test;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

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
import com.hybridpro.pageobjects.LoginPage;
import com.hybridprofinal.commonutility.*;
import com.hybridprofinal.initiate.Base;

@Listeners(com.hybridprofinal.listener.Listners.class)
public class VerifyLoginTest extends Base
{
	LoginPage loginpage = new LoginPage(driver);
	Interaction action = new Interaction(driver);
	@Test
	public void VerifyLogin(Method result) throws IOException
	{
		
		GetUrl("ADMIN");
		logger.info("Application launched");
		extentTest.log(Status.INFO, result.getName()+"Application launched");
		loginpage.VerifyLoginPage();
		logger.info(result.getName()+"Application Logged Successfully.");
		extentTest.log(Status.INFO, result.getName()+"Application Logged Successfully.");
		String homepageurl = action.GetTitle();
		System.out.println("Home Page Title "+ homepageurl);
		Assert.assertEquals(homepageurl, "OrangeHRM1");
		
	}
	
}
