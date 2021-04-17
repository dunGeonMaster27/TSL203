package com.ltil.day4;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;

public class NewTest3 {
	WebDriver driver;

	@Test
  public void f() throws Exception {
		XSSFWorkbook wb=new XSSFWorkbook(new FileInputStream("C:\\Users\\vshadmin\\Desktop\\data3.xlsx"));
		XSSFSheet s=wb.getSheet("Sheet2");
		TakesScreenshot T=(TakesScreenshot)driver;
		driver.get("http://nseindia.com/");
		
		for(int i=0;i<=s.getLastRowNum();i++){
			String Comp= s.getRow(i).getCell(0).toString();
			driver.findElement(By.xpath("//input[@id='keyword']")).sendKeys(Comp);
			driver.findElement(By.xpath("//*[contains(text(),'"+Comp+"')]")).click();
			System.out.println("Fac e value is"+driver.findElement(By.id("faceValue")).getText());
			File src=T.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src,new File(".//"+Comp+".png"));
		}
  }

	@BeforeClass
  public void beforeClass() {
		System.setProperty("webdriver.gecko.driver",".\\Drivers\\geckodriver.exe");
		 driver=new FirefoxDriver();
		 driver.get("https://nseindia.com/");
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }

	@AfterClass
	public void afterClass() {
		  driver.quit();
	}

}
