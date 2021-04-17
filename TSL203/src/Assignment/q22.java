package Assignment;

import static org.testng.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import utils.Base;

public class q22 extends Base{

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
		driver.get("https://www.wikipedia.org/");
		System.out.println(driver.findElement(By.xpath("//*[@id=\"js-link-box-en\"]/small/bdi")).getText());
		driver.findElement(By.xpath("//*[@id=\"js-link-box-en\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"searchInput\"]")).sendKeys(" Anna University");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"searchButton\"]")).click();
		String s = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[2]/tbody/tr[2]/td/i")).getText();
		assertEquals(s.contains("Knowledge"), true);
		System.out.println(s);
		
String s1 =		driver.findElement(By.xpath("//a[contains(text(),'Shiv Nadar')]")).getText();
		assertEquals(s1, "Shiv Nadar");
System.out.println("ghghghg");
	}

}
