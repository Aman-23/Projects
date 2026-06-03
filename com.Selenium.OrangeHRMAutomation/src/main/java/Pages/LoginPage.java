package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Wait;

public class LoginPage {
	
	WebDriver driver;
	Wait wait;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new Wait(driver);
	}
	
	@FindBy(css = "[name='username']")
	WebElement username;
	
	@FindBy(css = "[name='password']")
	WebElement password;
	
	@FindBy(css = ".orangehrm-login-button")
	WebElement loginButton;
	
	@FindBy(css = ".orangehrm-login-forgot p")
	WebElement fogetPasswordButton;
	
	@FindBy(xpath = "//div[contains(@class,'oxd-alert-content--error')]/p")
	WebElement invalidCredentialsErrorMessage;
	
	@FindBy(css = ".oxd-input-field-error-message")
	List<WebElement> emptyCredentialsErrorMessage;
	
	
	public DashboardPage login(String username, String password) {
		
		wait.waitForVisibility(this.username, 10);
		wait.waitForVisibility(this.password, 10);
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		loginButton.click();
		
		return PageFactory.initElements(driver, DashboardPage.class);
	}
	
	public String getInvalidCredentialsErrorMessage() {
		wait.waitForVisibility(invalidCredentialsErrorMessage, 10);
		return invalidCredentialsErrorMessage.getText();
	}
	
	public boolean isRequiredMsgDisplayedUnderInputFields() {
		wait.waitForVisibilityOfAll(emptyCredentialsErrorMessage);
		for(WebElement errorMsg : emptyCredentialsErrorMessage) {
			if(!errorMsg.isDisplayed()) {
				return false;
			}
		}
		return true;
	}
	
	public void clickForgetYouPassword() {
		wait.waitForVisibility(fogetPasswordButton, 10);
		fogetPasswordButton.click();
	}

}
