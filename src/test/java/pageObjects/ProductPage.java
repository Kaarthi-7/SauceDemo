package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends BasePage{
	WebDriver Driver;
	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "shopping_cart_container")
	WebElement cart;
	
	@FindBy(xpath = "//select[@class='product_sort_container']")
	WebElement Filter;
	
	@FindBy(xpath = "//div[@class='inventory_item_name ']")
	List<WebElement> productName;

	@FindBy(xpath = "//div[@class='inventory_item_name ']")
	WebElement SingleproductName;
	
	@FindBy(xpath = "//div[@class='inventory_item_price']")
	List<WebElement> productPrice;
	
	@FindBy(xpath = "//button[@class='btn btn_primary btn_small btn_inventory ']")
	WebElement AddProductToCart;
	
	@FindBy(id = "react-burger-menu-btn")
	WebElement Menu;
	
	@FindBy(id = "logout_sidebar_link")
	WebElement Logout;
	
	@FindBy(xpath = "//span[@class='shopping_cart_badge']")
	WebElement cartCount;
	
	public void navigateCart() {
		cart.click();
	}
	
	public void filter(String SortMethod) {
		Select select = new Select(Filter);
		select.selectByVisibleText(SortMethod);
	}
	
	public WebElement prodName() {
		return SingleproductName;
	}

	
	public List<String> productName(){
		List<String> prodName = new ArrayList<>();
		for(WebElement productname : productName) {
			prodName.add(productname.getText());
		}
		return prodName;
	}
	
	public List<String> productPrice(){
		List<String> prodPrice = new ArrayList<>();
		for(WebElement productprice : productPrice) {
			prodPrice.add(productprice.getText());
		}
		return prodPrice;
	}
	
	public void CartAdd(){
		AddProductToCart.click();
	}
	
	public void menu() {
		Menu.click();
	}
	
	public void logout() {
		Logout.click();
	}
	
	public int cartCount() {
		String count = cartCount.getText();
		return Integer.parseInt(count);
	}
}