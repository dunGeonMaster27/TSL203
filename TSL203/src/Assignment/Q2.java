package Assignment;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Q2 {
	WebDriver driver;
  @Test
  public void f() throws Exception {
	  
	  driver.manage().window().maximize();
	  driver.get("https://www.nseindia.com/");
	  TakesScreenshot T = (TakesScreenshot)driver;
	  JavascriptExecutor executor = (JavascriptExecutor) driver;
	  
	  System.out.println("USDINR 1 $ Rupee " + driver.findElement(By.id("us")).getText());
	  System.out.println("EURINR 1 € Rupee " + driver.findElement(By.id("uk")).getText());
	  System.out.println("GBPINR 1 ₤ Rupee " + driver.findElement(By.id("euro")).getText());
	  System.out.println("JPYINR 100 ¥ Rupee " + driver.findElement(By.id("japan")).getText());
	  
		 Thread.sleep(3000);
		 executor.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.id("us")));
		 executor.executeScript("window.scrollBy(0,-150)");
		 
	  File src = T.getScreenshotAs(OutputType.FILE);
	  FileHandler.copy(src, new File(".\\Currency Rates.png"));
	  Thread.sleep(3000);
	  String a=driver.findElement(By.id("us")).getText();
	  double a1=Double.parseDouble(a);
	  String b=driver.findElement(By.id("uk")).getText();
	  double b1=Double.parseDouble(b);
	  String c=driver.findElement(By.id("euro")).getText();
	  double c1=Double.parseDouble(c);
	  String d=driver.findElement(By.id("japan")).getText();
	  double d1=Double.parseDouble(d);
	  double max1 = Math.max(a1, b1);
	  double max2 = Math.max(c1, d1);
	  double max = Math.max(max1, max2);
	  if(max==a1)
		  System.out.print("USD ");
	  else if(max==b1)
		  System.out.print("EUR ");
	  else if(max==c1)
		  System.out.print("GBP ");
	  else if(max==b1)
		  System.out.print("JPY ");
	  System.out.println("Currency having Maximum Indian Rate  " + max);
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();  
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
	  
  }
  
  
}
