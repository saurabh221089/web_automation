import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/* Created by CY4N0G3N
12-Sep-2014 9:56:10 AM
 */

public class TotalLinks {
	
	static int count = 0;

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/test/dtattack.php");
		try{
		List<WebElement> we = driver.findElements(By.tagName("a"));
		
		for (WebElement links : we)
		{
			++count;
		}
		System.out.println("Number of links on page : "+count);
		}
		finally{
			driver.close();
		}
	}

}
