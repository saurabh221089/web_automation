package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class AlertTest {
	WebDriver driver;
	
  public boolean verifyAlert() {
	  try{
	  driver.switchTo().alert();
	  return true;
	  }
	  catch (NoAlertPresentException e)
	  {
		 return false;
	  }
  }
  
  @Test
  public void acceptAlert() throws InterruptedException {
	 Alert alert = driver.switchTo().alert();
	 String alerttext = alert.getText();
	 System.out.println("Alert Present : "+verifyAlert());
	 System.out.println("Alert Text : "+alerttext);
	 alert.accept();
	 Thread.sleep(5000);
  }
  
  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.get("http://localhost/captcha/example-form.php");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
