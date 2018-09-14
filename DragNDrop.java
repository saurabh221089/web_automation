import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

/* Created by CY4N0G3N
28-Aug-2014 10:55:00 AM
 */

public class DragNDrop {
public static void main(String []str)
{
	System.setProperty("webdriver.gecko.driver", "D:\\OFFICE WORK\\Automation\\drivers\\geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("http://www.w3schools.com/html/html5_draganddrop.asp");
	WebElement source = driver.findElement(By.id("drag1"));
	WebElement dest = driver.findElement(By.id("div2"));
	Actions action = new Actions(driver);
	action.dragAndDrop(source, dest).perform();
	
}
}
