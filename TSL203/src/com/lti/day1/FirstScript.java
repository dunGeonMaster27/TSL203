package com.lti.day1;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstScript {

	public static void main(String[] args) {
		
	    System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();   //1200 % assurance that only common functions will be visible
		
		//System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver(); 
		
		driver.get("http://127.0.0.1:8080/htmldb");
		System.out.println("You are on " + driver.getTitle() + " Page");
		
		//driver.findElement(By.xpath("/html/body/div/div[3]/form/div[2]/div/div[1]/div/div[1]/input")).sendKeys("LTI");
		//driver.findElement(By.name("q")).sendKeys("LTI");
		//driver.findElement(By.name("q")).submit();
		
		//driver.findElement(By.name("btnK")).click();
		
		 //driver.quit();
		System.out.println("Enter username");
		Scanner s = new Scanner(System.in);
		
		
		driver.findElement(By.name("p_t01")).sendKeys(s.next());
		System.out.println("Enter password");
		String pass =  s.next();
		driver.findElement(By.name("p_t02")).sendKeys(pass);
		System.out.println("If you want to Login, Enter get");
		String get = s.next();
		System.out.println("If you really want to Login, Enter set");
		String set = s.next();
		System.out.println("If you really really want to Login, Enter go");
		String go = s.next();
		if(get.equals("get")) {
			if(set.equals("set")) {
				if(go.equals("go")) {
					driver.findElement(By.cssSelector("input[value='Login']")).click();
									}
								  }
							  }
		if(driver.getTitle().equals("Oracle"))
		{
		driver.findElement(By.linkText("Logout")).click();
		System.out.println("Login Successful");
		}
		else
			System.out.println("Login Failed");
		s.close();
	}
			
}
