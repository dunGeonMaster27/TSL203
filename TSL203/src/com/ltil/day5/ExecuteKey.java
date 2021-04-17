package com.ltil.day5;

import org.testng.annotations.Test;



public class ExecuteKey extends base{
  @Test
  public void f () throws Exception
  {
	  KeyWords Key=new KeyWords(driver);
	  Key.openUrl("https://opensource-demo.orangehrmlive.com/");
	  Key.type("id:=txtUsername", "Admin");
	  Key.type("id:=txtPassword", "admin123");
	  Key.click("id:=btnLogin");
	  Key.click("id:=welcome");
	  Thread.sleep(3000);
	  Key.click("xpath:=//*[text()='Logout']");
	  


  }
}
