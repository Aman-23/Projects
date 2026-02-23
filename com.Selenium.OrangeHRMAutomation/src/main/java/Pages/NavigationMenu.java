package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ClickOn;

public class NavigationMenu {
	
	static WebDriver driver;
	
	@SuppressWarnings("static-access")
	NavigationMenu(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	private static final String menuItems = "//span[contains(@class,'oxd-text oxd-text--span') and text()=\"%\"]";
	
	@FindBy(css = ".input.oxd-input--active")
	static WebElement searchBar;
	
	@FindBy(css = "button.oxd-main-menu-button")
	static WebElement mainMenuArrowButton;
	
	public static void clickOnMenuItem(String menuItem) {
		WebElement element = driver.findElement(By.xpath(menuItems.replace("%", menuItem)));
		ClickOn.click(element);
	}
	
	
}
