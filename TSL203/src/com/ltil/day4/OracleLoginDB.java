package com.ltil.day4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OracleLoginDB {
	public static void main(String[] args) throws Exception {
	System.setProperty("webdriver.gecko.driver","D:\\1SEL\\geckodriver-v0.23.0-win64\\geckodriver.exe");
	WebDriver driver= new FirefoxDriver();
	Connection conn = ConnectionManager.getConnection();
	  Statement stmt = conn.createStatement();
	  String sql = "SELECT username,password from login";
	  ResultSet rs = stmt.executeQuery(sql);
	 while(rs.next()){
         //Retrieve by column name
         String username = rs.getString("username");
         String password = rs.getString("password");
         driver.get("http://127.0.0.1:8080/htmldb/");
	     System.out.println("You are on "+driver.getTitle()+" Page");
	     driver.findElement(By.name("p_t01")).sendKeys(username);
	     driver.findElement(By.name("p_t02")).sendKeys(password);
	     driver.findElement(By.xpath("/html/body/form/div[6]/table/tbody/tr/td[3]/table[2]/tbody/tr/td/input[1]")).click();
	     if(driver.getTitle().equals("Oracle")) {
	    	 driver.findElement(By.linkText("Logout")).click();
	
	System.out.println("Login done");
	
	}
	else {
		System.out.println("Login failed");
		
	}

	
     }
     rs.close();
}
}
