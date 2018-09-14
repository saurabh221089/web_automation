/* Created by CY4N0G3N
28-Nov-2014 4:53:48 PM
 */
package macys_framework;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class GuestCheckout {

	WebDriver driver;
	static int i;
	public String path = "D:\\OFFICE WORK\\Automation\\";
	
	@BeforeClass
	public void setUp() {
		//System.setProperty("webdriver.chrome.driver","D:\\OFFICE WORK\\Automation\\chromedriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.macys.com/");
		System.out.println(driver.manage().getCookieNamed("shippingCountry"));
	}

	@Test
	public void searchProduct() {
		driver.findElement(By.id("globalSearchInputField")).sendKeys("jeans"+Keys.ENTER);
		
	}
	
	@Test
	public void openProductInNewTab() {
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
		driver.findElement(By.xpath("//*[@class='productThumbnail'][1]/div[1]/div[2]/a")).sendKeys(selectLinkOpeninNewTab);
		//driver.findElement(By.xpath("//*[@class='productThumbnail'][1]/div[1]/div[2]/a")).click();
	}
	
	@AfterMethod
	public void screenshot() throws IOException {
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		i++;
		FileUtils.copyFile(scr, new File(path+i+".jpg"));
	}
	
	@AfterClass
	public void bye() {
		driver.close();
	}

}
