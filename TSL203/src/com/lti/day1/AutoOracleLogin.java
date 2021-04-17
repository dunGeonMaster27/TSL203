package com.lti.day1;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutoOracleLogin {
public static void main(String[] args) {
	System.setProperty("webdriver.gecko.driver",".\\Drivers\\geckodriver.exe");
	WebDriver driver= new FirefoxDriver();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter user name:");
	String username=sc.nextLine();
	System.out.println("Enter password:");
	String password=sc.nextLine();
	driver.get("http://127.0.0.1:8080/htmldb/");
	System.out.println("You are on "+driver.getTitle()+" Page");
	driver.findElement(By.name("p_t01")).sendKeys(username);
	driver.findElement(By.name("p_t02")).sendKeys(password);
	//driver.findElement(By.cssSelector("input[type='text']")).click();
	//driver.findElement(By.cssSelector("input[type='password']")).click();
	//driver.findElement(By.cssSelector("input[value='Login']")).click();
	driver.findElement(By.xpath("/html/body/form/div[6]/table/tbody/tr/td[3]/table[2]/tbody/tr/td/input[1]")).click();
	if(driver.getTitle().equals("Oracle")) {
	driver.findElement(By.linkText("Logout")).click();
	System.out.println("Login done");
	}
	else
		System.out.println("Login not done");
	sc.close();
}
}