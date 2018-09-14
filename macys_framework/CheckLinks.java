/* Created by CY4N0G3N
05-Sep-2014 10:32:49 AM
 */
package macys_framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.Assert.*;

public class CheckLinks {

	public static void main(String[] args) throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www1.macys.com/shop/mens-clothing/mens-jeans?id=11221&edge=hybrid&cm_sp=intl_hdr-_-men-_-11221_jeans&intnl=true");
		/*WebElement close = driver.findElement(By.xpath("//*[@id='tinybox']")).findElement(By.xpath("//*[@id='closeButton']"));
		if (close.isDisplayed())
		{
			close.click();
		}*/
		System.out.println("Products under "+driver.getTitle());
		WebElement product_count = driver.findElement(By.xpath("//*[@id='productCount']"));
		System.out.println("Total Number of Products : "+product_count.getText());
		List<WebElement> items = driver.findElements(By.xpath("//*[@class='productThumbnail']"));
		System.out.println("\nNumber of product on page : "+items.size());
		
		WebElement dd = driver.findElement(By.xpath("//*[@id='ppp']"));
		Select dropdown = new Select(dd);
		String val1 = dd.getAttribute("value");
		assertEquals(Integer.parseInt(val1), items.size());
		/************************************************/
		Thread.sleep(5000);
		//checking total number of options in dropdown
		assertEquals(3, dropdown.getOptions().size());
		//checking that the dropdown is multiple select type
		assertFalse(dropdown.isMultiple(), "Dropdown is Multiple select type.");
		
		/************************************************/
		System.out.println("\nChanging the items to 20");
		dropdown.selectByValue("20");
		Thread.sleep(5000);
		List<WebElement> items2 = driver.findElements(By.xpath("//*[@class='productThumbnail']"));
		System.out.println("Number of product on page : "+items2.size());
		String val2 = dd.getAttribute("value");
		assertEquals(Integer.parseInt(val2), items2.size());
		/***********************************************/
		System.out.println("\nChanging the items to 100");
		dropdown.selectByValue("100");
		Thread.sleep(5000);
		List<WebElement> items3 = driver.findElements(By.xpath("//*[@class='productThumbnail']"));
		System.out.println("Number of product on page : "+items3.size());
		String val3 = dd.getAttribute("value");
		assertEquals(Integer.parseInt(val3), items3.size());
		/***********************************************/
		System.out.println("\nTurning to Next Page");
		WebElement next_button = driver.findElement(By.className("arrowRight"));
		next_button.click();
		
		WebElement curr_page = driver.findElement(By.className("currentPage"));
		System.out.println("Current Page number : "+curr_page.getText());
		Thread.sleep(5000);
		System.out.println("Turning to Previous page");
		WebElement prev_button = driver.findElement(By.className("arrowLeft"));
		prev_button.click();
		System.out.println("Current Page number : "+driver.findElement(By.className("currentPage")).getText());
		
		driver.close();
	}

}
