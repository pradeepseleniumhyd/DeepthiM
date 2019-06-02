package com.techm.selenium.home;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Report1 
{
	public ExtentTest test;
	public ExtentReports extent;
	
	@Test
	public void Report1()
	{
		extent = new ExtentReports(System.getProperty("user.dir")+"\\Report\\TechM.html", true);
		
		test = extent.startTest("TC001", "Login for Facebook");
		
		test.log(LogStatus.PASS, "Browser is opened");
		
		test.log(LogStatus.INFO, "Verified status is displayed");
		
	
		test.log(LogStatus.WARNING, "Verified status is displayed");

		test.log(LogStatus.FAIL, "Verified status is displayed");

		
		extent.endTest(test);
		extent.flush();
	
		
	}
	
	@Test
	public void testcase1()
	{
		test = extent.startTest("TC002","Register");
		
		test.log(LogStatus.PASS, "TS001");
		test.log(LogStatus.PASS, "TS002");
		test.log(LogStatus.PASS, "TS003");
		test.log(LogStatus.PASS, "TS004");
		test.log(LogStatus.PASS, "TS005");
		test.log(LogStatus.PASS, "TS006");
		test.log(LogStatus.PASS, "TS007");

		extent.endTest(test);
		extent.flush();
		
		
		
		
		
	}
	

}
