package com.lti.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePOM {
WebDriver driver;
public HomePOM(WebDriver driver)
{
	this.driver=driver;
}
By E_LOGOUT=By.linkText("Logout");
public void Logout()
{
	driver.findElement(E_LOGOUT).click();
}
	
	
	
	
}
