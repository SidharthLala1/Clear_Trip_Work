package org.cleartrip.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserSelection 
{
	static WebDriver driver;
		
	public static WebDriver UsingChrome()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sidha\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");		
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
		return driver;
	}
}