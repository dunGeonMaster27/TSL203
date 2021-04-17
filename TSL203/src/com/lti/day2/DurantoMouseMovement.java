package com.lti.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DurantoMouseMovement {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();  // Opens Browser
	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebDriverWait wt=new WebDriverWait(driver, 30);
		driver.get("https://indiarailinfo.com/");
		driver.manage().window().maximize();
		
		Actions A=new Actions(driver);  // For Controlling Mouse & Keyboard
		
		WebElement Trains=driver.findElement(By.linkText("Trains"));
		
		A.moveToElement(Trains).perform();
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div[3]/div/table/tbody/tr[8]/td[2]")));
		
		
		WebElement Shatadti =driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div/table/tbody/tr[8]/td[2]"));

		
		A.moveToElement(Shatadti).click(Shatadti).perform();
		
		
		wt.until(ExpectedConditions.invisibilityOf(Shatadti));

		WebElement search=driver.findElement(By.xpath("//input[@placeholder='enter any words, phrases']"));
		
		Action d= A.moveToElement(search).keyDown(search,Keys.SHIFT).sendKeys(search,"lti").doubleClick(search).build();
		d.perform();
		
		
		A.moveToElement(driver.findElement(By.id("SrhTrnListDiv"))).click().perform();
	
		A.moveToElement(driver.findElement(By.name("qq"))).contextClick().perform();
		
		
	}

}
