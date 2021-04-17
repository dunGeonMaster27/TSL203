package com.lti.day8;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

public class HeadLess{
  @Test
  public void f() {
	   WebDriver driver = new HtmlUnitDriver(true);//To enable Javascript Support mention 'true' in HtmlUnitDriver
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.get("http://google.com");
	  System.out.println(driver.findElement(By.name("userName")).isDisplayed());
  }
}
