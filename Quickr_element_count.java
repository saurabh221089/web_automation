import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/* Created by CY4N0G3N
02-Sep-2014 2:51:27 PM
 */

public class Quickr_element_count {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://www.quikr.com");
		List<WebElement> boxes = driver.findElements(By.xpath("//*[@id='main_textarea']/div/div[2]/div[3]/div"));
		System.out.println("Number of boxes : "+boxes.size());
		/*for (WebElement we : boxes)
		{
			we.click();
			driver.navigate().back();
		}
		*/
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scroll(0,20000)");
		js.executeScript("alert('Page scrolled to end !!')");
	}

}
