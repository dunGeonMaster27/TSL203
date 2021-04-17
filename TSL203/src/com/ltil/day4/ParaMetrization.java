package com.ltil.day4;

import org.testng.annotations.Test;

import com.ltil.day4.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class ParaMetrization extends base {
	
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
  public Object[][] dp() {
   
    	Object data[][]=new Object[4][2];
    	data[0][0]="system";
    	data[0][1]="Newuser123";
    	data[1][0]="sys1";
    	data[1][1]="Newuser123";
    	
    	data[2][0]="hr";
    	data[2][1]="hr";
    	data[3][0]="demo";
    	data[3][1]="demo";
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
