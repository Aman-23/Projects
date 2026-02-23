package Utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	Wait(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void waitForVisibility(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public WebElement waitForVisibility(WebElement element, int timeout) {
	    WebDriverWait customWait =
	        new WebDriverWait(driver, Duration.ofSeconds(timeout));
	    return customWait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForClickableByLocator(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void waitForClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public WebElement waitForClickable(WebElement element, int timeout) {
	    WebDriverWait customWait =
	        new WebDriverWait(driver, Duration.ofSeconds(timeout));
	    return customWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForVisibilityOfAll(List<WebElement> elements) {
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	
	

}
