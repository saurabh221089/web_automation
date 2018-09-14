import java.awt.SecondaryLoop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.bcel.generic.AALOAD;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import macys_framework.ExcelSheetReader;

/* Created by CY4N0G3N
21-Apr-2015 1:37:09 PM
 */

public class jExcelReadLogin {

	static WebDriver driver;
	public Sheet sh;
	public Workbook wb;

	public void readExcelFile(String path, String sheetname) throws BiffException, IOException {
		FileInputStream fis = new FileInputStream(path);
		wb = Workbook.getWorkbook(fis);
		sh = wb.getSheet(sheetname);
	}
	
	public static void takeScreenshot(String name) throws IOException {
		File scrnshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrnshot, new File("D:\\OFFICE WORK\\Automation\\previous_build_screenshots\\"+name+".jpg"));
	}


	public static void main(String[] str ) throws BiffException, IOException{
		jExcelReadLogin obj =new jExcelReadLogin();

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://14.141.13.35/orangehrm/symfony/web/index.php/auth/login");

		obj.readExcelFile("D:\\OFFICE WORK\\Automation\\login.xls", "Sheet1");

		int rows = obj.sh.getRows();
		System.out.println(rows);
		
		int cols = obj.sh.getColumns();
		System.out.println(cols);
		for (int i=1; i<rows; i++)
		{
			String []a=new String[cols];
			
			for (int j=0; j<cols; j++)
			{

				a[j]=obj.sh.getCell(j,i).getContents();
				System.out.println(a[j]);
			}
				driver.findElement(By.id("txtUsername")).sendKeys(a[0]);
				driver.findElement(By.id("txtPassword")).sendKeys(a[1]);
				driver.findElement(By.id("btnLogin")).click();
				if (a[2].equalsIgnoreCase("yes"))
				{
					takeScreenshot(a[0]);
				}
				driver.findElement(By.id("welcome")).click();
				driver.findElement(By.xpath("//a[text()='Logout']")).click();

		}
	
		driver.quit();
	}

}
