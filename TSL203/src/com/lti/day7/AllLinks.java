package com.lti.day7;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.Base;

public class AllLinks extends Base {
  @Test
  public void LinkCheck() {
	  driver.get("http://newtours.demoaut.com/");
	  
	  List<WebElement> allLinks = driver.findElements(By.tagName("a"));
	  
	  for(int i=0;i<allLinks.size();i++)
	  {
		  System.out.println(allLinks.get(i).getText());
		  allLinks.get(i).click();
		  driver.navigate().back();
		  allLinks = driver.findElements(By.tagName("a"));//stale reference element for refreshing the elements from list
	  }
	  
  }
}
