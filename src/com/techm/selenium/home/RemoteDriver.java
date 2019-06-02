package com.techm.selenium.home;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class RemoteDriver {
	
	@Test
	public void test() throws Exception
	{
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.ANY);
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.43.122:4444/wd/hub"), dc);
		
		
		
		driver.quit();
	}

}
