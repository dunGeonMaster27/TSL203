package com.lti.day7;

import org.testng.annotations.Test;

import utils.Base;
import utils.KeyWords;

public class ExecuteKey extends Base {
  @Test
  public void f() {
	
	  KeyWords key = new KeyWords(driver);
	  key.openUrl("https://opensource-demo.orangehrmlive.com/");
	  key.type("id:=txtUsername", "Admin");
	  key.type("id:=txtPassword", "admin123");
	  key.click("id:=btnLogin");
	  key.click("id:=welcome");
	  key.click("linkText:=Logout");
	  
	 
  }
}
