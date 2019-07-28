package com.hybridpro.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.hybridprofinal.commonutility.Interaction;
import com.hybridprofinal.initiate.Base;

public class LoginPage extends Base
{
	Interaction action;
	public LoginPage(WebDriver driver)
	{
		driver = this.driver;
		action = new Interaction(driver);
	}
	
	public static By txtusername = By.xpath("//*[@id='txtUsername']");
	public static By txtpassword = By.xpath("//*[@id='txtPassword']");
	public static By loginbtn = By.xpath("//*[@id='btnLogin']");
	
	@Test
	public void VerifyLogin() throws Exception
	{
		try
		{
			action.Type(txtusername, "Admin");
			action.Type(txtpassword,"admin123");
			action.Click(loginbtn);
		}
		catch(Exception e)
		{
			System.out.println("Verify Login failed due to "+ e);
			throw e;
		}
		
		
	}
	
}
