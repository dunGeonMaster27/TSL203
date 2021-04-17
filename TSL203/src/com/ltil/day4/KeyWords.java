package com.ltil.day4;


import java.io.File;
import java.io.IOException;
import java.util.Date;

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
}
