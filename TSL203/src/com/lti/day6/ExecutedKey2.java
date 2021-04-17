package com.lti.day6;

import org.testng.annotations.Test;

import com.ltil.day5.KeyWords;



import org.testng.annotations.DataProvider;

public class ExecutedKey2 extends base{
  @Test(dataProvider = "dp")
  public void f(String ExcelKey,String Locator,String Data) {
 KeyWords KEY=new KeyWords(driver);
  switch(ExcelKey)
  {
  case"openUrl":
  KEY.openUrl(Data);
  break;
  case"type":
  KEY.type(Locator, Data);
  break;
  case"click":
  KEY.captureScreen(Data);
  break;
  default:
  System.out.println("Invalid Key");
  }
  }

  @DataProvider
  public Object[][] dp() {
  Excel ex=new Excel("C:\\Users\\vshadmin\\Desktop\\Book1.xls");
  System.out.println(ex.getRowNum("Sheet1"));
  Object data[][]=new Object[ex.getRowNum("Sheet1")+1][3];
  for(int i=0;i<=ex.getRowNum("Sheet1");i++)
  {
  data[i][0]=ex.getData("Sheet1", i, 0);
  data[i][1]=ex.getData("Sheet1", i, 1);
  data[i][2]=ex.getData("Sheet1", i, 2);
 
  }
  return data;

  }
}