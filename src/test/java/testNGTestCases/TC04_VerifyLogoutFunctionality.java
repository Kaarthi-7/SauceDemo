package testNGTestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import factory.BaseClass;
import pageObjects.ProductPage;
import utilities.ExcelUtilities;

public class TC04_VerifyLogoutFunctionality extends TC03_verifyCartFunctionality{

	@Test(priority = 13)
	public void logout() throws IOException {
		ProductPage PP = new ProductPage(BaseClass.getDriver());
		PP.menu();
		PP.logout();			
		System.out.println("Logged out Successfully");
		BaseClass.getLogger().info("----Logged out Successfully----");
		ExcelUtilities.write("TestNG", 13, "Logged out Successfully");
	}
}
