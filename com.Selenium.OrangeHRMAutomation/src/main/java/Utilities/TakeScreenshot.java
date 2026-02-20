package Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public final class TakeScreenshot {
	
	public static String SCREENSHOT_FILE_PATH = "/Users/snigdha/Projects_WorkSpace/Projects/com.Selenium.OrangeHRMAutomation/Screenshots";
	static Date date = new Date();
	
	public static void takeScreenshot(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(SCREENSHOT_FILE_PATH+"/screenshot"+date.getTime()+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
