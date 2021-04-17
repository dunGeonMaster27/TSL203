package com.ltil.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class NewTest6 extends base {
  @Test
  public void f()throws Exception {
	  driver.get("http://nseindia.com/");
	  JavascriptExecutor executor=(JavascriptExecutor)driver;
	  Thread.sleep(6000);
	  executor.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.id("us")));
	  Thread.sleep(6000);
	  executor.executeScript("window.scrollBy(0,-145)");
	  Thread.sleep(6000);
	  executor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	  Thread.sleep(6000);
	  executor.executeScript("window.scrollBy(document.body.scrollWidth,0)");
	  Thread.sleep(6000);
	  executor.executeScript("argument[0].click();",driver.findElement(By.linkText("NSETECH")));
	  Thread.sleep(6000);
  }
}
