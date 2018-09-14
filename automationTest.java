
import java.util.List;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/* Created by CY4N0G3N
21-Aug-2014 4:53:58 PM
 */

public class automationTest {
public static void main(String []args) throws InterruptedException
{
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("http://www.google.com");
	driver.findElement(By.xpath("//input[@id='lst-ib']")).sendKeys("saurabh badhwar");
	driver.findElement(By.xpath("//button[@value='Search']")).click();
	WebElement link = driver.findElement(By.xpath("//a[contains(text(),'LinkedIn')]"));
	System.out.println("Web element found");
	Actions action = new Actions(driver);
	action.contextClick(link).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	Thread.sleep(5000);
	driver.quit();
}
}
