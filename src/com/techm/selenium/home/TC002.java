package com.techm.selenium.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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

public class TC002 extends Commons
{
	public Business business = new Business();
	
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
	public void TC002( ) throws Exception
	{
		
		test = extent.startTest("Facebook - Register");
			sheet=excelRead("TestData");
			System.out.println(sheet.getLastRowNum());
		
			for(int i =0;i<=sheet.getLastRowNum();i++)
			{
				System.out.println(sheet.getRow(i).getCell(0).getStringCellValue());
				test.log(LogStatus.PASS, sheet.getRow(i).getCell(0).getStringCellValue());
				if(sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase("TC002") && sheet.getRow(i).getCell(2).getStringCellValue().equalsIgnoreCase("Yes") )
				{
					
					WebElement we = driver.findElement(By.xpath("//select[@id='month']"));
					Select sel = new Select(we);
					
					sel.selectByIndex(10);
					
					Thread.sleep(5000);
					
					sel.selectByValue("12");
					
					Thread.sleep(5000);
					
					sel.selectByVisibleText("Jan");
				}
				
				if(sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase("TC002") && sheet.getRow(i).getCell(2).getStringCellValue().equalsIgnoreCase("No") )
				{
					test.log(LogStatus.SKIP, "TC001 is skipped as Run mode is no");

					throw new SkipException("TC002 is Skipped as Run Mode is No");
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
