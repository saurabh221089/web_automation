package macys_framework;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opera.core.systems.runner.inprocess.ScreenCapture;

/* Created by CY4N0G3N
27-Aug-2014 4:15:10 PM
 */

public class HoverOverLinks {
public static void main(String []str) throws InterruptedException, IOException
{
	WebDriver driver = new FirefoxDriver();
	driver.get("http://www.macys.com/");
	List<WebElement> we = driver.findElements(By.xpath("//li[contains(@id,'flexLabel')]"));
	Actions action = new Actions(driver);
	
	Iterator<WebElement> itr = we.iterator();
	while(itr.hasNext())
	{
		Thread.sleep(1000);
		WebElement wb = itr.next();
		System.out.println(wb.getText());
		action.moveToElement(wb).contextClick(wb).sendKeys(Keys.DOWN).sendKeys(Keys.RETURN).build().perform();
	}
	/*
	for (WebElement b: we)
	{
	Thread.sleep(1000);
	System.out.println(b.getText());
	action.moveToElement(b).contextClick(b).sendKeys(Keys.DOWN).sendKeys(Keys.RETURN).build().perform();
	}
	*/
	
	Thread.sleep(5000);
	driver.quit();
	
}
}
