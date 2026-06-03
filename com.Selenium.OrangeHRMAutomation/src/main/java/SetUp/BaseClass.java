package SetUp;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	
	protected WebDriver driver;
	
	public void launchOrangeHRM() {
		this.initDriver();
		driver.get("https://opensource-demo.orangehrmlive.com");
	}
	
	void initDriver() {
		driver = SetUpBrowser.initdriver();
	}

}
