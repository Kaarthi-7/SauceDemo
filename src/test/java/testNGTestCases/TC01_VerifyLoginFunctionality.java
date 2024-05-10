package testNGTestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import factory.BaseClass;
import pageObjects.LoginPage;
import utilities.ExcelUtilities;
import utilities.InputDataValues;

public class TC01_VerifyLoginFunctionality extends Setup{

	@Test(priority = 1)
	public void user_is_on_shoppers_stop_com_website() throws IOException {
		System.out.println(BaseClass.getDriver().getTitle());
		if(BaseClass.getDriver().getTitle().equals("Swag Labs")) {
			System.out.println("Correct website is Launched");
			BaseClass.getLogger().info("----Correct Website Launched Successfully----");
			ExcelUtilities.write("TestNG", 1, "Correct Website Launched Successfully");
		} else {
			System.out.println("Incorrect Website is Launched");
			BaseClass.getLogger().info("----incorrect website launched----");
			System.exit(0);
			BaseClass.getDriver().quit();
		}
	}
	
	@Test(priority = 2)
	public void verifying_the_logo_of_webpage() throws IOException {
		LoginPage LP = new LoginPage(BaseClass.getDriver());
		if(LP.pageLogo()==true) {
			System.out.println("SauceDemo Logo is Displayed");
			BaseClass.getLogger().info("----SauceDemo Logo is Displayed----");
			ExcelUtilities.write("TestNG", 2, "SauceDemo Logo is Displayed");
		} else {
			System.out.println("SauceDemo logo is not Displayed");
		}
	}
	
	@Test(priority = 3)
	public void loginUsingInvalidCredential() throws IOException {
		LoginPage LP = new LoginPage(BaseClass.getDriver());
		InputDataValues IDV = new InputDataValues();
		LP.username(IDV.getInvalidUsername());
		LP.password(IDV.getPassword());
		LP.login();
		System.out.println(LP.errorMsg());
		System.out.println("captured error while logging in using the invalid credential");
		BaseClass.getLogger().info("----captured error while logging in using the invalid credential----");
		ExcelUtilities.write("TestNG", 3, "captured error while logging in using the invalid credential");
	}
	
	@Test(priority = 4)
	public void loginUsingValidCredential() throws IOException {
		BaseClass.getDriver().navigate().refresh();
		LoginPage LP = new LoginPage(BaseClass.getDriver());
		InputDataValues IDV = new InputDataValues();
		LP.username(IDV.getValidUsername());
		LP.password(IDV.getPassword());
		LP.login();
		System.out.println("logging in using the valid credential");
		BaseClass.getLogger().info("----logging in using the valid credential----");
		ExcelUtilities.write("TestNG", 4, "logging in using the valid credential");
	}
}
