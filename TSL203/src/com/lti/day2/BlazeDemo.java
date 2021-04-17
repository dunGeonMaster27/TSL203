package com.lti.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BlazeDemo {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://blazedemo.com/");
		driver.manage().window().maximize();
		
		WebElement E = driver.findElement(By.name("fromPort"));
		
		Select selectFrom = new Select(E);
		selectFrom.selectByIndex(6);
		//selectFrom.selectByValue("Portland");
		//selectFrom.selectByVisibleText("Boston");
		
		Select selectTo = new Select(driver.findElement(By.name("toPort")));
		selectTo.selectByIndex(3);
		
		driver.findElement(By.cssSelector("input[value='Find Flights']")).click();
		//driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[3]/td[1]/input")).click();

		List<WebElement> All = driver.findElements(By.cssSelector("input[value='Choose This Flight']"));
		System.out.println("Total elements are " + All.size());
		All.get(2).click();		
		
		driver.findElement(By.id("inputName")).sendKeys("Sherlock Holmeswa");
		
		driver.findElement(By.id("address")).sendKeys("221B Baker Street");
		
		driver.findElement(By.id("city")).sendKeys("London");
		
		driver.findElement(By.id("state")).sendKeys("United Kingdom");
		
		driver.findElement(By.id("zipCode")).sendKeys("72046");
		
		Select selectCard = new Select(driver.findElement(By.name("cardType")));
		selectCard.selectByVisibleText("American Express");
		
		driver.findElement(By.id("creditCardNumber")).sendKeys("4444333322221111");
		
		driver.findElement(By.id("creditCardMonth")).clear();
		driver.findElement(By.id("creditCardMonth")).sendKeys("07");

		driver.findElement(By.id("creditCardYear")).clear();
		driver.findElement(By.id("creditCardYear")).sendKeys("2024");

		driver.findElement(By.id("nameOnCard")).sendKeys("Sherlock Holmeswa");

		driver.findElement(By.id("rememberMe")).click();
		
		WebElement Rem = driver.findElement(By.id("rememberMe"));
		boolean displayed = Rem.isDisplayed();
		boolean enabled = Rem.isEnabled();
		boolean selected = Rem.isSelected();
		String type = Rem.getAttribute("type");
	
		if(displayed==true && enabled==true && selected==true && type.equals("checkbox"))
			System.out.println("Test for Remember me Pass");
		else
			System.out.println("Test for Remember me Failed");
		
		driver.findElement(By.cssSelector("input[value='Purchase Flight']")).click();
		
		if(driver.getTitle().contentEquals("BlazeDemo Confirmation")) {
			System.out.print("ID: ");
			System.out.println(driver.findElement(By.xpath("/html/body/div[2]/div/table/tbody/tr[1]/td[2]")).getText());
			System.out.println("Tickets confirmed");
		}
		else {
			System.out.println("Tickets are not confirmed");
		}
				
	}
	
}
