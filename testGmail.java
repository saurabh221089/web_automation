import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

import com.google.protobuf.ByteString.Output;

public class testGmail {
	public static void main(String []args) throws InterruptedException, IOException{
		Properties pro = new Properties();
		File config = new File("config.cfg");
		FileInputStream fis = new FileInputStream(config);
		pro.load(fis);
		String user = pro.getProperty("username");
		String pass = pro.getProperty("password");
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.gmail.com");
		driver.findElement(By.id("Email")).sendKeys(user);
		driver.findElement(By.id("Passwd")).sendKeys(pass);
		driver.findElement(By.id("signIn")).click();
		Thread.sleep(10000);
		
		System.out.println(driver.getTitle());
		
		List<WebElement> mails = driver.findElements(By.className("zE"));
		
		for (WebElement unread : mails)
		{
			unread.click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id=':5']/div[2]/div[1]/div/div[1]/div")).click();
		}
		try {
		File scrnshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrnshot, new File("D:\\OFFICE WORK\\Automation\\gmail.jpg"));
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@class='T-I J-J5-Ji T-I-KE L3']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys("saurabh221089@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Hello world!!");
		Thread.sleep(1000);
		//driver.switchTo().frame(driver.findElement(By.xpath("//div[@id=':qi']//iframe")));
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='Am Al editable']//iframe")));
		driver.findElement(By.xpath("//*[@class='editable LW-avf']")).sendKeys("Automated email sending test :)");
		//driver.findElement(By.cssSelector("editable LW-avf")).sendKeys("Automated email sending test :)");
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='Send']")).click();
        
		/*driver.findElement(By.xpath("//span[contains(text(), \"Saurabh\")]")).click();
		
		List<WebElement> chatlist = driver.findElements(By.xpath("html/body/div[7]/div[3]/div/div[2]/div[1]/div[1]/div[3]/div[1]/div/div[2]/div[5]/div/table/tbody/tr/td[2]/span[1]"));
		
		for (WebElement chat : chatlist)
		{
			String name = chat.getText();
			System.out.println(name);
			if (name.contains("saurabh"))
			{
				chat.click();
			}
			
		}
		
		*/
		
		//driver.findElement(By.xpath("//*[@id='gb_71']")).click();
		//driver.close();
		//driver = null; // Now the driver object is eligible for collection	
		
	}
	/*@AfterTest
	public void kill()
	{
		driver.close();
	}*/
}
