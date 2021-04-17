package com.ltil.day5;

import org.openqa.selenium.By;
import org.testng.Assert;


import org.testng.annotations.Test;

public class OracleTest extends base {
  @Test(priority =1,groups="OpenUrl")
  public void OpenURL()
  {
	  driver.get("http://127.0.0.1:8080/htmldb/f?p=4550:11:9108100186384194133::NO:::");
	  Assert.assertEquals(driver.getTitle(),"HTML DB Login");
  }
  @Test(priority =2,groups="linkTest")
  public void LoginPageLinks() 
  {
	  Assert.assertTrue(driver.findElement(By.linkText("Homepage")).isDisplayed());
	  Assert.assertTrue(driver.findElement(By.linkText("Discussion Forum")).isDisplayed());
	  Assert.assertTrue(driver.findElement(By.linkText("Documentation")).isDisplayed());
	  Assert.assertTrue(driver.findElement(By.linkText("Registration")).isDisplayed());
  }
  @Test(priority =3,groups="functionalTest",dependsOnMethods= {"OpenURL"})
  public void LoginProcess() 
  {
	 driver.findElement(By.xpath("//*[@id=\"P11_USERNAME\"]")).sendKeys("system");
	 driver.findElement(By.xpath("//*[@id=\"P11_PASSWORD\"]")).sendKeys("Newuser123");
	 driver.findElement(By.xpath("//*[@id=\"wwvFlowForm\"]/div[6]/table/tbody/tr/td[3]/table[2]/tbody/tr/td/input[1]")).click();
	 Assert.assertEquals(driver.getTitle(), "Oracle","Login Failed");
  }
  @Test(priority =4,groups="linkTest")
  public void HomePageLinks ()
  {
	  Assert.assertTrue(driver.findElement(By.linkText("Administration")).isDisplayed());
	  Assert.assertTrue(driver.findElement(By.linkText("Object Browser")).isDisplayed());
	  Assert.assertTrue(driver.findElement(By.linkText("SQL")).isDisplayed());
	  Assert.assertTrue(driver.findElement(By.linkText("Utilities")).isDisplayed());
	  
  }
}
