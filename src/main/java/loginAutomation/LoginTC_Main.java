package loginAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTC_Main {
	
	static WebDriver driver;  // to call these methods from the main method, we need to change them to static. 
							//Then we need to make the driver variable static too.

	public static void main(String[] args) throws InterruptedException {
		
		init();
		loginTest();
		tearDown();
		
		init();
		negLoginTest();
		tearDown();
			
	}
	
	public static void init() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	public static void loginTest() {
		driver.get("http://www.techfios.com/billing/?ng=admin/\r\n");
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
	}
	
	public static void negLoginTest() throws InterruptedException {
		driver.get("http://www.techfios.com/billing/?ng=admin/\r\n");
		driver.findElement(By.id("username")).sendKeys("demos@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc1237979");
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
	}
	public static void tearDown() {
		driver.close();
	}
	
	
}

