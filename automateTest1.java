import static org.testng.AssertJUnit.assertTrue;
import org.testng.AssertJUnit;
import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/* Created by CY4N0G3N
25-Aug-2014 11:24:02 AM
 */

public class automateTest1 {
public static void main(String []str)
{
	WebDriver  driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("http://localhost/test/getdetails.php");
	WebElement wb1 = driver.findElement(By.id("searchId"));
	wb1.sendKeys("1"+Keys.ENTER);
	WebElement wb2 = driver.findElement(By.xpath("html/body/form/table[2]/tbody/tr[2]/td[2]"));
	assertEquals("Saurabh Badhwar",wb2.getText());
	System.out.println(wb2.getText());
	}
}
