package com.ltil.day4;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class base {
	public WebDriver driver;
	 @BeforeClass
	  public void beforeClass() {
		  System.setProperty("webdriver.gecko.driver",".\\Drivers\\geckodriver.exe");
			 driver=new FirefoxDriver();
			// driver.get("https://nseindia.com/");
			 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  }

	  @AfterClass
	  public void afterClass() {
		  driver.quit();
	  }

}
