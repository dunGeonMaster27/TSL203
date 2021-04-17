package com.lti.day7;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllLinkFactory {
	WebDriver driver;

  public AllLinkFactory (WebDriver driver) {
	//  driver.get("http://127.0.0.1:8080/htmldb/f?p=4550:11:9210216941642359126::NO:::");
	  PageFactory.initElements(driver,this);
	  this.driver=driver;
}
  @FindBy(tagName="a")
  List<WebElement> allLinks;
  
  public void clickLinks() {
	  for(int i=0;i<=allLinks.size();i++) {
		  if(!(allLinks.get(i).getText().equals("Salon Travel")))
		  {
			  allLinks.get(i).click();
		  }
		 driver.navigate().back();
	  }
  }
  
}
