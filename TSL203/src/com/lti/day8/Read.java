package com.lti.day8;

import java.io.FileReader;
import java.util.List;

import org.testng.annotations.Test;

import au.com.bytecode.opencsv.CSVReader;
import utils.Base;

public class Read extends Base {
  @Test
  public void f() throws Exception{
	  
	  CSVReader CS = new CSVReader(new FileReader(".\\data2.csv"));
	  
	  List<String[]> data = CS.readAll();
	  for(String[] dataArr:data)
	  {
		  for(String A: dataArr)
		  {
			  System.out.println(A);
		  }
		  driver.get("http://127.0.0.1:8080/htmldb");
		  LoginFactory LF = new LoginFactory(driver);
		  HomePageFactory HF = new HomePageFactory(driver);
		  LF.LoginProcess(dataArr[0], dataArr[1]);
		  if(driver.getTitle().equals("Oracle"))
			{
			  HF.Logout();
			System.out.println("Login Done");
			}
			else
			{
				System.out.println("Login Failed");
			}		  
	  }
	  CS.close();
  }
}
