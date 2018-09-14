package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class OrangeHRM {
	private static final String username = "saurabh.badhwar";
	private static final String password = "Gspann123";
	private static final boolean submit = false;
	
	WebDriver driver;
	String url = "http://14.141.13.35/orangehrm/symfony/web/index.php/auth/login";
	
  @Test
  public void login() throws InterruptedException {
	  driver.findElement(By.id("txtUsername")).sendKeys(username);
	  driver.findElement(By.id("txtPassword")).sendKeys(password);
	  driver.findElement(By.id("btnLogin")).click();
	  Assert.assertTrue(driver.findElement(By.id("welcome")).isDisplayed(), "Welcome not visible, Login failed!!");
	  driver.findElement(By.xpath("//*[@id='menu_time_viewTimeModule']")).click();
	  Thread.sleep(5000);
	  Select select1 = new Select(driver.findElement(By.id("startDates")));
	  // Select the date range
	  select1.selectByIndex(0);
	  driver.findElement(By.xpath("//*[@id='btnEdit']")).click();
	  driver.findElement(By.xpath("//*[@id='initialRows_0_projectName']")).clear();
	  driver.findElement(By.xpath("//*[@id='initialRows_0_projectName']")).sendKeys("macys");
	  driver.findElement(By.xpath("//*[@id='initialRows_0_projectName']")).sendKeys(Keys.ENTER);
	  Thread.sleep(2000);
	  Select select2 = new Select(driver.findElement(By.xpath("//*[@id='initialRows_0_projectActivityName']")));
	  select2.selectByIndex(1);
	  // Fill 8 hours for all 5 days
	  for (int i=1;i<=5;i++)
	  {
	  driver.findElement(By.xpath("//*[@id='initialRows_0_"+i+"']")).clear();
	  driver.findElement(By.xpath("//*[@id='initialRows_0_"+i+"']")).sendKeys("8");
	  }
	  driver.findElement(By.xpath("//*[@id='submitSave']")).click();
	  Thread.sleep(5000);
	  // to Submit sheet or not
	  if(submit)
	  {
	  driver.findElement(By.xpath("//*[@id='btnSubmit']")).click();
	  System.out.println("Submitted hours for : "+select1.getFirstSelectedOption().getText());
	  }
	  Thread.sleep(1000);
	  // Verify Status is Submitted
	  WebElement status = driver.findElement(By.xpath("//*[@id='timesheet']/div/div[4]/em/h2"));
	  Assert.assertEquals(status.getText(), "Status: Submitted");
	  Thread.sleep(2000);
	  // Logout
	  driver.findElement(By.xpath("//*[@id='welcome']")).click();
	  driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[2]/a")).click();
	  Thread.sleep(3000);
  }
  
  @BeforeClass
  public void beforeClass() {
	  driver= new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get(url);
  }

  @AfterClass
  public void afterClass() {
	driver.close();
  }

}
