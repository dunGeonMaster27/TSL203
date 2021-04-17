package com.lti.JUnitExample;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Example3 {
	static WebDriver driver;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.gecko.driver",".\\Drivers\\geckodriver.exe");
		 driver=new FirefoxDriver();
		 driver.get("http://www.newtours.demoaut.com/");
		 assertEquals("Welcome: Mercury Tours", driver.getTitle());
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@Test
	public void test1() {
		driver.findElement(By.linkText("REGISTER")).click();
		assertEquals("Register: Mercury Tours", driver.getTitle());
	}
	@Test
	public void test2() {
		driver.findElement(By.linkText("SIGN-ON")).click();
		assertEquals("Sign-on: Mercury Tours", driver.getTitle());
	}

}
