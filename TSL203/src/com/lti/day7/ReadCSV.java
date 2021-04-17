package com.lti.day7;

import java.io.FileReader;
import java.util.List;

import org.testng.annotations.Test;

import com.lti.day6.base;

import au.com.bytecode.opencsv.CSVReader;

public class ReadCSV extends base{
  @Test
  public void f() throws Exception {
	  CSVReader CS=new CSVReader(new FileReader(".\\data4.csv"));
	  List <String[]> data=CS.readAll();
	  for(String[] dataArr:data)
	  {
		  for(String A:dataArr) {
		  System.out.println(A);
		  }
	  driver.get("http://127.0.0.1:8080/htmldb");
	  LoginFactory LF=new LoginFactory(driver);
	  HomePageFactory HF=new HomePageFactory(driver);
	  HomePageFactory1 HF1=new HomePageFactory1(driver);
	  LF.LoginProcess(dataArr[0], dataArr[1]);
	  //HF.LogOut();
	  if(driver.getTitle().equals("Oracle"))
	  {
	  HF.LogOut();
	  System.out.println("Login Done");
	  HF1.LogIn();
	  }
	  else
	  {
	  System.out.println("Invalid Credentials");
	  }
	 
  }CS.close();
  }
}
