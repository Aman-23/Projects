package SetUp;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class BaseClass {
	
	protected WebDriver driver = SetUpBrowser.initdriver();
	
	public void launchOrangeHRM() {
		driver.get("https://opensource-demo.orangehrmlive.com");
		try {
			Thread.sleep(Duration.ofSeconds(10));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
