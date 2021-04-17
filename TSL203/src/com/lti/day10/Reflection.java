package com.lti.day10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.testng.annotations.Test;

public class Reflection{
  @Test
  public void f() throws Exception{
	  Class C = Class.forName("org.openqa.selenium.firefox.FirefoxDriver");
	  Field[] FL= C.getDeclaredFields();
	  System.out.println("Total Fields are " + FL.length);
	  for(Field F:FL)
	  {
		  System.out.println(F.getName());
	  }
  System.out.println(C.getSuperclass().getName());
 
  
  Method[] MT = C.getDeclaredMethods();
  System.out.println("Total Methods are " + MT.length);
  for(Method M:MT)
  {
	  System.out.println(M.getName());
  }
  }
}
