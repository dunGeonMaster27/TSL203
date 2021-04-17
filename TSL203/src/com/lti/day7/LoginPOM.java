package com.lti.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPOM {
WebDriver driver;
public LoginPOM(WebDriver driver) {
	this.driver=driver;
}
By E_UN=By.name("p_t01");
By E_PWD=By.name("p_t02");
By E_Login=By.xpath("//*[@id=\"wwvFlowForm\"]/div[6]/table/tbody/tr/td[3]/table[2]/tbody/tr/td/input[1]");
By E_GettingStarted=By.xpath("//*[@id=\"wwvFlowForm\"]/div[6]/table/tbody/tr/td[3]/table[2]/tbody/tr/td/input[2]");

public void LoginProcess(String UserName, String Password) {
	driver.findElement(E_UN).sendKeys(UserName);
	driver.findElement(E_PWD).sendKeys(Password);
	driver.findElement(E_Login).click();
}

public void getStarted() {
	driver.findElement(E_GettingStarted).click();	
}
}
