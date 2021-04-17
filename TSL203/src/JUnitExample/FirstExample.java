package JUnitExample;

//import static org.junit.Assert.fail;
import static org.testng.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstExample {

	static WebDriver driver;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
		System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	driver.quit();}

	@Test
	public void test() {
		
		driver.get("http://www.nseit.com/");	
		String url = driver.findElement(By.linkText("News")).getAttribute("href");
		assertEquals("http://www.nseit.com/news-events.html",url);
	}

}
