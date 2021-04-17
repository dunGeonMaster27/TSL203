package com.lti.day7;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

public class Headless {
  @Test
  public void f() {
	  WebDriver driver=new HtmlUnitDriver(true);
	  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	  driver.get("http://newtours.demoaut.com/");
	  System.out.println(driver.findElement(By.name("userName")).isDisplayed());
  }
}
