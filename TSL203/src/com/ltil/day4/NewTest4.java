package com.ltil.day4;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;

public class NewTest4 {
 WebDriver driver;
  @Test
  public void test1() throws Exception {
	  driver.findElement(By.name("companyED")).sendKeys("Reliance industries");
		Actions a=new Actions(driver);//for controlling mouse and keyboard
		WebElement s=driver.findElement(By.xpath("//*[@id=\"ajax_response\"]/ol/li/a"));
	
	a.moveToElement(s).click(s).perform();
		
		 TakesScreenshot screen=(TakesScreenshot)driver;
		  File src1=screen.getScreenshotAs(OutputType.FILE);
		  FileHandler.copy(src1, new File(".\\Screenimage.png"));
		  Thread.sleep(5000);
  }
 @Test
  public void test2() {
	  	System.out.println(driver.findElement(By.xpath("//*[@id=\"face\"]")).getText());
			System.out.println(driver.findElement(By.xpath("//*[@id=\"fundamentals_tbl\"]/ul/li[8]")).getText());
			System.out.println(driver.findElement(By.xpath("//*[@id=\"fundamentals_tbl\"]/ul/li[9]")).getText());
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.gecko.driver",".\\Drivers\\geckodriver.exe");
		 driver=new FirefoxDriver();
		 driver.get("https://nseindia.com/");
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
