package com.lti.day6;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class base {
	public WebDriver driver;
	public Properties prop;
	/* @Test
	  public void f() {
		  driver.get(prop.getProperty("url","http://bing.com"));
		 Assert.assertEquals(driver.getTitle(), "Google");
		 driver.findElement(By.name(prop.getProperty("searchField"))).sendKeys("LTI");
	  }*/
	/* @BeforeClass
	  public void beforeClass() {
		  System.setProperty("webdri
			 driver.manage().timeouts().implicitlyver.gecko.driver",".\\Drivers\\geckodriver.exe");
			 driver=new FirefoxDriver();
			// driver.get("https://nseindia.com/");Wait(20, TimeUnit.SECONDS);
	  }*/
	 @BeforeTest
	  public void beforeTest() throws Exception {
		  prop=new Properties();
		  prop.load(new FileInputStream(".\\configuration.property"));
		  
		  if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
		  {
			  System.setProperty("webdriver.gecko.driver",".\\Drivers\\geckodriver.exe");
			  FirefoxOptions op=new FirefoxOptions();
			  op.addArguments("--headless");
			  driver=new FirefoxDriver(op);
			  
			 } 
		  else if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
		  {
		  System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");
	
		  driver=new ChromeDriver();
		  }
		  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		  }

	  @AfterClass(alwaysRun=true)
	  public void afterClass() {
		  driver.quit();
	  }

}
