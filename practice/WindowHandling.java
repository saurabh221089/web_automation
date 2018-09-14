package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class WindowHandling {
	WebDriver driver;
  @Test
  public void closePopUp() throws InterruptedException {
	String mainWindow = driver.getWindowHandle();
	for (String popup:driver.getWindowHandles())
	{
		if (popup.equals(mainWindow))
		{
			continue;
		}
		driver.switchTo().window(popup);
		System.out.println("Popup URL --> "+driver.switchTo().window(popup).getCurrentUrl());
		driver.close();
	}
	driver.switchTo().window(mainWindow);
	System.out.println("********************************");
	System.out.println("Main window : "+driver.getTitle());
	Thread.sleep(4000);
  }
  
  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://www.popuptest.com/popuptest1.html");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
