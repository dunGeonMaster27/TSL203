package com.lti.day2;

import java.io.File;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class SoloLearn {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		TakesScreenshot screen = (TakesScreenshot)driver;
		
		driver.get("https://www.sololearn.com/");
				
		WebElement discuss = driver.findElement(By.linkText("DISCUSS"));
		
		String PID = driver.getWindowHandle();
		
		Actions A = new Actions(driver);
		
		A.moveToElement(discuss).keyDown(Keys.LEFT_CONTROL).click().perform();
		
		Set<String>  CID = driver.getWindowHandles();
		Iterator<String> it = CID.iterator();
		while(it.hasNext())
		{
			String ID = it.next();
			if(!(ID.equals(PID)))
			{
				driver.switchTo().window(ID);
				System.out.println("You are in " + driver.getTitle() + " Page");
		
				File SRC = screen.getScreenshotAs(OutputType.FILE);
				FileHandler.copy(SRC, new File(".\\Child.png"));
				//driver.close();
			}
		}
		//driver.switchTo().frame(arg0)
		//Index - Integer
		//String - ID,Name
		//WebElement 				
	}
}
