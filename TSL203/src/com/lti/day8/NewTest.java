package com.lti.day8;

import org.testng.annotations.Test;

import com.lti.day7.LoginFactory;

import org.testng.annotations.BeforeTest;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;

public class NewTest {
	WebDriver driver;
  @Test
  public void Execute() throws Exception {
	  LoginFactory LF=new LoginFactory(driver);
	  driver.get("http://127.0.0.1:8080/htmldb");
	  LF.LoginProcess("system","Newuser123");
	  
  }
  @BeforeTest
  public void beforeTest() throws Exception{
	  DesiredCapabilities dc=DesiredCapabilities.chrome();
	  dc.setPlatform(Platform.WINDOWS);
	  dc.setBrowserName("chrome");
	  driver=new RemoteWebDriver(new URL("http://192.168.100.24:31523/wd/hub"),dc);
	  
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
