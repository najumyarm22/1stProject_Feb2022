package loginAutomation;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTC_Juint {

	WebDriver driver; 
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before Class");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("After Class");
	}
	
	@Before
	public void init() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	@Test
	public void loginTest() {
		driver.get("http://www.techfios.com/billing/?ng=admin/\r\n");
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
	}
	
	@Test
	public void negLoginTest() throws InterruptedException {
		driver.get("http://www.techfios.com/billing/?ng=admin/\r\n");
		driver.findElement(By.id("username")).sendKeys("demos@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc1237979");
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
	}
	
	@After
	public void tearDown() {
		driver.close();
	}

}
