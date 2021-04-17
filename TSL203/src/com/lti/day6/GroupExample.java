package com.lti.day6;

import org.testng.annotations.Test;

public class GroupExample {
  @Test(priority=3,groups= {"smoke","regression"})
  public void f() {
	  System.out.println("In smoke and regression");
  }
  @Test(priority=1,groups= {"smoke"})
  public void f1() {
	  System.out.println("In smoke");
  }
  @Test(priority=2,groups= {"regression"})
  public void f2() {
	  System.out.println("In regression");
  }
  @Test(priority=3,groups= {"security"})
  public void f3() {
	  System.out.println("In Security");
  }
}
