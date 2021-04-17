package com.lti.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DurontoMouseMovement {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://indiarailinfo.com/");
		
		Actions A = new Actions(driver);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wt = new WebDriverWait(driver,30);
		WebElement Trains = driver.findElement(By.linkText("Trains"));
		
		A.moveToElement(Trains).perform();
	//	Thread.sleep(1000);
		
		WebElement Shatabdi = driver.findElement(By.xpath("//*[@id=\"MainBody\"]/div[2]/div[3]/div/table/tbody/tr[8]/td[2]"));
		
		wt.until(ExpectedConditions.visibilityOf(Shatabdi));
		
		
		A.moveToElement(Shatabdi).click(Shatabdi).perform();
		wt.until(ExpectedConditions.visibilityOf(Shatabdi));
		
		
		WebElement search = driver.findElement(By.name("q"));
		
		Action d = A.moveToElement(search).keyDown(search,Keys.LEFT_SHIFT).sendKeys(search,"lti")
		.doubleClick(search).contextClick(search).build();
	
		d.perform();	
	}
	
	
}
