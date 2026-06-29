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
 * Test Case 14 Verify that a user can register during the checkout process,
 * complete the order successfully, and delete the created account.
 */
public class Test14_RegisterWhileCheckout extends BaseTest {

	@Test(priority = 14)
	@Epic("Checkout Flow")
	@Feature("Register During Checkout")
	@Story("User registers during checkout and places order")
	@Description("Verify that a user can register during checkout, complete the order, and delete the account")
	@Severity(SeverityLevel.CRITICAL)
	public void testRegisterWhileCheckout() {

		// Retrieve valid user credentials from the JSON test data
		JsonObject user = testData.getAsJsonObject("users").getAsJsonObject("validUser");
		String userEmail = user.get("email").getAsString();
		String userPassword = user.get("password").getAsString();

		// Add two products to the shopping cart
		homePage.hoverAndClickAddFirstProduct();
		homePage.clickContinueShoppingBtn();
		homePage.hoverAndClickAddSecondProduct();
		homePage.clickContinueShoppingBtn();
		homePage.clickCartBtn();

		// Verify that the Shopping Cart page is displayed
		Assert.assertTrue(cartPage.isShoppingCartMsgVisible().contains(Constants.SHOPPING_CART),
				"'Shopping Cart' Should Be Visible!");

		// Proceed to checkout and navigate to the Login/Register page
		cartPage.clickProceedToCheckout();
		cartPage.clickCheckoutRegisterLoginBtn();

		// Attempt to login with the existing user credentials
		loginPage.enterEmailAndPassword(userEmail, userPassword);
		loginPage.clickLoginBtn();

		// Delete the existing account to prepare for a new registration
		deleteUser();

		// Register a new user account
		openSignupPage();

		completeRegistration();

		// Return to the shopping cart
		homePage.clickCartBtn();

		// Complete the checkout process and place the order
		proceedToCheckout();

		// Delete the newly created account
		deleteUser();

	}
}