package loginAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork01_Main {
	/*
	 * Automate the following test case: Scenario: Users will be able to add deposit
	 * 1: Open Browser and go to site http://www.techfios.com/billing/?ng=admin/ 2.
	 * Enter username: demo@techfios.com 3. Enter password: abc123 4. Click login
	 * button 5. Click on Bank & Cash button 6. Click on New Account button 7. Fill
	 * out the Add New Account form 8. Click on submit button 9. Visually check if
	 * the account has been created Visually check to make sure the deposit posted
	 */
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		init();
		loginTest();
		tearDown();
		
		
	}

	public static void init() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}

	public static void loginTest() throws InterruptedException {
		driver.get("http://www.techfios.com/billing/?ng=admin/ ");
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
		driver.findElement(By.linkText("Bank & Cash")).click();
		driver.findElement(By.linkText("New Account")).click();
		driver.findElement(By.id("account")).sendKeys("test123456");
		driver.findElement(By.id("description")).sendKeys("jgjghghjgkjg");
		driver.findElement(By.id("balance")).sendKeys("1000");
		driver.findElement(By.id("account_number")).sendKeys("11546589865");
		driver.findElement(By.id("contact_person")).sendKeys("Don");
		driver.findElement(By.id("contact_phone")).sendKeys("4564864621");
		driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[2]/form/button")).click();
		Thread.sleep(3000);

	}

	public static void tearDown() {
		driver.close();
	}

}
