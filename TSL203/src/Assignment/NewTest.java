package Assignment;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
	WebDriver driver;
  @Test
  public void f() throws Exception {
	  driver.manage().window().maximize();
	  driver.get("https://www.nseindia.com/");
	  XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream("C:\\Users\\vshadmin\\Desktop\\data1.xlsx"));
	  XSSFSheet s=wb.getSheet("Sheet1");
	  TakesScreenshot T = (TakesScreenshot)driver;
	  for(int i=0;i<=s.getLastRowNum();i++) {
		  
		  String Comp=  s.getRow(i).getCell(0).toString();
	  driver.findElement(By.xpath("//input[@id='keyword']")).sendKeys(Comp);
	  driver.findElement(By.xpath("//*[contains(text(),'"+Comp+"')]")).click();
	  System.out.println("Face Value is  " + driver.findElement(By.xpath("//span[@id='faceValue']")).getText());
	  File src = T.getScreenshotAs(OutputType.FILE);
	  FileHandler.copy(src,new File(".\\"+Comp+".png"));
	wb.close();
	  }
	  }
	  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();  
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
	  
  }
}
