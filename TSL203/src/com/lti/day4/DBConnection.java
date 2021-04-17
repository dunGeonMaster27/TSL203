package com.lti.day4;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class DBConnection {


public static void main(String[] args) throws Exception{
	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		System.setProperty("webdriver.gecko.driver", "D:\\1SEL\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://127.0.0.1:8080/htmldb");

		Connection C=DriverManager.getConnection(url,"hr","hr");
		ResultSet R = C.createStatement().executeQuery("Select * from login");
		
		while (R.next())
		{
			String UN = R.getString(1);
			String PWD = R.getString(2);
		
		driver.findElement(By.name("p_t01")).clear();
		driver.findElement(By.name("p_t01")).sendKeys(UN);
		driver.findElement(By.name("p_t02")).clear();
		driver.findElement(By.name("p_t02")).sendKeys(PWD);
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		if(driver.getTitle().equals("Oracle"))
		{
		driver.findElement(By.linkText("Logout")).click();
		System.out.println("Login Successful");
		driver.findElement(By.linkText("Login")).click();
		
		}
		else
		{
			System.out.println("Login Failed");
			
		}
		}
}
}

