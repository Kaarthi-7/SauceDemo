Feature: Testing ShoppersStop Website

  Scenario: Verify Login functionality
    Given user is on Saucedemo.com website
    And verifying the logo of webpage
    When Logging using Invalid Credential
    When Logging using valid Credential
    
  Scenario: Verify Sort Functionality
		Then Selecting method of sorting
		Then verify sort functionality
		
	Scenario: Verifying Cart functionality
		When adding product to cart
		Then verifying the product added to cart
		Then remove the product from cart
		Then navigate to product description page
		Then add product to cart in description page
		When clicking on checkout
		
	Scenario: Verifying Logout functionality
		When logging out the website