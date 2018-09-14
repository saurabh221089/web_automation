import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/* Created by CY4N0G3N
02-Sep-2014 4:32:23 PM
 */

public class ExecutingJS {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("alert('hello world!!')");
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		System.out.println("Alert box accepted..");
		driver.quit();
	}

}
