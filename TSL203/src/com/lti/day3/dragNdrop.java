package com.lti.day3;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class dragNdrop {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		Actions A = new Actions(driver);
		TakesScreenshot screen = (TakesScreenshot)driver;
		
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		
		WebElement src = driver.findElement(By.id("draggable"));
		WebElement dest = driver.findElement(By.id("droppable"));
		A.dragAndDrop(src, dest).perform();
				
		File SRC = screen.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(SRC, new File(".\\Chrome.png"));
	}
	
}
