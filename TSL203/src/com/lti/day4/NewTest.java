package com.lti.day4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
	WebDriver driver;
  @Test
  public void GoogleTest() {
	  driver.get("https://www.google.com/");
	  String T = driver.getTitle();
	  Assert.assertEquals(T,"Google");
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();  
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
