package com.hybridprofinal.listener;

import org.testng.ITestResult;

public class ExecuteFailedTestCasesListener {
	
	private int retrycount=0;
	private final int retrycountretrycount = 10;
	
	public boolean retry(ITestResult result) {

		if (retrycount <= retrycount) {
			try {
				Thread.sleep(3000);
				System.out.println(String.format("Method name : Retry Count ",result.getMethod(), retrycount));
				System.out.println(result.getName());
				System.out.println(result.getTestName());
				System.out.println(result.getStatus());
				
				retrycount++;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return false;
	}

}
