package cucumberStepDefinition;

import java.io.IOException;

import org.junit.Assert;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CartPage;
import pageObjects.CheckOutPage;
import pageObjects.ProductDescriptionPage;
import pageObjects.ProductPage;
import utilities.ExcelUtilities;
import utilities.InputDataValues;

public class TC03_verifyCartFunctionality{

	String prodNameInCartPage;
	String prodNameInProdPage;
	
	@When("adding product to cart")
	public void addProductToCart() throws IOException {
		ProductPage PP = new ProductPage(BaseClass.getDriver());
		prodNameInProdPage = PP.prodName().getText();
		PP.CartAdd();
		PP.navigateCart();
		System.out.println("product added to cart successfully");
		BaseClass.getLogger().info("----product added to cart successfully----");
		ExcelUtilities.write("Cucumber", 7, "product added to cart successfully");
	}
	
	@Then("verifying the product added to cart")
	public void verifyProduct() throws IOException {
		CartPage CP = new CartPage(BaseClass.getDriver());
		prodNameInCartPage = CP.prodName();
		Assert.assertEquals("Product added correctly", prodNameInCartPage, prodNameInProdPage);
		System.out.println("verified the product added to cart successfully");
		BaseClass.getLogger().info("----verified the product added to cart successfully----");
		ExcelUtilities.write("Cucumber", 8, "verified the product added to cart successfully");
	}
	
	@Then("remove the product from cart")
	public void removeProduct() throws IOException {
		CartPage CP = new CartPage(BaseClass.getDriver());
		CP.removeProd();
		CP.contShopping();
		System.out.println("product removed from the cart successfully");
		BaseClass.getLogger().info("----product removed from the cart successfully----");
		ExcelUtilities.write("Cucumber", 9, "product removed from the cart successfully");
	}
	
	@Then("navigate to product description page")
	public void navigateToprodDescPage() throws IOException {
		ProductPage PP = new ProductPage(BaseClass.getDriver());
		PP.prodName().click();
		System.out.println("navigated to product description successfully");
		BaseClass.getLogger().info("----navigated to product description successfully----");
		ExcelUtilities.write("Cucumber", 10, "navigated to product description successfully");
	}
	
	@Then("add product to cart in description page")
	public void addCartinProdDescPage() throws IOException {
		ProductDescriptionPage PDP = new ProductDescriptionPage(BaseClass.getDriver());
		PDP.addToCart();
		PDP.naviCartinPDP();
		System.out.println("product added to cart successfully");
		BaseClass.getLogger().info("----product added to cart successfully----");
		ExcelUtilities.write("Cucumber", 11, "product added to cart successfully");
	}
	
	@When("clicking on checkout")
	public void checkOut() throws IOException {
		InputDataValues IDV = new InputDataValues();
		CartPage CP = new CartPage(BaseClass.getDriver());
		CheckOutPage COP = new CheckOutPage(BaseClass.getDriver());
		CP.chechout();
		COP.firstName(IDV.getFirstname());
		COP.lastName(IDV.getLastname());
		COP.PostalCode(IDV.getPostalcode());
		COP.checkout();
		COP.finish();
		COP.Homepage();
		System.out.println("product checked out successfully");
		BaseClass.getLogger().info("----product checked out successfully----");
		ExcelUtilities.write("Cucumber", 12, "product checked out successfully");
	}
}
