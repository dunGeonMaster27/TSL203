package com.lti.day8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory {

	public HomePageFactory(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Logout")
	WebElement E_Logout;
	
	public void Logout()
	{
		E_Logout.click();
	}
	
}
