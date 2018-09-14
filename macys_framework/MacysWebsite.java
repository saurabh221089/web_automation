package macys_framework;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.thoughtworks.selenium.Wait;


public class MacysWebsite {
	
	WebDriver driver;
	
	String prev_path = "E:\\OFFICE WORK\\Automation\\previous_build_screenshots\\";
	Actions action;
	WebDriverWait wait;
	String bra_url = "http://www1.macys.com/shop/womens-clothing/bras?id=55799";
	String panties_url = "http://www1.macys.com/shop/womens-clothing/panties?id=55805";
	String lingerie_url = "http://www1.macys.com/shop/womens-clothing/lingerie-sets?id=55804";
	String shapewear_url= "http://www1.macys.com/shop/womens-clothing/shapewear?id=60764";
	String pajamas_url = "http://www1.macys.com/shop/womens-clothing/pajamas-and-robes?id=59737";
	String bridal_url = "http://www1.macys.com/shop/womens-clothing/bridal-lingerie?id=55767";
	String nightgowns_url = "http://www1.macys.com/shop/womens-clothing/nightgowns-sleep-shirts?id=55810";
	String sexylingerie_url = "http://www1.macys.com/shop/womens-clothing/sexy-lingerie?id=68110";
	String chemises_url = "http://www1.macys.com/shop/womens-clothing/chemises?id=55809";
	String plussize_url = "http://www1.macys.com/shop/womens-clothing/plus-size-lingerie?id=55773";
	String sportsbra_url = "http://www1.macys.com/shop/womens-clothing/bras/Bra_features/Sports?id=55799";
	String sockstights_url = "http://www1.macys.com/shop/handbags-accessories/socks-tights?id=40546";
	
public void takeScreenshot(String name) throws IOException{
	File scrnshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrnshot, new File("E:\\OFFICE WORK\\Automation\\previous_build_screenshots\\"+name+".jpg"));
}

public void switchWindow()
{
	Set<String> windows = driver.getWindowHandles();
	System.out.println(windows);
	for(String handle: driver.getWindowHandles())
	  {
	  driver.switchTo().window(handle);
	  }
}

