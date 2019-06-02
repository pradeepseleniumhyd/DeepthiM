package com.techm.selenium.home;

import org.openqa.selenium.WebDriverException;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.techm.selenium.businessfunctions.Business;
import com.techm.selenium.utilies.Commons;

public class TC001 extends Commons
{
	Business business = new Business();
	
	
	@BeforeSuite
	public void report()
	{
		extent = new ExtentReports(System.getProperty("user.dir")+"\\Report\\TechM_FAcebook.html", true);
	}
	
	
	@Parameters("browsername")
	@BeforeMethod
	public void browserOpen(String browsername) throws Exception
	{
		driver=ob.browseropen(driver, browsername);
		navigateURL(driver, "https://www.facebook.com/");
		
	}
	
	
	
	@Test
	public void TC001( ) throws Exception
	{
			test = extent.startTest("Facebook Login","Login to the facebook");
		
			sheet=excelRead("TestData");
			System.out.println(sheet.getLastRowNum());
		
			for(int i =0;i<=sheet.getLastRowNum();i++)
			{
				System.out.println(sheet.getRow(i).getCell(0).getStringCellValue());
				
				if(sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase("TC001") && sheet.getRow(i).getCell(2).getStringCellValue().equalsIgnoreCase("Yes") )
				{
					getTitle(driver,test, "Facebook log in or sign up");
					currentURL(driver,test, "http://www.facebook.com/");
					business.facebook_SignUp(driver, test);
					
					
					
					
				}
				
				if(sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase("TC001") && sheet.getRow(i).getCell(2).getStringCellValue().equalsIgnoreCase("No") )
				{
					test.log(LogStatus.SKIP, "TC001 is skipped as Run mode is no");
					throw new SkipException("TC001 is Skipped as Run Mode is No");
				}
				
			}
			
	
	}
	
	
	@AfterMethod
	public void closeBrowser()
	{
		try
		{
			extent.endTest(test);
			extent.flush();
		driver.quit();
		}catch(Exception e)
		{
			System.out.println("Browser is not closed : " + e.getMessage());
		}
	}
	
	

}
