package Utilities;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClickOn {

	    private static WebDriver driver;

	    public ClickOn(WebDriver driver) {
	        this.driver = driver;
	    }

	    // Normal click with wait
	    public static void click(WebElement element) {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            wait.until(ExpectedConditions.elementToBeClickable(element));
	            element.click();
	        } catch (Exception e) {
	            System.out.println("Normal click failed. Trying JS click.");
	            clickUsingJAVAScript(element);
	        }
	    }

	    // JavaScript click fallback
	    public static void clickUsingJAVAScript(WebElement element) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();", element);
	    }

}
