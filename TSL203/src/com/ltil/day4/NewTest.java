package com.ltil.day4;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTest {

	WebDriver driver;
  @Test
  public void GoogleTest() {
	  driver.get("https://www.google.com/");
	  String str=driver.getTitle();
	  Assert.assertEquals(str, "Google");	 
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.gecko.driver",".\\Drivers\\geckodriver.exe");
		 driver=new FirefoxDriver();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
	}

