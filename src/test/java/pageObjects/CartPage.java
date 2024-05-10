package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
	WebDriver Driver;
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//button[@class='btn btn_secondary btn_small cart_button']")
	WebElement removeProduct;
	
	@FindBy(id = "checkout")
	WebElement Checkout;
	
	@FindBy(id = "continue-shopping")
	WebElement ContShopping;
	
	@FindBy(xpath = "//div[@class='inventory_item_name']")
	WebElement productName;
	
	public void removeProd() {
		removeProduct.click();
	}
	
	public void chechout() {
		Checkout.click();
	}
	
	public void contShopping() {
		ContShopping.click();
	}
	
	public String prodName() {
		return productName.getText();
	}
}
