package com.lti.day6;

import org.testng.annotations.Test;
import com.ltil.day4.base;
import com.ltil.day5.KeyWords;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class ParaMetrization1 extends base {
	Properties prop;
  @Test(dataProvider = "dp")
  public void f(String n, String s) {
  System.out.println(n+" "+s);
  driver.get("http://127.0.0.1:8080/htmldb");
  driver.findElement(By.xpath("//*[@type='text']")).sendKeys(n);
  driver.findElement(By.xpath("//*[@type='password']")).sendKeys(s);
  driver.findElement(By.xpath("//*[@type='BUTTON']")).click();
  Assert.assertEquals(driver.getTitle(),"Oracle");
  driver.findElement(By.xpath("//*[text()='Logout']")).click();
  }
   @DataProvider
  public Object[][] dp() throws Exception {
	   prop=new Properties();
	   prop.load(new FileInputStream(".\\configuration.property"));
	   Excel ex=new Excel("C:\\Users\\vshadmin\\Desktop\\data.xlsx");
	   System.out.println(ex.getRowNum("Sheet1"));
 
    	Object data[][]=new Object[ex.getRowNum("Sheet1")+1][2];
    	for(int i=0;i<=ex.getRowNum("Sheet1");i++) {
    	data[i][0]=ex.getData("Sheet1", i, 0);
    	data[i][1]=ex.getData("Sheet1", i, 1);
   }
    	return data;
    }
   @AfterMethod
  public void afterMethod(ITestResult IT) {
	  KeyWords key=new KeyWords(driver);
	  if(IT.getStatus()==ITestResult.FAILURE)
	  {
	  key.captureScreen(IT.getName());
  }

}}
