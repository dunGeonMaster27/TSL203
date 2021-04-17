package com.ltil.demo;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class practice1 {
	public static void main(String[]args) throws Exception
	{
		System.setProperty("webdriver.gecko.driver","D:\\1SEL\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();//100% assurance that only common functions will be visible
	
		TakesScreenshot screen=(TakesScreenshot)driver;
		driver.get("https://agiletestingalliance.org/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/header/div/div/nav/ul/li[6]/a")).click();
		System.out.println(driver.findElements(By.tagName("area")).size());
		File src=screen.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File(".\\rrrr"));
		Actions 	A=new Actions(driver);
		WebElement CPMAT=driver.findElement(By.xpath("/html/body/section/div/div[2]/map/area[2]"));
		A.moveToElement(CPMAT).perform();
		File src1=screen.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src1, new File(".\\ss"));
		
		
	}
	

}