@Test(enabled = false)
public void filterbrands() throws InterruptedException, IOException
{
	  driver.findElement(By.xpath("//input[@id='globalSearchInputField']")).sendKeys("shoes"+Keys.ENTER);
	  driver.findElement(By.xpath("//*[@id='ALL_BRANDS']")).click();
	  driver.findElement(By.xpath("//*[@id='allBrands_Sebago']")).click();
	  Thread.sleep(5000);
	  String count1 = driver.findElement(By.xpath("//*[@id='hCount_BRAND_Sebago']")).getText();
	  String prod_count = driver.findElement(By.xpath("//*[@id='productCount']")).getText();
	  String total_prod = "("+prod_count+")";
	  Assert.assertEquals(count1, total_prod);
	  driver.findElement(By.xpath("//*[@id='allBrands_Sean John']")).click();
	  //System.out.println("Total prodcts on page : "+driver.findElement(By.xpath("//*[@id='productCount']")).getText());
	  Thread.sleep(5000);
	  takeScreenshot("shoes");
}
  
  @Test(priority = 1)
  public void brasAndLingerieSubCatIcons() throws InterruptedException, IOException {
	  action = new Actions(driver);
	  //Verifying the featured category links
	  action.moveToElement(driver.findElement(By.xpath("//*[@id='flexLabel_118']/a"))).click(driver.findElement(By.xpath("//*[@id='flexLabel_225']/a"))).build().perform();
	  Assert.assertTrue(driver.findElement(By.id("cate_Panties")).isDisplayed(), "SubCategory Panties is not displayed.");
	  Assert.assertTrue(driver.findElement(By.id("cate_Bras")).isDisplayed(), "SubCategory Bras is not displayed.");
	  Assert.assertTrue(driver.findElement(By.id("cate_Lingerie Sets")).isDisplayed(), "SubCategory Lingerie Sets is not displayed.");
	  Assert.assertTrue(driver.findElement(By.id("cate_Shapewear")).isDisplayed(), "SubCategory Shapewear is not displayed.");
	  Assert.assertTrue(driver.findElement(By.id("cate_Pajamas")).isDisplayed(), "SubCategory Pajamas is not displayed.");
	  Assert.assertTrue(driver.findElement(By.id("cate_Plus Size Lingerie")).isDisplayed(), "SubCategory Plus size lingerie is not displayed.");
	  Assert.assertTrue(driver.findElement(By.id("cate_Chemises")).isDisplayed(), "SubCategory Chemises is not displayed.");
	  Assert.assertTrue(driver.findElement(By.id("cate_Nightgowns")).isDisplayed(), "SubCategory Nightgowns is not displayed.");
	  Assert.assertTrue(driver.findElement(By.id("cate_Bridal Lingerieq")).isDisplayed(), "SubCategory Bridal lingerie is not displayed.");
	  Assert.assertTrue(driver.findElement(By.id("cate_Sexy Lingerie")).isDisplayed(), "SubCategory Sexy lingerie is not displayed.");
	  Assert.assertTrue(driver.findElement(By.id("cate_Sports Bras")).isDisplayed(), "SubCategory Sports Bras is not displayed.");
	  Assert.assertTrue(driver.findElement(By.id("cate_Tights, Socks and Hosiery")).isDisplayed(), "SubCategory Tights, socks and hosiery is not displayed.");
	  takeScreenshot(driver.getTitle()); 	
  }
  
  @Test(priority = 2)
  public void clickBraSubCat() throws InterruptedException, IOException
  {
	  action = new Actions(driver);
	  String mainWin = driver.getWindowHandle();
	  action.keyDown(Keys.SHIFT).click(driver.findElement(By.id("cate_Bras"))).keyUp(Keys.SHIFT).build().perform();
	  switchWindow();
	  Assert.assertTrue(driver.getCurrentUrl().contains(bra_url));
	  wait = new WebDriverWait(driver, 20);
	  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("productThumbnailLink"))));
	  takeScreenshot(driver.getTitle());
	  action.sendKeys(Keys.CONTROL+"w").build().perform();
	  driver.switchTo().window(mainWin);
  }
  
  @Test(priority = 3)
  public void clickPantiesSubCat() throws InterruptedException, IOException
  {
	  action = new Actions(driver);
	  String mainWin = driver.getWindowHandle();
	  action.keyDown(Keys.SHIFT).click(driver.findElement(By.id("cate_Panties"))).keyUp(Keys.SHIFT).build().perform();
	  switchWindow();
	  Assert.assertTrue(driver.getCurrentUrl().contains(panties_url));
	  //wait = new WebDriverWait(driver, 20);
	  //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("productThumbnailLink"))));
	  takeScreenshot(driver.getTitle());
	  action.sendKeys(Keys.CONTROL+"w").build().perform();
	  driver.switchTo().window(mainWin);
  }
  
  
  @Test(priority = 4)
  public void clickLingerieSubCat() throws InterruptedException, IOException
  {
	  action = new Actions(driver);
	  String mainWin = driver.getWindowHandle();
	  action.keyDown(Keys.SHIFT).click(driver.findElement(By.id("cate_Lingerie Sets"))).keyUp(Keys.SHIFT).build().perform();
	  switchWindow();
	  Assert.assertTrue(driver.getCurrentUrl().contains(lingerie_url));
	  //wait = new WebDriverWait(driver, 20);
	  //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("productThumbnailLink"))));
	  takeScreenshot(driver.getTitle());
	  action.sendKeys(Keys.CONTROL+"w").build().perform();
	  driver.switchTo().window(mainWin);
  }
  
  @Test(priority = 5)
  public void clickShapewearSubCat() throws InterruptedException, IOException
  {
	  action = new Actions(driver);
	  String mainWin = driver.getWindowHandle();
	  action.keyDown(Keys.SHIFT).click(driver.findElement(By.id("cate_Shapewear"))).keyUp(Keys.SHIFT).build().perform();
	  switchWindow();
	  Assert.assertTrue(driver.getCurrentUrl().contains(shapewear_url));
	  //wait = new WebDriverWait(driver, 20);
	  //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("productThumbnailLink"))));
	  takeScreenshot(driver.getTitle());
	  action.sendKeys(Keys.CONTROL+"w").build().perform();
	  driver.switchTo().window(mainWin);
  }
  
  @Test(priority = 6)
  public void clickPajamasSubCat() throws InterruptedException, IOException
  {
	  action = new Actions(driver);
	  String mainWin = driver.getWindowHandle();
	  action.keyDown(Keys.SHIFT).click(driver.findElement(By.id("cate_Pajamas"))).keyUp(Keys.SHIFT).build().perform();
	  switchWindow();
	  Assert.assertTrue(driver.getCurrentUrl().contains(pajamas_url));
	  //wait = new WebDriverWait(driver, 20);
	  //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("productThumbnailLink"))));
	  takeScreenshot(driver.getTitle());
	  action.sendKeys(Keys.CONTROL+"w").build().perform();
	  driver.switchTo().window(mainWin);
  }
  
  @Test(priority = 7)
  public void clickNightgownsSubCat() throws InterruptedException, IOException
  {
	  action = new Actions(driver);
	  String mainWin = driver.getWindowHandle();
	  action.keyDown(Keys.SHIFT).click(driver.findElement(By.id("cate_Nightgowns"))).keyUp(Keys.SHIFT).build().perform();
	  switchWindow();
	  Assert.assertTrue(driver.getCurrentUrl().contains(nightgowns_url));
	  //wait = new WebDriverWait(driver, 20);
	  //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("productThumbnailLink"))));
	  takeScreenshot(driver.getTitle());
	  action.sendKeys(Keys.CONTROL+"w").build().perform();
	  driver.switchTo().window(mainWin);
  }
  
  @Test(priority = 8)
  public void clickSexyLingerieSubCat() throws InterruptedException, IOException
  {
	  action = new Actions(driver);
	  String mainWin = driver.getWindowHandle();
	  action.keyDown(Keys.SHIFT).click(driver.findElement(By.id("cate_Sexy Lingerie"))).keyUp(Keys.SHIFT).build().perform();
	  switchWindow();
	  Assert.assertTrue(driver.getCurrentUrl().contains(sexylingerie_url));
	  //wait = new WebDriverWait(driver, 20);
	  //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("productThumbnailLink"))));
	  takeScreenshot(driver.getTitle());
	  action.sendKeys(Keys.CONTROL+"w").build().perform();
	  driver.switchTo().window(mainWin);
  }
  
  @Test(priority = 9)
  public void clickBridalLingeriesSubCat() throws InterruptedException, IOException
  {
	  action = new Actions(driver);
	  String mainWin = driver.getWindowHandle();
	  action.keyDown(Keys.SHIFT).click(driver.findElement(By.id("cate_Bridal Lingerieq"))).keyUp(Keys.SHIFT).build().perform();
	  switchWindow();
	  Assert.assertTrue(driver.getCurrentUrl().contains(bridal_url));
	  //wait = new WebDriverWait(driver, 20);
	  //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("productThumbnailLink"))));
	  takeScreenshot(driver.getTitle());
	  action.sendKeys(Keys.CONTROL+"w").build().perform();
	  driver.switchTo().window(mainWin);
  }
  
  @Test(priority = 10)
  public void clickChemisesSubCat() throws InterruptedException, IOException
  {
	  action = new Actions(driver);
	  String mainWin = driver.getWindowHandle();
	  action.keyDown(Keys.SHIFT).click(driver.findElement(By.id("cate_Chemises"))).keyUp(Keys.SHIFT).build().perform();
	  switchWindow();
	  Assert.assertTrue(driver.getCurrentUrl().contains(chemises_url));
	  //wait = new WebDriverWait(driver, 20);
	  //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("productThumbnailLink"))));
	  takeScreenshot(driver.getTitle());
	  action.sendKeys(Keys.CONTROL+"w").build().perform();
	  driver.switchTo().window(mainWin);
  }
  
  @Test(priority = 11)
  public void clickPlusSizeSubCat() throws InterruptedException, IOException
  {
	  action = new Actions(driver);
	  String mainWin = driver.getWindowHandle();
	  action.keyDown(Keys.SHIFT).click(driver.findElement(By.id("cate_Plus Size Lingerie"))).keyUp(Keys.SHIFT).build().perform();
	  switchWindow();
	  Assert.assertTrue(driver.getCurrentUrl().contains(plussize_url));
	  //wait = new WebDriverWait(driver, 20);
	  //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("productThumbnailLink"))));
	  takeScreenshot(driver.getTitle());
	  action.sendKeys(Keys.CONTROL+"w").build().perform();
	  driver.switchTo().window(mainWin);
  }
  
  @Test(priority = 12)
  public void clickSportsBraSubCat() throws InterruptedException, IOException
  {
	  action = new Actions(driver);
	  String mainWin = driver.getWindowHandle();
	  action.keyDown(Keys.SHIFT).click(driver.findElement(By.id("cate_Sports Bras"))).keyUp(Keys.SHIFT).build().perform();
	  switchWindow();
	  Assert.assertTrue(driver.getCurrentUrl().contains(sportsbra_url));
	  //wait = new WebDriverWait(driver, 20);
	  //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("productThumbnailLink"))));
	  takeScreenshot(driver.getTitle());
	  action.sendKeys(Keys.CONTROL+"w").build().perform();
	  driver.switchTo().window(mainWin);
  }
  
  @Test(priority = 13)
  public void clickSocksTightsSubCat() throws InterruptedException, IOException
  {
	  action = new Actions(driver);
	  String mainWin = driver.getWindowHandle();
	  action.keyDown(Keys.SHIFT).click(driver.findElement(By.id("cate_Tights, Socks and Hosiery"))).keyUp(Keys.SHIFT).build().perform();
	  switchWindow();
	  Assert.assertTrue(driver.getCurrentUrl().contains(sockstights_url));
	  //wait = new WebDriverWait(driver, 20);
	  //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("productThumbnailLink"))));
	  takeScreenshot(driver.getTitle());
	  action.sendKeys(Keys.CONTROL+"w").build().perform();
	  driver.switchTo().window(mainWin);
  }
  
  @Test(enabled = false)
  public void windowHandle()
  {
	  String homePage=driver.getWindowHandle();
	  Set<String> handles = driver.getWindowHandles();
	  System.out.println(handles);
	  for(String currhandle: driver.getWindowHandles())
	  {
		  driver.switchTo().window(currhandle);
		  driver.close();
	  }
	  
	  // do something here in newly opened window
	  
	  driver.switchTo().window(homePage);
	  
	  // driver is back to previous window.
  }
  @BeforeTest
  public void beforeTest() {
	  //System.setProperty("webdriver.gecko.driver", "E:\\OFFICE WORK\\Automation\\drivers\\geckodriver.exe");
	  //driver = new FirefoxDriver();
	  System.setProperty("webdriver.chrome.driver", "E:\\OFFICE WORK\\Automation\\drivers\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  Cookie cookie1 = new Cookie("shippingCountry", "US", ".macys.com");
	  driver.manage().addCookie(cookie1);
	  
	  driver.get("http://www1.macys.com/");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  if(driver.manage().getCookieNamed("shippingCountry").getValue().contentEquals("IN"))
	  {
	  driver.findElement(By.id("closeButton")).click();
	  driver.findElement(By.id("href_changeCountry")).click();
	  }
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
