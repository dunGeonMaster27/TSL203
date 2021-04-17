package Assignment;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.Base;

public class q3 extends Base{
	  @BeforeTest
	  public void beforeTest() {
		  System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver(new ChromeOptions().addArguments("--disable-notifications"));  
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		 }
	  @AfterTest
	  public void afterTest() {
		  //driver.quit();
		  }
	  	
  @Test
  public void f() throws Exception{
		FileInputStream IP = new  FileInputStream("C:\\Users\\vshadmin\\Desktop\\firstcry.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(IP);
		XSSFSheet a = wb.getSheet("Sheet1");
	  driver.navigate().to("https://www.firstcry.com/");
	  driver.navigate().refresh();
	  for(int e=0;e<3;e++) {
		  driver.findElement(By.id("search_box")).clear();

	  driver.findElement(By.id("search_box")).sendKeys(a.getRow(e).getCell(0).toString());
	  driver.findElement(By.className("search-button")).click();
	  driver.findElement(By.linkText("Price")).click();
	  driver.findElement(By.linkText("Price: Low To High")).click();
	  Thread.sleep(2000);
	  List<WebElement> price = driver.findElements(By.xpath("//span[@class='r1']"));
	  
	  
	  List<String> strings = new ArrayList<String>();
	  for(WebElement e1 : price){
	      strings.add(e1.getText());
	  }
	  System.out.println(strings);
	  String sd[] = new String[8];
	  Double ma[] = new Double[8];
	    for(int h=0;h<8;h++) {
	    	sd[h]= strings.get(h).substring(3);
	  System.out.println(sd[h]);
	   ma[h] = Double.parseDouble(sd[h]);
	    }
	  
	    if(ma[0]>=ma[1])
	    {
		    if(ma[1]>=ma[2])
		    {
			    if(ma[2]>=ma[3])
			    {
				    if(ma[3]>=ma[4])
				    {
				    	if(ma[4]>=ma[5])
					    {
						    if(ma[5]>=ma[6])
						    {
							    if(ma[6]>=ma[7])
							    {
		    				    	System.out.println("Good");
							    }

						    }

					    }
				    }

			    }

		    }

	    }
		 driver.findElement(By.xpath("//div[@class='fc_logo']//img")).click();

	    
  }
  }
  
  
}
