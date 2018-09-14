package testlink;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;
public class TestLink {
	public static String APIkey="144e4cf4c8bf521378ef43608ee9cf7d";
	public static String url="http://localhost/testlink/lib/api/xmlrpc/v1/xmlrpc.php";

	public void reportResult(String TestProject, String TestPlan, String TestCase, String build, String Notes, String Result) throws TestLinkAPIException{
		TestLinkAPIClient api=new TestLinkAPIClient(APIkey, url);
		api.reportTestCaseResult(TestProject,TestPlan,TestCase,build,Notes,Result);	

	}
	@Test
	public void loginTest() throws TestLinkAPIException{
		TestLink t = new TestLink();
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String testProject="OrangeHRM Project";
		String testPlan="OrangeHRM";
		String testCase="Login with valid credentials";
		String build="OrangeHRM Build";
		String notes=null;
		String result=null;

		driver.get("http://14.141.13.35/orangehrm/symfony/web/index.php/auth/login");
		driver.findElement(By.id("txtUsername")).sendKeys("saurabh.badhwar");
		driver.findElement(By.id("txtPassword")).sendKeys("Gspann123");
		driver.findElement(By.id("btnLogin")).click();
		try{
			driver.findElement(By.id("welcome")).click();
			result=TestLinkAPIResults.TEST_PASSED;
			notes="Successfully executed";
			System.out.println("passed...");
		}
		catch (Exception e) {

			result=TestLinkAPIResults.TEST_FAILED;
			notes="Execution failed";
			System.out.println("failed...");
		}
		finally{
			t.reportResult(testProject,testPlan,testCase,build,notes,result);
			System.out.println("Final block execution");
			driver.quit();
		}

	}
}
