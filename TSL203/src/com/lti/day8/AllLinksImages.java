package com.lti.day8;

import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.Base;

public class AllLinksImages extends Base{
  @Test
  public void f() {
	  
	  driver.get("http://google.com");
	  
	  List<WebElement> ImagesLinks = driver.findElements(By.tagName("a"));
	  ImagesLinks.addAll(driver.findElements(By.xpath("//img")));
	  
	  
	  for(WebElement E:ImagesLinks)
	  {
		  String href = E.getAttribute("href");
		  System.out.println(href);
		  try {
			  
			URL url = new URL(href);
			Proxy webProxy = new Proxy(Proxy.Type.HTTP,new InetSocketAddress("192.168.100.1",8081));
			URLConnection U = url.openConnection(webProxy);
			HttpURLConnection HC = (HttpURLConnection)U;
			HC.connect();
			if(HC.getResponseCode()== 200)
				System.out.println(href + " is Working");
			else
				System.out.println(href + " is not Working");
			
			
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
  }
}
