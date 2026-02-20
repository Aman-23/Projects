package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[name='username']")
	WebElement username;
	
	@FindBy(css = "[name='password']")
	WebElement password;
	
	@FindBy(css = ".orangehrm-login-button")
	WebElement loginButton;
	
	@FindBy(css = ".orangehrm-login-forgot p")
	WebElement fogetPasswordButton;
	
	public void login(String username, String password) {
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		loginButton.click();
	}
	
	public WebElement loginButton() {
		return loginButton;
	}
	
	public WebElement forgetPasswordButton() {
		return fogetPasswordButton;
	}

}
