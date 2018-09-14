package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class DragDrop {

	
	private WebDriver driver;
	
  @Test(enabled=false)
  public void peformDragNDrop() throws InterruptedException {
	  
	  WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".demo-frame")));
		WebElement Source = driver.findElement(By.cssSelector(".ui-draggable"));
		WebElement Destination = driver.findElement(By.cssSelector(".ui-droppable"));
		Assert.assertEquals(Source.getText(), "Drag me to my target");
		Assert.assertEquals(Destination.getText(), "Drop here");
		Actions builder = new Actions(driver);
		builder.dragAndDrop(Source,Destination).build().perform();
		//Assert.assertEquals(Destination.getText(), "Dropped!");
		Assert.assertTrue(Destination.getText().contains("Dropped"));
	  Thread.sleep(5000);
  }
  
  @Test(enabled=true)
  public void peformDragNDropV2() throws InterruptedException
  {
	  //driver.navigate().to("http://jqueryui.com/resources/demos/droppable/default.html");
	  	WebDriverWait wait = new WebDriverWait(driver, 5);
	  	wait.until(ExpectedConditions.presenceOfElementLocated(By.className("demo-frame")));
	  	driver.switchTo().frame(0);
	  	WebElement Source = driver.findElement(By.id("draggable"));
		WebElement Destination = driver.findElement(By.id("droppable"));
		Assert.assertEquals(Source.getText(), "Drag me to my target");
		Assert.assertEquals(Destination.getText(), "Drop here");
		Actions builder = new Actions(driver);
		builder.clickAndHold(Source).moveToElement(Destination).release(Destination).build().perform();
		//Assert.assertEquals(Destination.getText(), "Dropped!");
		Assert.assertTrue(Destination.getText().contains("Dropped"));
	  Thread.sleep(5000);
	  
  }
  
  @BeforeClass
  public void beforeTest() {
	driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("http://jqueryui.com/droppable/");
	
  }

  @AfterClass
  public void afterTest() {
	  driver.quit();
  }

}
