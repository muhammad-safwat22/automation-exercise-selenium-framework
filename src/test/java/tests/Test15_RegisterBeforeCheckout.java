package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import utilities.Constants;

/**
 * Test Case 15 Verify that a user can register before the checkout process,
 * complete the order successfully, and delete the created account.
 */
public class Test15_RegisterBeforeCheckout extends BaseTest {

	@Test(priority = 15)
	@Epic("Checkout Flow")
	@Feature("Register Before Checkout")
	@Story("User registers before checkout and places order")
	@Description("Verify that a user can register before checkout, complete the order, and delete the account")
	@Severity(SeverityLevel.CRITICAL)
	public void testRegisterBeforeCheckout() {

		// Navigate to the Signup/Login page
		openSignupPage();

		// Register a new user account
		completeRegistration();

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