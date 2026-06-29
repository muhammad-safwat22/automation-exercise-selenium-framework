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
 * Test Case 16 Verify that a user can login before the checkout process, add
 * products to the cart, complete the order successfully, and delete the created
 * account.
 */
public class Test16_LoginBeforeCheckout extends BaseTest {

	@Test(priority = 16)
	@Epic("Checkout Flow")
	@Feature("Login Before Checkout")
	@Story("User logs in before checkout, adds products, and completes order")
	@Description("Verify that a user can login, add products to cart, place an order, and delete the account")
	@Severity(SeverityLevel.CRITICAL)
	public void testLoginBeforeCheckout() {

		// Retrieve valid user credentials from the JSON test data
		JsonObject user = testData.getAsJsonObject("users").getAsJsonObject("validUser");
		String userEmail = user.get("email").getAsString();
		String userPassword = user.get("password").getAsString();

		// Navigate to the Signup/Login page
		openSignupPage();

		// Register a new user account
		completeRegistration();

		// Logout to verify the login functionality
		homePage.clickLogoutAccount();

		// Verify that the Login page is displayed
		Assert.assertTrue(loginPage.isLoginToYourAccountVisible().contains(Constants.LOGIN_TO_YOUR_ACCOUNT),
				"'Login to your account' Text isn't Visible!");

		// Login using the registered user's credentials
		loginPage.enterEmailAndPassword(userEmail, userPassword);
		loginPage.clickLoginBtn();

		// Verify that the user is successfully logged in
		Assert.assertTrue(homePage.isLoggedInDisplayed().contains(Constants.LOGGED_IN_AS),
				"'Logged in as Username' isn't visible!");

		// Add two products to the shopping cart
		homePage.hoverAndClickAddFirstProduct();
		homePage.clickContinueShoppingBtn();
		homePage.hoverAndClickAddSecondProduct();
		homePage.clickContinueShoppingBtn();
		homePage.clickCartBtn();

		// Verify that the Shopping Cart page is displayed
		Assert.assertTrue(cartPage.isShoppingCartMsgVisible().contains(Constants.SHOPPING_CART),
				"'Shopping Cart' Should Be Visible!");

		// Complete the checkout process and place the order
		proceedToCheckout();

		// Delete the created account as part of test cleanup
		deleteUser();

	}
}