package Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.Base;

public class NewTest1 extends Base{
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
  public void f() {
	  driver.get("https://www.google.com/maps/place/Porayar,+Tamil+Nadu/@11.0186908,79.8264808,15z/data=!3m1!4b1!4m5!3m4!1s0x3a551a2724cb9af5:0x41de14979bcaca3e!8m2!3d11.021447!4d79.8324755");
   System.out.println(driver.findElement(By.xpath("//h1[@class='GLOBAL__gm2-headline-5 section-hero-header-title-title']")).getText());
  }
}
