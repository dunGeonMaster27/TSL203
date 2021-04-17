package utils;

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
		Date d = new Date();
		String newDate = d.toString().replaceAll(" ", "_").replaceAll(":","-");
		TakesScreenshot T = (TakesScreenshot)driver;
		File src = T.getScreenshotAs(OutputType.FILE);
				
		try {
		FileHandler.copy(src, new File(".\\screenshot\\"+FileName+newDate+".png"));
		}catch(IOException e) {
			System.out.println("Error with taking Screenshot");
		}
	}
	
	public void click(String Locator)
	{
		//id:=P11_USERNAME
		String LocatorType = Locator.split(":=")[0];
		String LocatorValue = Locator.split(":=")[1];
	
		switch(LocatorType)
		{
		case "id" :
		driver.findElement(By.id(LocatorValue)).click();
		break;
	case "name" :
		driver.findElement(By.name(LocatorValue)).click();
		break;
	case "xpath" :
		driver.findElement(By.xpath(LocatorValue)).click();
		break;
	case "linkText":
		driver.findElement(By.linkText(LocatorValue)).click();
		}
	
	}
	public void type(String Locator, String data)
	{
		
		String LocatorType = Locator.split(":=")[0];
		String LocatorValue = Locator.split(":=")[1];
	
		switch(LocatorType)
		{
		case "id" :
		driver.findElement(By.id(LocatorValue)).sendKeys(data);
		
		break;
	case "name" :
		driver.findElement(By.name(LocatorValue)).sendKeys(data);
		break;
	case "xpath" :
		driver.findElement(By.xpath(LocatorValue)).sendKeys(data);
		break;
	case "linkText":
		driver.findElement(By.linkText(LocatorValue)).sendKeys(data);
		}
	
	}
	
	public void openUrl(String url)
	{
		driver.get(url);
	}
	
	
}
