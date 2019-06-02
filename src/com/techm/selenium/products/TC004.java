package com.techm.selenium.products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.techm.selenium.utilies.Commons;

public class TC004 extends Commons
{
	
	@Parameters("browsername")
	@BeforeMethod
	public void browserOpen(String browsername) throws Exception
	{
		driver=ob.browseropen(driver, browsername);
		navigateURL(driver, "https://www.facebook.com/");
		
	}
	
	
	
	@Test
	public void TC004( ) throws Exception
	{
		
			sheet=excelRead("TestData");
			System.out.println(sheet.getLastRowNum());
		
			for(int i =0;i<=sheet.getLastRowNum();i++)
			{
				System.out.println(sheet.getRow(i).getCell(0).getStringCellValue());
				
				if(sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase("TC004") && sheet.getRow(i).getCell(2).getStringCellValue().equalsIgnoreCase("Yes") )
				{
					
					WebElement we = driver.findElement(By.xpath("//select[@id='month']"));
					Select sel = new Select(we);
					
					sel.selectByIndex(10);
					
					Thread.sleep(5000);
					
					sel.selectByValue("12");
					
					Thread.sleep(5000);
					
					sel.selectByVisibleText("Jan");
				}
				
				if(sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase("TC004") && sheet.getRow(i).getCell(2).getStringCellValue().equalsIgnoreCase("No") )
				{
					throw new SkipException("TC004 is Skipped as Run Mode is No");
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
