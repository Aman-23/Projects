package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopNavBar {
	
	WebDriver driver;
	
	public TopNavBar(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".oxd-topbar-header-breadcrumb-module")
	WebElement pageHeading;
	
	@FindBy(css = ".orangehrm-upgrade-button")
	WebElement upgradeButton;
	
	@FindBy(css = "oxd-userdropdown-tab")
	WebElement userDropdownMenu;

}
