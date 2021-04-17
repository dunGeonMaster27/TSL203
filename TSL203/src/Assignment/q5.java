package Assignment;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.Base;

public class q5 extends Base {
	
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
	  
  @Test
  public void f() throws Exception{
	  
	  driver.get("https://letterboxd.com/");
	  if(driver.findElement(By.xpath("//h1[@class='site-logo']")).getText().contains("Letterboxd"))
	  {
		  System.out.println("good");
	  }
	  else {
		  System.out.println("Bad");
	  }
	  driver.findElement(By.xpath("(//a[@class='navlink has-icon'])[4]")).click();
	  TakesScreenshot T = (TakesScreenshot)driver;
	  File SRC = T.getScreenshotAs(OutputType.FILE);
	  FileHandler.copy(SRC, new File(".\\screenshot\\letterboxd.png"));
	  
	  List<WebElement> E =driver.findElements(By.xpath("//h3[@class='title-3']"));
	  for(WebElement F:E) {
	  System.out.println(F.getText());
	  }
	  
	  System.out.println(driver.findElement(By.xpath("((//p[@class='stats'])[1]/a)[2]")).getText());
  }
}
