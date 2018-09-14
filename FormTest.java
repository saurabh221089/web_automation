import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/* Created by CY4N0G3N
09-Sep-2014 4:18:12 PM
 */

public class FormTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost/test/form.html");
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		System.out.println(js1.executeScript("return jQuery.active", ""));
		WebElement female = driver.findElement(By.xpath("//input[@id='female']"));
		WebElement male = driver.findElement(By.xpath("//input[@id='male']"));
		male.click();
		//Thread.sleep(5000);
		if(male.isSelected())
		{
			female.click();
		}
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		System.out.println(js2.executeScript("return jQuery.active", ""));
		
	}

}
