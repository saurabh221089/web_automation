/* Created by CY4N0G3N
05-Oct-2015 5:22:16 PM
 */
package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Command;

public class AutoDownload {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://messenger.yahoo.com/");
		WebElement download_button = driver.findElement(By.id("messenger-download"));
		String fileLocation = download_button.getAttribute("href");
		System.out.println(fileLocation);
		String wget_command = "cmd /c wget -P D: --no-check-certificate "+fileLocation;
		
		try {
			Process execute = Runtime.getRuntime().exec(wget_command);
			int exitVal = execute.waitFor();
			System.out.println("Exit value : "+exitVal);
			System.out.println("File downloaded...");
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.close();
	}

}
