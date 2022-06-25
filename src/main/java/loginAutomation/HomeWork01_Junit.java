package loginAutomation;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork01_Junit {

	/*
	 * Automate the following test case: Scenario: Users will be able to add deposit
	 * 1: Open Browser and go to site http://www.techfios.com/billing/?ng=admin/ 2.
	 * Enter username: demo@techfios.com 3. Enter password: abc123 4. Click login
	 * button 5. Click on Bank & Cash button 6. Click on New Account button 7. Fill
	 * out the Add New Account form 8. Click on submit button 9. Visually check if
	 * the account has been created Visually check to make sure the deposit posted
	 */

	WebDriver driver;

	@Before
	public void init() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // ? instructor will explain this line
		Thread.sleep(3000);
	}

	@Test
	public void loginTest() throws InterruptedException {
		driver.get("http://www.techfios.com/billing/?ng=admin/\r\n");
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();

		driver.findElement(By.partialLinkText("Bank & Cash")).click();
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("New Account")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("account")).sendKeys("Checking Checking Checking Account");
		driver.findElement(By.id("description")).sendKeys("Checking!");
		driver.findElement(By.id("balance")).sendKeys("$1500");
		driver.findElement(By.id("account_number")).sendKeys("010101010123");
		driver.findElement(By.id("contact_phone")).sendKeys("123-456-1848");
		driver.findElement(By.id("ib_url")).sendKeys("www.techfios.com");
		driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[2]/form/button")).submit();
		Thread.sleep(3000);
	}

	// @After
	public void tearDown() {
		driver.close();
	}

}
