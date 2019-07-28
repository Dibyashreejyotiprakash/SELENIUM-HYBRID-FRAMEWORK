package com.hybridprofinal.listener;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.hybridprofinal.initiate.Base;

public class ScreenShotListners implements ITestListener
{
	Base base = new Base();
	String filePath = "./src/test/resources/ScreenShot";
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("***** Error "+result.getName()+" test has failed *****");
    	String methodName=result.getName().toString().trim();
        String filepath = "./ScreenShots";
    	 File scrFile = ((TakesScreenshot)base.driver).getScreenshotAs(OutputType.FILE);
            try {
				FileUtils.copyFile(scrFile, new File("./ScreenShots/testscreenshot.png"));
				System.out.println("***Placed screen shot in "+filePath+" ***");
				} catch (IOException e) {
				e.printStackTrace();
			}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
