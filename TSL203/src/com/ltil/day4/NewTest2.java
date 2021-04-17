package com.ltil.day4;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTest2 {
	WebDriver driver;
  @Test
  public void f() {
	 driver.get("https://www.istqb.org/");
	 String str=driver.getTitle();
	 Assert.assertEquals(str, "Certifying Software Testers Worldwide - ISTQB® International Software Testing Qualifications Board");	 
	  
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
