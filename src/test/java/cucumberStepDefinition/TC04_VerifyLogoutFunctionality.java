package cucumberStepDefinition;

import java.io.IOException;

import factory.BaseClass;
import io.cucumber.java.en.When;
import pageObjects.ProductPage;
import utilities.ExcelUtilities;

public class TC04_VerifyLogoutFunctionality{

	@When("logging out the website")
	public void logout() throws IOException {
		ProductPage PP = new ProductPage(BaseClass.getDriver());
		PP.menu();
		PP.logout();	
		System.out.println("Logged out Successfully");
		BaseClass.getLogger().info("----Logged out Successfully----");
		ExcelUtilities.write("Cucumber", 13, "Logged out Successfully");	
	}
}
