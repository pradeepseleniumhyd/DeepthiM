package com.techm.selenium.utilies;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.techm.selenium.businessfunctions.Business;



public class Commons 
{
	public WebDriver driver;	// instance variable
	public OpenBrowser ob = new OpenBrowser();
	public String TestData_FilePath = System.getProperty("user.dir")+"\\TestData\\Techm_Testdata.xlsx";
	public XSSFSheet sheet;
	public ExtentTest test;
	public ExtentReports extent;

	
	
	//Need to pass the value to textbox
	public void enterData(WebDriver driver,ExtentTest test, String xpathvalue,String value,String Textboxname)		// method creation
	{
		try
		{
			driver.findElement(By.xpath(xpathvalue)).sendKeys(value);
			test.log(LogStatus.PASS, Textboxname + " : " + value + " is entered");
		}catch(Exception e)
		{
			test.log(LogStatus.FAIL, Textboxname + " : " + value + " is not entered " + e.getMessage());
			System.out.println("Enter Data method is failed - " + e.getMessage());
		}
	}
	
	
	
	public void click(WebDriver driver,ExtentTest test,String xpathvalue,String Buttonname) throws Exception
	{
		try
		{
			driver.findElement(By.xpath(xpathvalue)).click();
			test.log(LogStatus.PASS, Buttonname + " is clicked");
			
		}catch(Exception e)
		{
			test.log(LogStatus.FAIL, Buttonname + " is not clicked " + e.getMessage());

			System.out.println("Click method is failed - " + e.getMessage());
		}
		
	}
	
	public void navigateURL(WebDriver driver,String URL) throws Exception
	{
		try
		{
			driver.get(URL);
			
		}catch(Exception e)
		{
			System.out.println("Navigate URL method is failed - " + e.getMessage());
		}
		
	}
	public void maximize(WebDriver driver) throws Exception
	{
		try
		{
			driver.manage().window().maximize();			
		}catch(Exception e)
		{
			System.out.println("Maximize method is failed - " + e.getMessage());
		}
		
	}
	public void currentURL(WebDriver driver,ExtentTest test,String expectedurl) throws Exception
	{
		try
		{
			String currenturl=driver.getCurrentUrl();
			System.out.println(currenturl);
			
		//	Assert.assertEquals(currenturl, expectedurl);
			
			test.log(LogStatus.PASS, currenturl + " is matched");
			
		}catch(Exception e)
		{
			System.out.println("Current URL method is failed - " + e.getMessage());
			test.log(LogStatus.FAIL, "Current URL method is failed - " + e.getMessage());
			
		}
		
	}
	
	public void getTitle(WebDriver driver,ExtentTest test,String expectedtitle) throws Exception
	{
		try
		{
			String title=driver.getTitle();
			System.out.println(title);
			
			if(title.equalsIgnoreCase(expectedtitle))
			{
				System.out.println(title + " is displayed");
				test.log(LogStatus.PASS, title + " is displayed");
			}else
			{
				System.out.println(title + " is not displayed");
				test.log(LogStatus.FAIL, title + " is not displayed");

			}
			
			
		}catch(Exception e)
		{
			System.out.println("Get Title method is failed - " + e.getMessage());
		}
		
	}
	
	public  XSSFSheet excelRead(String sheetname) throws Exception
	{
		try
		{
			FileInputStream fis = new FileInputStream(TestData_FilePath);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetname);
			return sheet;
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}
	
		

}
