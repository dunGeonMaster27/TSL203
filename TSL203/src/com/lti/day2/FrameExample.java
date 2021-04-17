package com.lti.day2;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class FrameExample {

	public static void main(String[] args) throws Exception{
		
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	//	TakesScreenshot screen = (TakesScreenshot)driver;
		//driver.get("http://192.168.100.121:9090/frameExample.html");
		driver.get("https://demoqa.com/iframe-practice-page/");
		
		driver.switchTo().frame("IF1");
		driver.findElement(By.xpath("//*[@id=\"primary-menu\"]/li[2]/ul/li[3]/ul/li/a/span/span")).click();
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("IF2");
		driver.findElement(By.linkText("Sortable")).click();
		
		TakesScreenshot screen = (TakesScreenshot)driver;
		File SRC = screen.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(SRC, new File(".\\frame.png"));
		/*
		 * driver.switchTo().frame("selenium");
		 * 
		 * driver.findElement(By.linkText("Download")).click();
		 * 
		 * driver.switchTo().defaultContent();
		 * 
		 * //driver.switchTo().frame(2);
		 * driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe[3]")))
		 * ;
		 * 
		 * driver.findElement(By.linkText("Start Learning Now")).click();
		 */
		
	}
	
}
