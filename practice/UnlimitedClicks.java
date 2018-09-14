/* Created by CY4N0G3N
25-Sep-2015 10:24:45 PM
 */
package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UnlimitedClicks {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String url = "http://hakersparadise.blogspot.com/2015/09/how-to-extend-range-of-wifi-adapter.html";
		for (int i=1; i<=10; i++)
		{
			driver.get(url);
			Thread.sleep(8000);
			driver.close();
		}
	}

}
