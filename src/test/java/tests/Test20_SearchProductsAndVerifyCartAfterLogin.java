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
 * Test Case 20 Verify that a user can search for a product, add it to the cart,
 * login, and confirm that the product remains in the shopping cart.
 */
public class Test20_SearchProductsAndVerifyCartAfterLogin extends BaseTest {

	@Test(priority = 20)
	@Epic("Product Management")
	@Feature("Search and Cart")
	@Story("Search product, add to cart, and verify after login")
	@Description("Verify that a user can search for a product, add it to cart, and see it after login")
	@Severity(SeverityLevel.CRITICAL)
	public void testSearchProductsAndVerifyCartAfterLogin() throws InterruptedException {

		// Retrieve user credentials and product data from the JSON test data
		JsonObject user = testData.getAsJsonObject("users").getAsJsonObject("validUser");
		JsonObject products = testData.getAsJsonObject("products").getAsJsonObject("quantityVerification");
		String productName = products.get("productName").getAsString();
		String poloName = products.get("productNameWithPoloName").getAsString();
		String userEmail = user.get("email").getAsString();
		String userPassword = user.get("password").getAsString();

		// Navigate to the Products page
		homePage.clickProductsBtn();

		// Verify that the All Products page is displayed
		Assert.assertTrue(allProductsPage.isAllProductsVisible().contains(Constants.ALL_PRODUCTS),
				"User Should Be on 'ALL PRODUCTS' Page!");

		// Search for the required product
		allProductsPage.searchforProduct(productName);

		// Verify that the search results are displayed
		Assert.assertTrue(allProductsPage.isSearchedProductsTitleVisible().contains(Constants.SEARCHED_PRODUCTS),
				"'SEARCHED PRODUCTS' Should Be Visible!");

		// Verify that the expected product appears in the search results
		Assert.assertTrue(allProductsPage.areSearchedProductListVisible().contains(poloName),
				"Searched Products Should Be Visible!");

		// Add the searched product to the shopping cart
		allProductsPage.hoverAndClickAddFirstPoloProduct();
		allProductsPage.clickContinueShoppingBtn();

		// Navigate to the Cart page
		homePage.clickCartBtn();

		// Verify that the product is available in the cart before login
		Assert.assertTrue(viewCartPage.areCartProductsAfterRemoveVisible().contains(productName),
				"Cart Products not Visible!");

		// Register a new user account
		openSignupPage();

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

		// Navigate back to the Cart page
		homePage.clickCartBtn();

		// Verify that the product remains in the cart after login
		Assert.assertTrue(viewCartPage.areCartProductsAfterRemoveVisible().contains(productName),
				"Cart Products not Visible!");

		// Delete the created account as part of test cleanup
		deleteUser();

	}
}