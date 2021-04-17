package com.ltil.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RefTest {
	WebDriver driver;
	  @Test(priority=1)
	  public void f() {
		 driver.get("https://www.istqb.org/");
		 String str=driver.getTitle();
		 Assert.assertEquals(str, "Certifying Software Testers Worldwide - ISTQB® International Software Testing Qualifications Board");	 
		  }
	  @Test(priority=2,dependsOnMethods= {"f"})
	  public void ReferencesTest() {
		  	WebElement ele=driver.findElement(By.linkText("References"));
		  	
		  	Assert.assertEquals(ele.isDisplayed(),true);
			Assert.assertEquals(ele.isEnabled(),true);
			Assert.assertEquals(ele.getAttribute("href"),"https://www.istqb.org/references.html","url mis-matched");
		  	
		  	
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
