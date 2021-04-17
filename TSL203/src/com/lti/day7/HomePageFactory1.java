package com.lti.day7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory1{

	public HomePageFactory1(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(linkText="Login")
	WebElement E_LogIn;
	
	public void LogIn()
	{
		E_LogIn.click();
	}
}
