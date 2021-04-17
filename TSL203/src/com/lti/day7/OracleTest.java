package com.lti.day7;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.Base;

public class OracleTest extends Base{
  @Test(priority=1,alwaysRun=true)
  public void OpenURL() {
	  driver.get("http://127.0.0.1:8080/htmldb");
	  Assert.assertEquals(driver.getTitle(), "HTML DB Login");
  }
  @Test(priority=2,groups="linkTest")
  public void LoginPageLinks() {
	  
	  Assert.assertTrue(driver.findElement(By.linkText("Homepage")).isDisplayed());
	  Assert.assertTrue(driver.findElement(By.linkText("Discussion Forum")).isDisplayed());
	  Assert.assertTrue(driver.findElement(By.linkText("Documentation")).isDisplayed());
	  Assert.assertTrue(driver.findElement(By.linkText("Registration")).isDisplayed());
  }
  @Test(priority=3,groups="functionalTest", dependsOnMethods= {"OpenURL"})
  public void LoginProcess() {
	  driver.findElement(By.xpath("//*[@type='text']")).sendKeys("hr");
	  driver.findElement(By.xpath("//*[@type='password']")).sendKeys("hr");
	  driver.findElement(By.xpath("//*[@type='BUTTON']")).click();
	  Assert.assertEquals(driver.getTitle(), "Oracle","Login Failed");
  }
  @Test(priority=4,groups="linkTest")
  public void HomePageLink() {
	  
	  Assert.assertTrue(driver.findElement(By.linkText("Administration")).isDisplayed());
	  Assert.assertTrue(driver.findElement(By.linkText("Object Browser")).isDisplayed());
	  Assert.assertTrue(driver.findElement(By.linkText("SQL")).isDisplayed());
	  Assert.assertTrue(driver.findElement(By.linkText("Utilities")).isDisplayed());
	  Assert.assertTrue(driver.findElement(By.linkText("Application Builder")).isDisplayed());
  }
}
