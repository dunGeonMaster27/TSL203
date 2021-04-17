package com.lti.day8;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.Base;
import utils.KeyWords;


public class ExecutePOM extends Base{
  @Test
  public void f() {
	  
	  LoginPOM Login = new LoginPOM(driver);
	//  HomePOM Logout = new HomePOM(driver);
	  KeyWords key = new KeyWords(driver);
	  
	  key.openUrl("http://127.0.0.1:8080/htmldb");
	  Login.LoginProcess("hr", "hr");
	  //Logout.Logout();
	  
	  Set<Cookie> CK = driver.manage().getCookies();
	  
	  for(Cookie C: CK)
	  {
		  System.out.println("Name of Cookie is " + C.getName());
		  System.out.println("Domain of Cookie is " + C.getDomain());
		  System.out.println("Path of Cookie is " + C.getPath());
		  System.out.println("Expiry of Cookie is " + C.getExpiry());
		  System.out.println("Value of Cookie is " + C.getValue());
	  }
	  
	  driver.manage().deleteAllCookies();
	  driver.navigate().refresh();
	  
	  Assert.assertEquals(driver.getTitle(), "HTML DB Login" , "Wrong Page");
  }
}
