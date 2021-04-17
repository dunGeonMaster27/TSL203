package JUnitExample;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
//import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Example3 {
static WebDriver driver;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com/");
		assertEquals("Welcome: Mercury Tours", driver.getTitle());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	driver.quit();
	}
	
	@After
	public void tearDown() throws Exception {
		driver.navigate().back();
		assertEquals("Welcome: Mercury Tours", driver.getTitle());
	}

	@Test
	public void test1() {
		driver.findElement(By.linkText("REGISTER")).click();
		assertEquals("Register: Mercury Tours", driver.getTitle());
	}
	
	@Test
	public void test2() {
		driver.findElement(By.linkText("SIGN-ON")).click();
		assertEquals("Sign-on: Mercury Tours", driver.getTitle());
	}

}
