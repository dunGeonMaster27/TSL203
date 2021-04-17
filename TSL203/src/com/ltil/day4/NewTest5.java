package com.ltil.day4;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;

public class NewTest5 {
	WebDriver driver;
  @Test
  public void f()throws Exception {
	  double max=0;
		TakesScreenshot T=(TakesScreenshot)driver;
		driver.get("http://nseindia.com/");
	
		List<WebElement> All=driver.findElements(By.cssSelector("div.currencyBox"));
		for(int i=0;i<All.size();i++)
		{
			System.out.println(All.get(i).getText());
		}
		
		 TakesScreenshot screen=(TakesScreenshot)driver;
		  File src1=screen.getScreenshotAs(OutputType.FILE);
		  FileHandler.copy(src1, new File(".\\Screenimage.png"));
		  Thread.sleep(5000);
		  
		  WebElement E1=driver.findElement(By.cssSelector("span[id='us']"));
		  double e1 =Double.parseDouble(E1.getText());
		  WebElement E2=driver.findElement(By.cssSelector("span[id='uk']"));
		  double e2 =Double.parseDouble(E2.getText());
		  WebElement E3=driver.findElement(By.cssSelector("span[id='euro']"));
		  double e3 =Double.parseDouble(E3.getText());
		  WebElement E4=driver.findElement(By.cssSelector("span[id='japan']"));
		  double e4 =Double.parseDouble(E4.getText());
		  if(max<e1) {
			  max=e1;
			  if(max<e2) {
				  max=e2;
				  if(max<e3) {
					  max=e3;
					  if(max<e4){
						  max=e4;
			  }
		  }
		  }
		  }
	  System.out.println("Maximum Indian Rate: "+max);
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
