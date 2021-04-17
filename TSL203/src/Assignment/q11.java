package Assignment;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.Base;

public class q11 extends Base {
	
	 @BeforeTest
	  public void beforeTest() {
		  System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver(new ChromeOptions().addArguments("--disable-notifications"));  
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		  }

	  @AfterTest
	  public void afterTest() {
		  //driver.quit();
		  
	  }

  @Test
  public void f() throws Exception{
	  driver.get("https://www.pepperfry.com/");
		FileInputStream IP = new  FileInputStream("C:\\Users\\Saket\\Desktop\\data.xls");
		 HSSFWorkbook wb= new HSSFWorkbook(IP);
		 for(int i=0;i< wb.getSheet("Sheet1").getLastRowNum();i++)
		 {
		 String s = wb.getSheet("Sheet1").getRow(i).getCell(0).toString();
	  driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys(s); 
	  driver.findElement(By.xpath("//*[@id=\"searchButton\"]")).click();
	  driver.findElement(By.xpath("//*[@id=\"curSortType\"]")).click();
	  driver.findElement(By.xpath("//*[@id=\"sortBY\"]/li[2]/a")).click();
	  
	  driver.findElement(By.xpath("//*[@id=\"signinupPopupBox\"]/a")).click();
	  String a1= driver.findElement(By.xpath("//*[@id=\"p_1_1_1597378\"]/div/div[5]/div/span[1]")).getText().substring(3);
	  String a2= driver.findElement(By.xpath("//*[@id=\"p_2_1_1597380\"]/div/div[5]/div/span[1]")).getText().substring(3);
	  String a3= driver.findElement(By.xpath("//*[@id=\"p_7_1_1774473\"]/div/div[5]/div/span[1]")).getText().substring(3);
	  String a4= driver.findElement(By.xpath("//*[@id=\"p_4_1_1407650\"]/div/div[5]/div/span[1]")).getText().substring(3);
	  String a5= driver.findElement(By.xpath("//*[@id=\"p_5_1_1597438\"]/div/div[5]/div/span[1]")).getText().substring(3);
	  
	  double d1 = Double.parseDouble(a1);
	  double d2 = Double.parseDouble(a2);
	  double d3 = Double.parseDouble(a3);
	  double d4 = Double.parseDouble(a4);
	  double d5 = Double.parseDouble(a5);
System.out.println(d1);
System.out.println(d2);
System.out.println(d3);
System.out.println(d4);
System.out.println(d5);
if(d1<=d2)
{
	if(d2<=d3)
	{
		if(d3<=d4)
		{
			if(d4<=d5)
			{
				System.out.println("good");
			}
		}
	}
}
driver.get("https://www.pepperfry.com/");


  }
  }
}
