package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleSearch {
  
  public static void main(String []ar)
  {
	  WebDriver driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.get("http://www.google.com/");
	  //WebElement sb = driver.findElement(By.name("q"));
	  WebElement sb = driver.findElement(By.id("lst-ib"));
	  sb.sendKeys("a");
	  //sb.submit();
	  //driver.findElement(By.className("sbico")).click();
	  //driver.findElement(By.xpath("//a[contains(text(),'Saurabh Badhwar profiles | LinkedIn')]")).click();
	  List<WebElement> lst = driver.findElements(By.xpath("//*[@id='sbtc']/div[2]/div[2]/div[1]/div/ul/li"));
	  
	  for (WebElement we : lst)
	  {
		  System.out.println(we.getText());
	  }
	  
  }
  
}
