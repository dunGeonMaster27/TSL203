package Assignment;


import static org.testng.Assert.assertTrue;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class q55 {
static WebDriver driver;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver(new ChromeOptions().addArguments("--disable-notifications"));
		driver.manage().window().maximize();
	}
	

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() throws Exception{
		driver.get("http://mu.ac.in/portal/");
		new Actions(driver).moveToElement(driver.findElement(By.xpath("//*[@id=\"menu-item-3694\"]"))).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"menu-item-3821\"]/a/span")).click();
		driver.findElement(By.xpath("//*[@id=\"post-3809\"]/div/div[1]/div[1]/div/div[1]/div/div[1]/div/ul/li[8]/h6/a")).click();
		System.out.println(driver.findElement(By.xpath("//strong[contains(text(),'The schedule for admission to the program of M.Sc.')]")).getText());
		driver.findElement(By.xpath("//*[@id=\"main-menu-links\"]/li[10]/a")).click();
		String add = driver.findElement(By.xpath("//*[@id=\"node-8\"]/div/div/div/div/p[4]/strong")).getText();
		System.out.println(add);
		assertTrue(add.contains("022-26500208"));
		System.out.println("Number is correct");
		assertTrue(add.contains("uditoffice@gmail.com"));
		System.out.println("Email is correct");
		TakesScreenshot T = (TakesScreenshot)driver;
		File SRC = T.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(SRC, new File(".\\screenshot\\mu.png"));
	}

}
