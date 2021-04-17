package com.lti.day8;

import org.testng.annotations.Test;

import utils.Base;
import utils.KeyWords;

public class Execute2 extends Base{
  @Test(enabled =false)
  public void f() {
	  LoginFactory Login = new LoginFactory(driver);
	  HomePageFactory Logout = new HomePageFactory(driver);
	  KeyWords key = new KeyWords(driver);
	  
	  key.openUrl("http://127.0.0.1:8080/htmldb");
	  Login.LoginProcess("hr", "hr");
	  Logout.Logout();
	  
	  
  }
  @Test(enabled =true)
  public void f1() {
	  AllLinksFactory LinkTest = new AllLinksFactory(driver);
	
	  KeyWords key = new KeyWords(driver);
	  
	  key.openUrl("http://newtours.demoaut.com/");
	  LinkTest.clickLinks();
  }
}
