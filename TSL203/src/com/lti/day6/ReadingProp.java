package com.lti.day6;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class ReadingProp
{
	WebDriver driver;
	Properties prop;
  @Test
  public void f() {
	  driver.get(prop.getProperty("url","http://bing.com"));
	  
	  Assert.assertEquals(driver.getTitle(), "Google");
	  //Assert.assertTrue(driver.getTitle().equals("Google"));
	  
	  
	  
	  driver.findElement(By.name(prop.getProperty("searchField"))).sendKeys("LTI");
	  
  }
  @BeforeTest
  public void beforeTest() throws Exception{
	  prop = new Properties();
	  prop.load(new FileInputStream(".\\config.property"));
	  
	  if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
	  {
		  System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
		  driver = new FirefoxDriver();
	  }
	  else if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
	  {
		  System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		  driver = new ChromeDriver();
	  }
  }
  

  @AfterTest
  public void afterTest() {
  }

}
