package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import utilities.Constants;

/**
 * Test Case 23 Verify that the delivery and billing addresses displayed on the
 * Checkout page match the registered user's information.
 */
public class Test23_VerifyAddressDetailsInCheckoutPage extends BaseTest {

	@Test(priority = 23)
	@Epic("Checkout Flow")
	@Feature("Address Verification")
	@Story("Verify delivery and billing addresses in checkout page")
	@Description("Verify that the delivery and billing addresses are displayed correctly for a registered user in the checkout page")
	@Severity(SeverityLevel.CRITICAL)
	public void testVerifyAddressDetailsInCheckoutPage() {

		// Retrieve user address information from the JSON test data
		JsonObject user = testData.getAsJsonObject("users").getAsJsonObject("validUser");
		String fullName = user.get("name").getAsString();
		String title = user.get("title").getAsString();
		String company = user.get("company").getAsString();
		String address1 = user.get("address1").getAsString();
		String address2 = user.get("address2").getAsString();
		String city = user.get("city").getAsString();
		String state = user.get("state").getAsString();
		String zipCode = user.get("zipcode").getAsString();
		String country = user.get("country").getAsString();
		String mobile = user.get("mobile").getAsString();

		// Register a new user account
		completeRegistration();

		// Navigate to the Signup/Login page
		openSignupPage();

		// Add two products to the shopping cart
		homePage.hoverAndClickAddFirstProduct();
		homePage.clickContinueShoppingBtn();
		homePage.hoverAndClickAddSecondProduct();
		homePage.clickContinueShoppingBtn();

		// Navigate to the Cart page
		homePage.clickCartBtn();

		// Verify that the Shopping Cart page is displayed
		Assert.assertTrue(cartPage.isShoppingCartMsgVisible().contains(Constants.SHOPPING_CART),
				"'Shopping Cart' Should Be Visible!");

		// Proceed to the Checkout page
		cartPage.clickProceedToCheckout();

		// Retrieve the displayed delivery and billing addresses
		String deliveryAddress = cartPage.getDeliveryAddressBox();
		String billingAddress = cartPage.getBillingAddressBox();

		// Verify the delivery address details
		Assert.assertTrue(deliveryAddress.contains(title + ". " + fullName), "Delivery Name is Missing!");
		Assert.assertTrue(deliveryAddress.contains(company), "Company Name is Missing!");
		Assert.assertTrue(deliveryAddress.contains(address1), "Address Line 1 is Missing!");
		Assert.assertTrue(deliveryAddress.contains(address2), "Address Line 2 is Missing!");
		Assert.assertTrue(deliveryAddress.contains(city), "City is Missing!");
		Assert.assertTrue(deliveryAddress.contains(state), "State is Missing!");
		Assert.assertTrue(deliveryAddress.contains(zipCode), "Zip Code is Missing!");
		Assert.assertTrue(deliveryAddress.contains(country), "Country is Missing!");
		Assert.assertTrue(deliveryAddress.contains(mobile), "Phone Number is Missing!");

		// Verify the billing address details
		Assert.assertTrue(billingAddress.contains(title + ". " + fullName), "Billing Name is Missing!");
		Assert.assertTrue(billingAddress.contains(company), "Company Name is Missing!");
		Assert.assertTrue(billingAddress.contains(address1), "Address Line 1 is Missing!");
		Assert.assertTrue(billingAddress.contains(address2), "Address Line 2 is Missing!");
		Assert.assertTrue(billingAddress.contains(city), "City is Missing!");
		Assert.assertTrue(billingAddress.contains(state), "State is Missing!");
		Assert.assertTrue(billingAddress.contains(zipCode), "Zip Code is Missing!");
		Assert.assertTrue(billingAddress.contains(country), "Country is Missing!");
		Assert.assertTrue(billingAddress.contains(mobile), "Phone Number is Missing!");

		// Indicate that the address verification has been completed
		System.out.println("Delivery and Billing Address Verification is Done");

		// Delete the created account as part of test cleanup
		deleteUser();

		// Verify that the application returns to the Home page
		homePage.isWordDisplayed();

	}
}