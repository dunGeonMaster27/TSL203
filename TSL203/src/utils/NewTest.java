package utils;

import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class NewTest extends Base {
  @Test
  public void f() {
	     driver.get("http://google.com");
		List<WebElement> AlllinkImage=driver.findElements(By.xpath("//a"));
		AlllinkImage.addAll(driver.findElements(By.tagName("img")));
	    for(WebElement E:AlllinkImage)
		 {
	   		String url= E.getAttribute("href");
			System.out.println();
			
			try {
			URL u=new URL(url);
			Proxy webProxy  = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("192.168.100.1", 8081));
			URLConnection con=u.openConnection(webProxy);  // Opens Port for Connection
			HttpURLConnection HUC=(HttpURLConnection)con;
			HUC.connect();
			
			int code=HUC.getResponseCode();
			
			if(code==200)
			{
			System.out.println(url+" -----Working with status "+code);	
			}
			else
			{
				System.out.println(url+" -----not Working with status "+code);	
			}
		}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
			}

		 }
	}
  
}
