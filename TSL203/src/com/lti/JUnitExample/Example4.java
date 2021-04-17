package com.lti.JUnitExample;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class Example4 {
static WebDriver driver;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.gecko.driver",".\\Drivers\\geckodriver.exe");
		 driver=new FirefoxDriver();
		 driver.get("https://nseindia.com/");
//		 assertEquals("NSE - National Stock Exchange of India Ltd.", driver.getTitle());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}


	@Test
	public void test1() throws Exception {
		
		driver.findElement(By.name("companyED")).sendKeys("Reliance industries");
		Actions a=new Actions(driver);//for controlling mouse and keyboard
		WebElement s=driver.findElement(By.xpath("//*[@id=\"ajax_response\"]/ol/li"));
		a.moveToElement(s).keyDown(s, Keys.ENTER).perform();
		
		 TakesScreenshot screen=(TakesScreenshot)driver;
		  File src1=screen.getScreenshotAs(OutputType.FILE);
		  FileHandler.copy(src1, new File(".\\Screenimage.png"));
		
	}

	@Test
	public void test2(){
			System.out.println(driver.findElement(By.xpath("//*[@id=\"face\"]")).toString());
			System.out.println(driver.findElement(By.xpath("//*[@id=\"fundamentals_tbl\"]/ul/li[8]")).toString());
			System.out.println(driver.findElement(By.xpath("//*[@id=\"fundamentals_tbl\"]/ul/li[9]")).toString());
	}
}
