package com.techm.selenium.utilies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class OpenBrowser 
{
	
	public WebDriver browseropen(WebDriver driver, String browsername) throws Exception
	{
		try
		{
			
			if(browsername.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "D:\\Deepthi\\Techm\\chromedriver.exe");
				driver = new ChromeDriver();
				
			}else if(browsername.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +"\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			}else if(browsername.equalsIgnoreCase("ie"))
			{
				System.setProperty("webdriver.ie.driver", "D:\\Deepthi\\Techm\\drivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				
			}else
			{
				System.out.println(browsername + " is invalid browser name");
				
			}
			
			
			return driver;
			
		}catch(Exception e)
		{
			System.out.println("Browser Open method is failed - " + e.getMessage());
			return null;
		}
		
		
		
	}

}
