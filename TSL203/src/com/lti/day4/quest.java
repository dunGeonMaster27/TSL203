package com.lti.day4;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class quest {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		TakesScreenshot screen = (TakesScreenshot)driver;
		driver.get("https://www.nseindia.com/");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.id("header-search-input")).sendKeys("Reliance industries");
		
		Actions A  = new Actions(driver);
		A.moveToElement(driver.findElement(By.xpath("/html/body/header/nav/div[1]/div[1]/div/div[1]/span/div/div/div[1]/p[1]/span[1]/strong"))).click().perform();
		
		File SRC = screen.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(SRC, new File(".\\Reliance1.png"));
		 
		String s= driver.findElement(By.xpath("/html/body/div[7]/div[1]/div/section/div/div/div/div/div[1]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[8]")).getText();
		System.out.println("Face Value " + s);
		
		String h= driver.findElement(By.xpath("//*[@id=\"js-rangeslider-3\"]/div[4]")).getText();
		System.out.println("Intraday high/low " + h);
		
		String l= driver.findElement(By.xpath("//*[@id=\"js-rangeslider-4\"]/div[4]")).getText();
		System.out.println("52 Week High/Low " + l);
		
	}

}
