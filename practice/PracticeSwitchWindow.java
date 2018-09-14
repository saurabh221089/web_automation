/* Created by CY4N0G3N
08-Sep-2015 6:25:37 PM
 */
package practice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PracticeSwitchWindow { 
	 
	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.toolsqa.com/automation-practice-switch-windows/");

        String handle= driver.getWindowHandle();
        
        System.out.println("Parent window : "+handle);

        // Click on the Button "New Message Window"

        driver.findElement(By.xpath("//*[@id='content']/p[3]/button")).click();

        // Store and Print the name of all the windows open	              

        Set handles = driver.getWindowHandles();
        System.out.println(handles);
/*
        // Pass a window handle to the other window by For Each loop

        for (String handle1 : driver.getWindowHandles()) {
        	System.out.println(handle1);
        	driver.switchTo().window(handle1);
        	}
        */
        // Pass a window handle to the other window by Iterator loop

        Iterator 	itr = handles.iterator();
        while(itr.hasNext()) {
           String element = (String) itr.next();
           System.out.println(element);
           driver.switchTo().window(element);
        }
        // Closing Pop Up window

        driver.close();

        // Close Original window

        driver.quit();
	}
}
