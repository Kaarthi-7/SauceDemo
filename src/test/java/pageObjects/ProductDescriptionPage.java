package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDescriptionPage extends BasePage{
	WebDriver Driver;
	public ProductDescriptionPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[@class='inventory_details_name large_size']")
	WebElement productName;
	
	@FindBy(xpath = "//div[@class='inventory_details_price']")
	WebElement productPrice;
	
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	WebElement cart;
	
	@FindBy(id = "remove")
	WebElement remove;
	
	@FindBy(id = "add-to-cart")
	WebElement addToCart;
	
	public String productName() {
		return productName.getText();
	}
	
	public String productPrice() {
		return productPrice.getText();
	}
	
	public void remove() {
		remove.click();
	}
	
	public void addToCart() {
		addToCart.click();
	}
	
	public void naviCartinPDP() {
		cart.click();
	}
	
}
