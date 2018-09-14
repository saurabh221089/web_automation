import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/* Created by CY4N0G3N
02-Sep-2014 5:55:57 PM
 */

public class EvaluatingCart {

	public static void main(String[] args) throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.amway.com/Shop/Product/Category.aspx/Body-Care");
		Thread.sleep(3000);
		loop:
		for (int i=0; i<=2; i++)
		{
			WebElement we = driver.findElement(By.xpath("//*[@id='ctl00_PlaceHolderMain_ctl00___ctl02___rptItems_ctl00_ctl00___rptHooks_ctl03_rptObjects_ctl0"+i+"_btnAddToCart']"));
			we.click();
			Thread.sleep(1000);
		if (i==2){
			try {driver.findElement(By.linkText("NEXT")).click();
					Thread.sleep(5000);
					break loop;
				}
			catch(Throwable t)
			{
			System.out.println("Already at last page..");
			}
			
			}
		
		}
		
		String items = driver.findElement(By.xpath("//*[@id='ctl00_ctl08___ctl04___lnkItemsInCart']")).getText();
		System.out.println(items);
		String no_of_items[] = items.split(" ");
		System.out.println("Items Quantity : "+no_of_items[0]);
	}
}
