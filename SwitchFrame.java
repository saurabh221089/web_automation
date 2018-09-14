import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

/* Created by CY4N0G3N
12-Sep-2014 3:44:29 PM
 */

public class SwitchFrame {

	public static void main(String[] args) throws InterruptedException{
		//System.setProperty("webdriver.chrome.driver", "D:\\OFFICE WORK\\Automation\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/test/iFrame.php");
		String parent = driver.getWindowHandle();
		System.out.println(parent);
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='frametest']")));
		driver.findElement(By.xpath("/html/body/a[4]")).click();
		Thread.sleep(5000);
		driver.switchTo().window(parent);
		driver.findElement(By.xpath("//*[@id='textbox1']")).sendKeys("Hello world!!");
	}

}
