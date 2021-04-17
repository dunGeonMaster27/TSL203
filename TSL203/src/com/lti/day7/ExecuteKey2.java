package com.lti.day7;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.Base;
import utils.Excel;
import utils.KeyWords;

public class ExecuteKey2 extends Base{
  @Test(dataProvider = "dp")
  public void f(String ExcelKey, String Locator,String Data) {
	  
	  KeyWords KEY = new KeyWords(driver);
	  switch(ExcelKey) {
	  case "openUrl":
		  KEY.openUrl(Data);
		  break;
	  case "type":
		  KEY.type(Locator, Data);
		  break;
	  case "click":
		  KEY.click(Locator);
		  break;
	  case "captureScreen":
		  KEY.captureScreen(Data);
		  break;
		  default:
			  System.out.println("Invalid Key");
	  }
  }

  @DataProvider
  public Object[][] dp() {
	  
	  Excel ex = new Excel("C:\\Users\\vshadmin\\Desktop\\Book1.xls");
	  
	  
   Object data[][] = new Object[ex.getRowNum("Sheet1")+1][3];
   
   for(int i=0;i<=ex.getRowNum("Sheet1");i++) {
   data[i][0] = ex.getData("Sheet1", i, 0);
   data[i][1] = ex.getData("Sheet1", i, 1);
   data[i][2] = ex.getData("Sheet1", i, 2);
   }
   return data;
}
}