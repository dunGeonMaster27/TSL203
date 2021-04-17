package com.lti.day9;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lti.day8.HomePageFactory;
import com.lti.day8.LoginFactory;

public class GridExample {
	WebDriver driver;
	
	@BeforeTest
	@Parameters({"node","browser"})
	public void beforeTest(String node, String browser) throws Exception{
		  DesiredCapabilities dc=null;
		if(browser.equalsIgnoreCase("chrome")) {
		dc = DesiredCapabilities.chrome();
		  dc.setPlatform(Platform.WINDOWS);
		  dc.setBrowserName("chrome");
		  ChromeOptions op = new ChromeOptions();
		  op.addArguments("--window-size=1920,1080");
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			dc = DesiredCapabilities.firefox();
			dc.setPlatform(Platform.WINDOWS);
			  dc.setBrowserName("firefox");
			  FirefoxOptions fp = new FirefoxOptions();
			  fp.addArguments("--window-size=1920,1080");
		}
		  
		 
		 driver = new RemoteWebDriver(new URL(node), dc);
		 	 
	}
	
	@AfterTest()
	public void AfterTest(){
		driver.quit();
	}
	
  @Test
  public void Execute() {
	    
	  LoginFactory LF = new LoginFactory(driver);
	  driver.get("http://127.0.0.1:8080/htmldb");
	  LF.LoginProcess("hr","hr");
	HomePageFactory HF = new HomePageFactory(driver);
	HF.Logout();
	  
  }
}
