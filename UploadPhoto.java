import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/* Created by CY4N0G3N
28-Aug-2014 5:01:32 PM
 */

public class UploadPhoto {
	public static void main(String []args) throws InterruptedException
	{
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://14.141.13.35/orangehrm/symfony/web/index.php/auth/login");
		driver.findElement(By.id("txtUsername")).sendKeys("saurabh.badhwar");
		driver.findElement(By.id("txtPassword")).sendKeys("Gspann123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("btnAddAttachment")).click();
		driver.findElement(By.id("ufile")).sendKeys("D:\\Pics\\saurabh_badhwar.jpg");
		driver.findElement(By.id("txtAttDesc")).sendKeys("Attachment added by Automation.");
		driver.findElement(By.id("btnSaveAttachment")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='welcome']")).click();
		driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[2]/a")).click();
		Thread.sleep(5000);
		driver.quit();
	}
}
