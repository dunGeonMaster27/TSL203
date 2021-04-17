package com.lti.day7;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.lti.day6.base;

public class ExecutePOM extends base {
  @Test
  public void f() {
	  driver.get("http://127.0.0.1:8080/htmldb/f?p=4550:11:9210216941642359126::NO:::");
	  LoginPOM LP=new LoginPOM(driver);
	  HomePOM HP=new HomePOM(driver);
	  LP.LoginProcess("sys","Newuser123");
	  
	  Set<Cookie> CK= driver.manage().getCookies();
	  for(Cookie C:CK)
	  {
		  System.out.println("Name of cookie is"+C.getName());
		  System.out.println("Domain of cookie is"+C.getDomain());
		  System.out.println("Path of cookie is"+C.getPath());
		  System.out.println("Expiry of cookie is"+C.getExpiry());
		  System.out.println("Value of cookie is"+C.getValue());
	  }
	  driver.manage().deleteAllCookies();
	  driver.navigate().refresh();
	  Assert.assertEquals(driver.getTitle(),"HTML DB Login");
	// HP.Logout();
	  
	  
	  
  }
}
