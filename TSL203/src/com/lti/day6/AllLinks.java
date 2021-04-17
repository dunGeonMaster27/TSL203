package com.lti.day6;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AllLinks extends base{
  @Test
  public void f() {
	  driver.get("http://newtours.demoaut.com/");
	  List<WebElement> allLinks=driver.findElements(By.tagName("a"));
	  for(int i=0;i<allLinks.size();i++)
	  {
		System.out.println(allLinks.get(i).getText());
		allLinks.get(i).click();
		driver.navigate().back();
		allLinks=driver.findElements(By.tagName("a"));
	  }
	  }
}
