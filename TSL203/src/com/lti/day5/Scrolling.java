package com.lti.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import utils.Base;

public class Scrolling extends Base{

	@Test
		public void nseIndia() throws Exception
		{
		 driver.get("https://www.nseindia.com/");
		 JavascriptExecutor executor = (JavascriptExecutor) driver;
		 Thread.sleep(3000);
		 executor.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.id("us")));
		 executor.executeScript("window.scrollBy(0,-150)");
		 Thread.sleep(3000);
		 executor.executeScript("window.scrollBy(0, document.body.scrollHeight)");
		 executor.executeScript("window.scrollBy(document.body.scrollWidth,0 )");
		 Thread.sleep(3000);
		 executor.executeScript("arguments[0].click();", driver.findElement(By.linkText("NSETECH")));
		 Thread.sleep(3000);

		}
	
	
}
