package com.lti.day10;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import com.google.common.base.Function;

import utils.Base;

public class FluentExample extends Base{
  @Test
  public void f() {
	  driver.get("http://google.com");
	  Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		       .withTimeout(30, TimeUnit.SECONDS)
		       .pollingEvery(5, TimeUnit.SECONDS)
		       .ignoring(NoSuchElementException.class)
		       .ignoring(StaleElementReferenceException.class);

		   WebElement search = wait.until(new Function<WebDriver, WebElement>() {
		     public WebElement   apply(WebDriver driver) {
		       return driver.findElement(By.name("qq"));
		     }
		   });
		   search.sendKeys("ABC");
		   
  }
}
