package Assignment;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class quest {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		TakesScreenshot screen = (TakesScreenshot)driver;
		driver.get("https://www.nseindia.com/");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.id("keyword")).sendKeys("Reliance industries");
		
		Actions A  = new Actions(driver);
		A.moveToElement(driver.findElement(By.xpath("//*[@id=\"ajax_response\"]/ol/li/a"))).click().perform();
		
		File SRC = screen.getScreenshotAs(OutputType.FILE);
		 FileHandler.copy(SRC, new File(".\\Reliance.png"));
		 
		String s= driver.findElement(By.id("faceValue")).getText();
		System.out.println("Face Value " + s);
		
		String h= driver.findElement(By.xpath("//*[@id=\"high52\"]/font")).getText();
		System.out.println("52 Week High " + h);
		
		String l= driver.findElement(By.id("low52")).getText();
		System.out.println("52 Week Low " + l);
		
	}

}
