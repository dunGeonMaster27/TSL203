package com.lti.day3;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ExcelRead {

	public static void main(String[] args) throws Exception{
		
	    System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://127.0.0.1:8080/htmldb");
		
		FileInputStream IP= new FileInputStream("C:\\Users\\vshadmin\\Desktop\\data.xlsx");
		XSSFWorkbook wb= new XSSFWorkbook(IP);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		for(int i=0;i<=sheet.getLastRowNum();i++)
		{
			String data = sheet.getRow(i).getCell(0).toString();
			driver.findElement(By.name("p_t01")).sendKeys(data);
			System.out.print(data+" ");
			
			String data1 = sheet.getRow(i).getCell(1).toString();
			driver.findElement(By.name("p_t02")).sendKeys(data1);
			System.out.print(data1+" ");
			
			driver.findElement(By.cssSelector("input[value='Login']")).click();
			if(driver.getTitle().equals("Oracle"))
			{
			driver.findElement(By.linkText("Logout")).click();
			System.out.println("Login Successful");
			driver.findElement(By.linkText("Login")).click();
			sheet.getRow(i).createCell(2).setCellValue("Login Successful");
			}
			else
			{
				System.out.println("Login Failed");
				sheet.getRow(i).createCell(2).setCellValue("Login Failed");
				
			}
			wb.write(new FileOutputStream("C:\\Users\\vshadmin\\Desktop\\data2.xlsx"));
		}
	
		wb.close();
	}
	
	
	
}
