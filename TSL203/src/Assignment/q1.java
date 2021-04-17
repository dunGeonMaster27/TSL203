package Assignment;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import utils.Base;

public class q1 extends Base {

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
	public void test() throws Exception {
		driver.get("https://www.shoppersstop.com/");
		new Actions(driver).moveToElement(driver.findElement(By.linkText("BRANDS"))).click().perform();
		// new WebDriverWait(driver,
		// 20).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/main/section/div/div/div/ul/li[1]/div/div[2]"))));
		Thread.sleep(3000);
		new Actions(driver)
				.moveToElement(driver.findElement(By.xpath("/html/body/main/section/div/div/div/ul/li[1]/div/div[2]")))
				.click(driver.findElement(By.xpath("/html/body/main/section/div/div/div/ul/li[1]/div/div[2]/a/span")))
				.perform();
		  
		  TakesScreenshot T = (TakesScreenshot)driver; 
		  File Src =T.getScreenshotAs(OutputType.FILE); 
		  FileHandler.copy(Src, new File(".\\screenshot\\hautecurry.png"));
		  
		  assertEquals(driver.getTitle(), "Haute Curry Bags | Haute Curry Ladies Footwear | Shoppers Stop | Shoppers Stop");
		 System.out.println("Title is correct");
		 //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("/html/body/main/footer/div[1]/p")));
		 String s = driver.findElement(By.xpath("/html/body/main/section[3]/div/div/div/div[3]/div[2]/p")).getText();
		 System.out.println(s);
		 assertEquals(s, "Fresh,happy and joyful collection perfect for summer wear");
		 System.out.println("Start something new");
		 Thread.sleep(3000);
		 System.out.println(driver.findElement(By.xpath("/html/body/main/footer/div[3]/div[1]/div/div/div/div[2]/ul/li[3]/a")).getAttribute("href"));
		 
	}

}
