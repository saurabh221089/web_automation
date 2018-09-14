package macys_framework;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.google.common.base.Stopwatch;

public class LocalStorageClass {
	WebDriver driver;
	Stopwatch watch;
  
	@Test(enabled = false)
	public void testHTML5LocalStorage() throws Exception {
		String lastName;
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("localStorage.lastname='Badhwar';");
		//Get the current value of localStorage.lastname, this should be Badhwar
		lastName = (String) jsExecutor.executeScript("return localStorage.lastname;");
		Thread.sleep(5000);
		assertEquals(lastName, "Badhwar", "Lastname found "+"'"+lastName+"'"+" but Expected was 'Badhwar'");
		}
	
	@Test(priority = 1)
	public void testHTML5Components() throws Exception {
		WebElement audioplayer = driver.findElement(By.id("audioplayer"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("return arguments[0].play()", audioplayer);
		Thread.sleep(8000);
		jsExecutor.executeScript("return arguments[0].pause()", audioplayer);
		WebElement flash = driver.findElement(By.xpath("//*[@id='flashcontent']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(flash).clickAndHold(flash).moveByOffset(-200, -100).moveByOffset(200, 200).release().build().perform();
		Thread.sleep(5000);
	}
  
  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.get("http://localhost/HTML5/html5demo.html");
  }
  
  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
