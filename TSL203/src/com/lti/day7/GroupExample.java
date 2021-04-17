package com.lti.day7;

import org.testng.annotations.Test;

public class GroupExample {
  @Test(priority=1,groups= {"smoke","regression"})
  public void f1() {
		System.out.println("Smoke and Regression");	  
  }
  
   
  @Test(priority=2,groups= {"smoke"})
  public void f2() {
		System.out.println("Smoke ");
  }
  
  
  @Test(priority=3,groups= {"regression"})
  public void f3() {
		System.out.println("Regression");	  
  }
  
  @Test(priority=3,groups= {"security"})
  public void f4() 
  {
	System.out.println("Security");  
  }
  
  
}
