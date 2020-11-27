package org.cleartrip.com;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClearTripProject 
{
WebDriver driver;
	
	@BeforeMethod
	public void OpenBrowser()
	{	
		
		driver = BrowserSelection.UsingChrome();				
	}
	
	@Test
	public void TripDetails() throws InterruptedException
	{
		driver.get("https://www.cleartrip.com/");		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
		driver.findElement(By.id("RoundTrip")).click();
		driver.findElement(By.xpath("//input[@id='FromTag']")).click();
		driver.findElement(By.xpath("//input[@id='FromTag']")).clear();
		driver.findElement(By.xpath("//input[@id='FromTag']")).sendKeys("Delhi");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@id='ui-id-1']/li/a[text()='New Delhi, IN - Indira Gandhi Airport (DEL)']")).click();
		
		driver.findElement(By.xpath("//input[@id='ToTag']")).click();
		driver.findElement(By.xpath("//input[@id='ToTag']")).clear();
		driver.findElement(By.xpath("//input[@id='ToTag']")).sendKeys("BOM");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@id='ui-id-2']/li/a[text()='Mumbai, IN - Chatrapati Shivaji Airport (BOM)']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='DepartDate']")).click();
		Thread.sleep(2000);
		
		
		/**
		 * https://www.swtestacademy.com/datepicker-using-selenium/
		 */
		
		/**
		 * https://stackoverflow.com/questions/21422548/how-to-select-the-date-picker-in-selenium-webdriver
		 */
		
		String date = "10-October-2018";
		String splitter[] = date.split("-");
		String month_year = splitter[1];
		String day = splitter[0];	
		System.out.println(month_year);
		System.out.println(day);
		
		selectDate(month_year,day);	
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id='SearchBtn']")).click();
		Thread.sleep(5000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,3000)");		
		driver.findElement(By.xpath(".//*[@id='1_1_G8']")).click();
		Thread.sleep(5000);		
		
		js.executeScript("window.scrollBy(0,3000)");
		driver.findElement(By.xpath(".//*[@id='1_1_6E']")).click();
		Thread.sleep(5000);
		
		js.executeScript("window.scrollBy(0,3000)");
		driver.findElement(By.xpath(".//*[@id='1_1_9W']")).click();
		Thread.sleep(5000);
		
		js.executeScript("window.scrollBy(0,3000)");
		driver.findElement(By.xpath(".//*[@id='1_1_SG']")).click();
		Thread.sleep(5000);
		
		js.executeScript("window.scrollBy(0,3000)");
		driver.findElement(By.xpath(".//*[@id='1_1_UK']")).click();
		Thread.sleep(5000);
		
		//List<WebElement> flights = driver.findElements(By.xpath(".//*[@id='flightForm']/section[2]/div[4]/div/nav/ul/li[1]/table/tbody[2]/tr[1]/th[1]/small[1]"));
		
		List<WebElement> flights = driver.findElements(By.xpath(".//*[@id='flightForm']/section[2]/div[4]/div/nav/ul/li"));
		
		System.out.println("No. of Air India flight search results: ---"+flights.size());
		
		
		
		
	}
	public void selectDate(String monthyear, String Selectday) throws InterruptedException
	{		
		List<WebElement> elements = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/div/div/div/span[1]"));
				
		for (int i=0; i<elements.size();i++)
		{
			System.out.println(elements.get(i).getText());
			//Selecting the month
			if(elements.get(i).getText().equals(monthyear))
			{				
				//Selecting the date				
				List<WebElement> days = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/div[2]/table/tbody/tr/td/a"));
				
				for (WebElement d:days)
				{					
					System.out.println(d.getText());
					if(d.getText().equals(Selectday))
					{
						d.click();
						Thread.sleep(10000);
						return;
					}
				}								
				
			}			
					
		}
		driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[2]/div/a")).click();
		selectDate(monthyear,Selectday);
		
	}
	
	@AfterMethod
	public void CloseBrowser()
	{
		driver.quit();
	}

}