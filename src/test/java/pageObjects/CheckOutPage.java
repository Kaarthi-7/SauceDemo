package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BasePage{
	WebDriver Driver;
	public CheckOutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "first-name")
	WebElement firstName;
	
	@FindBy(id = "last-name")
	WebElement lastName;
	
	@FindBy(id = "postal-code")
	WebElement PostalCode;
	
	@FindBy(id = "continue")
	WebElement ClickonCont;
	
	@FindBy(id = "cancel")
	WebElement Cancel;
	
	@FindBy(id = "finish")
	WebElement finish;
	
	@FindBy(id = "back-to-products")
	WebElement HomePage;
	
	public void firstName(String firstname) {
		firstName.sendKeys(firstname);
	}
	
	public void lastName(String lastname) {
		lastName.sendKeys(lastname);
	}
	
	public void PostalCode(String postalcode) {
		PostalCode.sendKeys(postalcode);
	}
	
	public void checkout() {
		ClickonCont.click();
	}
	
	public void canceling() {
		Cancel.click();
	}
	
	public void finish() {
		finish.click();
	}
	
	public void Homepage() {
		HomePage.click();
	}
}
