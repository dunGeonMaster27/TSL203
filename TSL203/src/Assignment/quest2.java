package Assignment;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class quest2 {

	public static void main(String[] args) throws Exception{
		
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		TakesScreenshot screen = (TakesScreenshot)driver;
		driver.manage().window().maximize();
		driver.get("https://www.nseindia.com/");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.id("keyword")).sendKeys("Mahindra & Mahindra Limited");
		
		Actions A  = new Actions(driver);
		A.moveToElement(driver.findElement(By.xpath("//*[@id=\"ajax_response\"]/ol/li/a/b"))).click().perform();

		String m= driver.findElement(By.id("faceValue")).getText();
		System.out.println("Face Value of Mahindra & Mahindra " + m);
		
		File SRC = screen.getScreenshotAs(OutputType.FILE);
		 FileHandler.copy(SRC, new File(".\\Mahindra.png"));
		 
		 driver.navigate().back();
		 
		 driver.findElement(By.id("keyword")).sendKeys("Bajaj Finserv Limited");
			
			
			A.moveToElement(driver.findElement(By.xpath("//*[@id=\"ajax_response\"]/ol/li/a/b"))).click().perform();

			String b= driver.findElement(By.id("faceValue")).getText();
			System.out.println("Face Value of Bajaj Finserv Limited " + b);
			
			File bajaj = screen.getScreenshotAs(OutputType.FILE);
			 FileHandler.copy(bajaj, new File(".\\Bajaj.png"));
			 driver.navigate().back();
			 driver.findElement(By.id("keyword")).sendKeys("Hindustan Unilever");
				
				
				A.moveToElement(driver.findElement(By.xpath("//*[@id=\"ajax_response\"]/ol/li/a"))).click().perform();

				String h= driver.findElement(By.id("faceValue")).getText();
				System.out.println("Face Value of Hindustan Unilever Limited " + h);
				
				File hindustan = screen.getScreenshotAs(OutputType.FILE);
				 FileHandler.copy(hindustan, new File(".\\Hindustan.png"));
				 driver.navigate().back();
				 
				 driver.findElement(By.id("keyword")).sendKeys("GAIL");
					
					
					A.moveToElement(driver.findElement(By.xpath("//*[@id=\"ajax_response\"]/ol/li/a/b"))).click().perform();

					String g= driver.findElement(By.id("faceValue")).getText();
					System.out.println("Face Value of GAIL " + g);
					
					File gail = screen.getScreenshotAs(OutputType.FILE);
					 FileHandler.copy(gail, new File(".\\GAIL.png"));
			 
	}

}
