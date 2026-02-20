package SetUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class SetUpBrowser {
	
	public static WebDriver driver;
	
	public static final WebDriver initdriver() {
		
	//	System.setProperty("webDriver.chrome.driver", "/com.Selenium.Practice/src/main/resources/driver/chromedriver");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions().addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		return driver;
	}

}
