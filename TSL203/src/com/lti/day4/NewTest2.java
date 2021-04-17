package com.lti.day4;import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest2 {
	WebDriver driver;
  @Test(priority =1)
  public void TitleTest() {
	  driver.get("https://www.istqb.org/");
	  String T = driver.getTitle();
	  Assert.assertEquals(T, "Certifying Software Testers Worldwide - ISTQB® International Software Testing Qualifications Board");
	  }
  @Test(priority =2,dependsOnMethods= {"TitleTest"})
  public void ReferencesTest() {
	  WebElement E = driver.findElement(By.linkText("References"));
	  	  
	  Assert.assertEquals(E.isDisplayed(),true);
	  Assert.assertEquals(E.isEnabled(),true); 
	  Assert.assertEquals(E.getAttribute("href"),"https://www.istqb.org/references.html","URL  -  Mismatch");
	  
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
