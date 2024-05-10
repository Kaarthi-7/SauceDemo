package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	WebDriver Driver;
	public LoginPage(WebDriver driver) {
		super(driver);
	}	
	
	@FindBy(xpath = "//div[@class='login_logo']")
	WebElement SauceDemoLogo;
	
	@FindBy(id = "user-name")
	WebElement UserName;
	
	@FindBy(xpath = "//div[@class='error-message-container error']/h3")
	WebElement Error;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "login-button")
	WebElement Submit;
	
	public boolean pageLogo() {
		return SauceDemoLogo.isDisplayed();
	}
	
	public void username(String userName) {
		UserName.sendKeys(userName);
	}
	
	public void password(String passWord) {
		password.sendKeys(passWord);
	}
	
	public String errorMsg() {
		return Error.getText();
	}
	
	public void login() {
		Submit.click();
	}
}