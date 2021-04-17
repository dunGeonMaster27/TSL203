package com.ltil.day5;


import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class KeyWords {
WebDriver driver;
public KeyWords(WebDriver driver)
{
	this.driver=driver;
}
public void captureScreen(String FileName)
{
	Date d=new Date();
	String newDate=d.toString().replaceAll(" ", "_").replaceAll(":", "_");
	TakesScreenshot T=(TakesScreenshot)driver;
	File src=T.getScreenshotAs(OutputType.FILE);

	try {
		FileHandler.copy(src, new File(".\\screen\\"+FileName+newDate+".png"));
	}
	catch(IOException e) {
		System.out.println("error with taking screenshot");
	}
	}
public void click(String Locator) {
	String LocatorType=Locator.split(":=")[0];
	String LocatorValue=Locator.split(":=")[1];
	
	switch(LocatorType) {
	case"id":
		driver.findElement(By.id(LocatorValue)).click();
		break;
		
	case"name":
		driver.findElement(By.name(LocatorValue)).click();
		break;
		
	case"xpath":
		driver.findElement(By.xpath(LocatorValue)).click();
		break;
	}
	}
public void type(String Locator,String data) {
	String LocatorType=Locator.split(":=")[0];
	String LocatorValue=Locator.split(":=")[1];
	switch(LocatorType) {
	case"id":
		driver.findElement(By.id(LocatorValue)).sendKeys(data);
		break;
		
	case"name":
		driver.findElement(By.name(LocatorValue)).sendKeys(data);
		break;
		
	case"xpath":
		driver.findElement(By.xpath(LocatorValue)).sendKeys(data);
		break;
	}
}public void openUrl(String URL) {
	driver.get(URL);
}
}
