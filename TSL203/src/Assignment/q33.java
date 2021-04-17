package Assignment;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import utils.Base;

public class q33 extends Base{
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver(new ChromeOptions().addArguments("--disable-notifications"));
		driver.manage().window().maximize();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//driver.quit();
	}

	@Test
	public void test() throws Exception{
		driver.get("https://www.google.com/maps/@19.1111168,73.0292224,14z");
		driver.findElement(By.id("searchboxinput")).sendKeys("Delhi");
		driver.findElement(By.id("searchbox-searchbutton")).click();
		Thread.sleep(8000);
		System.out.println(driver.findElement(By.xpath("//*[@id=\"pane\"]/div/div[1]/div/div/div[2]/div[1]/div[1]/h1")).getText());
		
		TakesScreenshot T = (TakesScreenshot)driver;
		File SRC = T.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(SRC, new File(".\\screenshot\\delhi.png"));
		//Thread.sleep(5000);

		driver.findElement(By.xpath("//*[@id=\"pane\"]/div/div[1]/div/div/div[4]/div[1]/div/button/img")).click();
		//driver.findElement(By.id("searchboxinput")).submit();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"sb_ifc51\"]/input")).sendKeys("Mumbai");
		driver.findElement(By.xpath("//*[@id=\"directions-searchbox-0\"]/button[1]")).click();
		//((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[@id='sbse10']//div[@class='suggest-left-cell']")));
		//driver.findElement(By.xpath("//div[@id='sbse15']//span[@class='suggest-bold'][contains(text(),'Bina')]")).click();
	//new Actions(driver).moveToElement(driver.findElement(By.xpath("//div[@id='sbse15']//span[@class='suggest-bold'][contains(text(),'Bina')]"))).click(driver.findElement(By.xpath("//div[@id='sbse15']//span[@class='suggest-bold'][contains(text(),'Bina')]"))).perform();
	Thread.sleep(5000);
		System.out.println(driver.findElement(By.xpath("//*[@id=\"section-directions-trip-0\"]/div[2]/div[2]/div[1]/div")).getText());
	}

}
