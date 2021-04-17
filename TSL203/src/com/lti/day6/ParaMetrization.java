package com.lti.day6;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.Base;
import utils.Excel;
import utils.KeyWords;

public class ParaMetrization extends Base {
  @Test(dataProvider = "dp")
  public void f(String n, String s) {
	  
	  System.out.println(n + " " + s);
	  driver.get("http://127.0.0.1:8080/htmldb");
	 //Thread.sleep(300);
	  driver.findElement(By.xpath("//*[@type='text']")).sendKeys(n);
	  driver.findElement(By.xpath("//*[@type='password']")).sendKeys(s);
	  driver.findElement(By.xpath("//*[@type='BUTTON']")).click();
	  Assert.assertEquals(driver.getTitle(), "Oracle");
	  
	  driver.findElement(By.xpath("//*[text()='Logout']")).click();
  }

  @DataProvider
  public Object[][] dp() {
	  
	  Excel ex = new Excel(prop.getProperty("excelPath"));
	  
	  
   Object data[][] = new Object[ex.getRowNum("Sheet1")+1][2];
   
   for(int i=0;i<=ex.getRowNum("Sheet1");i++) {
   data[i][0] = ex.getData("Sheet1", i, 0);
   data[i][1] = ex.getData("Sheet1", i, 1);
   }

   
   
   return data;
  
  
  }
  

  @AfterMethod
  public void afterMethod(ITestResult IT) 
  {
	   KeyWords key = new KeyWords(driver);
	  if(IT.getStatus()== ITestResult.FAILURE)
	  {
		key.captureScreen(IT.getName());  
	  }
	  
	 
	  
	  
  }
}
