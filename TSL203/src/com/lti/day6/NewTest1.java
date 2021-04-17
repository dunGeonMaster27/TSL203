package com.lti.day6;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTest1 {
	WebDriver driver;
	public Properties prop;
	
  @Test
  public void f() {
	  driver.get(prop.getProperty("url","http://bing.com"));
	 Assert.assertEquals(driver.getTitle(), "Google");
	 driver.findElement(By.name(prop.getProperty("searchField"))).sendKeys("LTI");
  }
  @BeforeTest
  public void beforeTest() throws Exception {
	  prop=new Properties();
	  prop.load(new FileInputStream(".\\configuration.property"));
	  
	  if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
	  {
		  System.setProperty("webdriver.gecko.driver",".\\Drivers\\geckodriver.exe");
		  driver=new FirefoxDriver();
		 } 
	  else if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
	  {
	  System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");
	  driver=new ChromeDriver();
	  }

  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
