package stepDefination;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Hooks {
	
	public static final int IMPLICIT_WAIT = 5;
	protected static WebDriver driver;

	

	@After
	public static void tearDownAfterClass() throws Exception {
		//driver.quit();
	}

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "resources//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.navigate().to("https://d3sy4dht7a7sfd.cloudfront.net/");
	}
	
	public WebDriver getDriver() {
		return driver;
	}


}
