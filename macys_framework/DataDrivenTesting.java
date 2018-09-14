package macys_framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class DataDrivenTesting {
	
	WebDriver driver;
	
  @Test(dataProvider = "dp")
  public void testBmiCalculator(String height, String weight, String bmi, String category) {
	  driver.findElement(By.id("heightCMS")).clear();
	  driver.findElement(By.id("heightCMS")).sendKeys(height);
	  driver.findElement(By.id("weightKg")).clear();
	  driver.findElement(By.id("weightKg")).sendKeys(weight);
	  driver.findElement(By.id("Calculate")).click();
	  Assert.assertEquals(driver.findElement(By.id("bmi")).getAttribute("value"), bmi);
	  Assert.assertEquals(driver.findElement(By.id("bmi_category")).getAttribute("value"), category);
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "171", "72", "24.6", "Normal" },
      new Object[] { "171", "73", "25.0", "Overweight" },
      new Object[] { "171", "50", "17.1", "Underweight" },
      new Object[] { "171", "53", "18.1", "Underweight"},
      new Object[] { "171", "54", "18.5", "Normal" },
      new Object[] { "178", "100", "31.6", "Obesity"},
    };
  }
  
  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	  driver.get("https://dl.dropboxusercontent.com/s/h2ozrzjg405l6f2/bmicalculator.html");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
