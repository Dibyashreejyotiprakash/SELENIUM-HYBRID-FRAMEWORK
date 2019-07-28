package com.hybridprofinal.listener;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer
{
	
	private int retrycount=0;
	private final int maxretrycount = 3;
	
	
	public boolean retry(ITestResult result) {
		
		if (retrycount < maxretrycount) {
				System.out.println(String.format("Method name : Retry Count ",result.getMethod(), retrycount));
				System.out.println("Name --"+result.getName());
				System.out.println("Test Name --"+result.getTestName());
				System.out.println("Status--"+result.getStatus());
				
				//logger.info("Retrying test "+ result.getName()+"with status"+ getResultStatusName(result.getStatus())+"for the"+(retrycount+1)+"times.");	
				retrycount++;
				return true;
		}

		return false;
	}
	
	public String getResultStatusName(int status)
	{
		String resuLtName = null;
		if(status == 1)
		{
			resuLtName ="SUCCESS";
		}
		else if(status == 2)
		{
			resuLtName ="FAILURE";
		}
		else if(status == 3)
		{
			resuLtName ="SKIP";
		}
		
		return resuLtName;
		
	}

}
