package com.lti.day8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginFactory {

	public LoginFactory(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="p_t01") 
	WebElement E_UN;
	@FindBy(name="p_t02") 
	WebElement E_PWD;
	@FindBy(xpath="//*[@value='Login']") 
	WebElement E_Login;

	public void LoginProcess(String UN, String PWD)
	{
		E_UN.sendKeys(UN);
		E_PWD.sendKeys(PWD);
		E_Login.click();
	}
	
}
