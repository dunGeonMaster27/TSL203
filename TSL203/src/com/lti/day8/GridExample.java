package com.lti.day8;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
//import com.gargoylesoftware.htmlunit.javascript.host.URL;
import com.lti.day7.LoginFactory;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class GridExample{
WebDriver driver;
  @BeforeTest
  @Parameters({"node","browser"})
  public void beforeTest(String node,String browser) throws Exception  {
	DesiredCapabilities dc=null;
	
	if(browser.equalsIgnoreCase("chrome"))
{
		dc=DesiredCapabilities.chrome();
		dc.setPlatform(Platform.WINDOWS);
		dc.setBrowserName("chrome");
	}else if(browser.equalsIgnoreCase("firefox"))
{
		dc=DesiredCapabilities.firefox();
		dc.setPlatform(Platform.WINDOWS);
		dc.setBrowserName("firefox");
}
  driver=new RemoteWebDriver(new URL(node),dc);
}
@AfterTest
public void afterTest() {
	  driver.quit();
}


@Test
public void Execute() throws Exception {
	  LoginFactory LF=new LoginFactory(driver);
	  driver.get("http://127.0.0.1:8080/htmldb");
	  LF.LoginProcess("system","Newuser123");
	  
}
}