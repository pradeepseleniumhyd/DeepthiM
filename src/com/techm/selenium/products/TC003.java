package com.techm.selenium.products;

import org.openqa.selenium.WebDriverException;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.techm.selenium.utilies.Commons;

public class TC003 extends Commons
{
	
	@Parameters("browsername")
	@BeforeMethod
	public void browserOpen(String browsername) throws Exception
	{
		driver=ob.browseropen(driver, browsername);
		navigateURL(driver, "https://www.facebook.com/");
		
	}
	
	
	
	@Test
	public void TC003( ) throws Exception
	{
		
			sheet=excelRead("TestData");
			System.out.println(sheet.getLastRowNum());
		
			for(int i =0;i<=sheet.getLastRowNum();i++)
			{
				System.out.println(sheet.getRow(i).getCell(0).getStringCellValue());
				
				if(sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase("TC003") && sheet.getRow(i).getCell(2).getStringCellValue().equalsIgnoreCase("Yes") )
				{
					//getTitle(driver, "Facebook log in or sign up");
					//currentURL(driver, "http://www.facebook.com/");
				}
				
				if(sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase("TC003") && sheet.getRow(i).getCell(2).getStringCellValue().equalsIgnoreCase("No") )
				{
					throw new SkipException("TC003 is Skipped as Run Mode is No");
				}
				
			}
			
	
	}
	
	
	@AfterMethod
	public void closeBrowser()
	{
		try
		{
		driver.quit();
		}catch(Exception e)
		{
			System.out.println("Browser is not closed : " + e.getMessage());
		}
	}
	
	

}
