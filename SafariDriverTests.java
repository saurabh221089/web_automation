import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/* Created by CY4N0G3N
02-Feb-2016 9:28:07 PM
 */

public class SafariDriverTests {

	private WebDriver driver = null;
	
	@BeforeTest
	public void createDriver() {
	    driver = new SafariDriver();
	    driver.manage().window().maximize();
	  }
	
	@AfterTest
	public void quitDriver() {
	    driver.quit();
	  }
	
	@Test
	void performAGoogleSearch() {
	    driver.get("http://www.google.com");
	    driver.findElement(By.name("q")).sendKeys("webdriver");
	    driver.findElement(By.name("btnG")).click();
	    new WebDriverWait(driver, 3)
	        .until(ExpectedConditions.titleIs("webdriver - Google Search"));
	  }

}
