package com.lti.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertExample {

	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.magneticautomation.in/2019/01/alert-example.html");
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"post-body-5405753133268992336\"]/div/button[1]")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//*[@id=\"post-body-5405753133268992336\"]/div/button[2]")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		System.out.println(driver.findElement(By.id("demo")).getText());
		
		driver.findElement(By.xpath("//*[@id=\"post-body-5405753133268992336\"]/div/button[2]")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		System.out.println(driver.findElement(By.id("demo")).getText());
		
		driver.findElement(By.xpath("//*[@id=\"post-body-5405753133268992336\"]/div/button[3]")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().sendKeys("LTI");
		driver.switchTo().alert().accept();
		System.out.println(driver.findElement(By.id("demo2")).getText());
		
		driver.findElement(By.xpath("//*[@id=\"post-body-5405753133268992336\"]/div/button[3]")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().sendKeys("LTI");
		driver.switchTo().alert().dismiss();
		System.out.println(driver.findElement(By.id("demo2")).getText());
		
		/*
		 * driver.get("http://192.168.100.121:9090/frameExample.html");
		 * driver.findElement(By.linkText("AlertExample")).click();
		 * 
		 * driver.findElement(By.cssSelector("button[onclick='myFunction()']")).click();
		 * 
		 * // Alert A = driver.switchTo().alert().getText().sendKeys("LTI").accept();
		 * 
		 * Alert A = driver.switchTo().alert();
		 * 
		 * String txt = A.getText();
		 * 
		 * System.out.println(txt); A.sendKeys("LTI"); // A.accept(); A.dismiss();
		 */
		
	}
}
