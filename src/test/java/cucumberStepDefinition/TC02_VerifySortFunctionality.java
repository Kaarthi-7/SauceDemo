package cucumberStepDefinition;

import java.io.IOException;
import java.util.List;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import pageObjects.ProductPage;
import utilities.ExcelUtilities;
import utilities.InputDataValues;

public class TC02_VerifySortFunctionality{

	int count = 0;
	
	@Then("Selecting method of sorting")
	public void MethodOfSort() throws IOException {
		ProductPage PP = new ProductPage(BaseClass.getDriver());
		InputDataValues IDV = new InputDataValues();
		PP.filter(IDV.getSortingMethod());
		System.out.println("selected the sorting method successfully");
		BaseClass.getLogger().info("----selected the sorting method successfully----");
		ExcelUtilities.write("Cucumber", 5, "selected the sorting method successfully");
	}
	
	@Then("verify sort functionality")
	public void verifySort() throws IOException {
		ProductPage PP = new ProductPage(BaseClass.getDriver());
		InputDataValues IDV = new InputDataValues();
		List<String> prodName = PP.productName();
		List<String> prodPrice = PP.productPrice();
		switch (IDV.getSortingMethod()){
			case "Name (A to Z)":
				
				for(int i=0; i<prodName.size()-1; i++) {
				int prod1 = (int)prodName.get(i).toLowerCase().charAt(0);
				int prod2 = (int)prodName.get(i+1).toLowerCase().charAt(0);
					if(prod1<prod2) {
						count++;
					}
				}
				if(count==5) {
					System.out.println("sort Successful");
				}else {
					System.out.println("Sort Unsuccessful");
				}
				break;
			case "Name (Z to A)":
				for(int i=0; i<prodName.size()-1; i++) {
				int prod1 = (int)prodName.get(i).toLowerCase().charAt(0);
				int prod2 = (int)prodName.get(i+1).toLowerCase().charAt(0);
				System.out.println(prod2 + " " + prod2);
					if(prod1>prod2) {
						count++;
						System.out.println(count);
					}
				}
				System.out.println(count);
				if(count==5) {
					System.out.println("sort Successful");
				}else {
					System.out.println("Sort Unsuccessful");
				}
				break;
			case "Price (low to high)":
				for(int i=0; i<prodPrice.size()-1; i++) {
					String product1 = prodPrice.get(i).replaceAll("[^0-9]","");
					String product2 = prodPrice.get(i+1).replaceAll("[^0-9]","");
					int prod1 = Integer.parseInt(product1);
					int prod2 = Integer.parseInt(product2);
						if(prod1<=prod2) {
							count++;
						}
					}
					if(count==5) {
						System.out.println("sort Successful");
					}else {
						System.out.println("Sort Unsuccessful");
					}
				break;
			case "Price (high to low)":
				for(int i=0; i<prodPrice.size()-1; i++) {
					String product1 = prodPrice.get(i).replaceAll("^[0-9]","");
					String product2 = prodPrice.get(i+1).replaceAll("^[0-9]","");
					int prod1 = Integer.parseInt(product1);
					int prod2 = Integer.parseInt(product2);
						if(prod1>=prod2) {
							count++;
						}
					}
					if(count==5) {
						System.out.println("sort Successful");
					}else {
						System.out.println("Sort Unsuccessful");
					}
				break;
		}
		System.out.println("verified the sort function successfully");
		BaseClass.getLogger().info("----verified the sort function successfully----");
		ExcelUtilities.write("Cucumber", 6, "verified the sort function successfully");
	}
}
