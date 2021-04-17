package com.lti.day3;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OracleLoginXL {
	public static void main(String[] args) throws Exception {
	System.setProperty("webdriver.gecko.driver","D:\\1SEL\\geckodriver-v0.23.0-win64\\geckodriver.exe");
	WebDriver driver= new FirefoxDriver();
	FileInputStream is=new FileInputStream("C:\\Users\\vshadmin\\Desktop\\data.xlsx");
    XSSFWorkbook wb=new XSSFWorkbook(is);
	XSSFSheet s=wb.getSheet("Sheet1");
	for(int i=0;i<=3;i++) {
	String username=s.getRow(i).getCell(0).toString();
	String password=s.getRow(i).getCell(1).toString();
	driver.get("http://127.0.0.1:8080/htmldb/");
	System.out.println("You are on "+driver.getTitle()+" Page");
	driver.findElement(By.name("p_t01")).sendKeys(username);
	driver.findElement(By.name("p_t02")).sendKeys(password);
	
	driver.findElement(By.xpath("/html/body/form/div[6]/table/tbody/tr/td[3]/table[2]/tbody/tr/td/input[1]")).click();
	if(driver.getTitle().equals("Oracle")) {
	driver.findElement(By.linkText("Logout")).click();
	
	System.out.println("Login done");
	s.getRow(i).createCell(2).setCellValue("DONE");
	}
	else {
		System.out.println("Login failed");
		s.getRow(i).createCell(2).setCellValue("FAILED");
	}
}
	wb.write(new FileOutputStream("C:\\Users\\vshadmin\\Desktop\\data.xlsx"));
	
	wb.close();
}
}
