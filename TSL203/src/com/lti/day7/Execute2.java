package com.lti.day7;

import org.testng.annotations.Test;

import com.lti.day6.base;

public class Execute2 extends base{
	@Test(enabled=false)
  public void f() {
	  driver.get("http://127.0.0.1:8080/htmldb/f?p=4550:11:9210216941642359126::NO:::");
	  LoginFactory LF=new LoginFactory(driver);
	  HomePageFactory HF=new HomePageFactory(driver);
	  LF.LoginProcess("system", "Newuser123");
	  HF.LogOut();
  }
  @Test(enabled=true)
  public void LinksFactory() {
	  driver.get("http://newtours.demoaut.com/");
	  AllLinkFactory AF=new AllLinkFactory(driver);
	  AF.clickLinks();
  }
}
