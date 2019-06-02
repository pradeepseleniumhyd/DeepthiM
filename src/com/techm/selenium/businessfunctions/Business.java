package com.techm.selenium.businessfunctions;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.techm.selenium.utilies.Commons;

public class Business extends Commons
{
	
	 public void facebook_SignUp(WebDriver driver, ExtentTest test)
	 {
		 try
		 {
			 	enterData(driver,test, "//input[@name='firstname']", "Deepthi","First Name");
				enterData(driver,test, "//input[@name='lastname']", "Selenium", "SurName");
				enterData(driver,test, "(//input[contains(@aria-label,'Mobile number')])[1]", "9090909090","Mobile Number");
				enterData(driver,test, "(//input[contains(@aria-label,'New password')])[1]", "selenium@123", "Password");
				click(driver,test, "(//input[contains(@name,'sex')])[1]","Female Radio Button");

		 }catch(Exception e)
		 {
			 System.out.println("Facebook Signup is failed " + e.getMessage());
		 }
	 }
	

}
