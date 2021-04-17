package com.lti.day1;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OraclTest {

	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		System.out.println("Enter UserName");
		String UN=s.next();
		System.out.println("Enter Password");
		String PWD=s.next();
		
	
		
		System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();  // 100 % assurance that only common function will be visible 
		//Parent p=new Child()   >> Starting  FirefoxBrowser
		
		driver.get("http://127.0.0.1:8080/htmldb");  // Opening URL
		driver.findElement(By.cssSelector("input[type='text']")).sendKeys(UN);
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(PWD);
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		
		if(driver.getTitle().equals("Oracle"))
		{
		driver.findElement(By.linkText("Logout")).click();
		System.out.println("Login Done");
		}
		else
		{
			System.out.println("Login Failed");
		}
		
		driver.quit();
		s.close();
	}
	

}
