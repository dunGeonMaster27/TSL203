package com.lti.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPOM {

	WebDriver driver;
	public LoginPOM(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By E_UN = By.name("p_t01");
	By E_PWD = By.name("p_t02");
	By E_Login = By.xpath("//*[@value='Login']");
	By E_GettingStarted = By.xpath("//*[@value='Getting Started']");
	
	
	public void LoginProcess(String Username, String  Password) {
		driver.findElement(E_UN).sendKeys(Username);
		driver.findElement(E_PWD).sendKeys(Password);
		driver.findElement(E_Login).click();
	}
	
	public void GettingStarted() {
		driver.findElement(E_GettingStarted);
	}
}
