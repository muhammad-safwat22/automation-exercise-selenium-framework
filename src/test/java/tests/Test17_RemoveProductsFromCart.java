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
 * Test Case 17 Verify that a user can add multiple products to the cart, remove
 * one product, and confirm that the remaining product is still displayed in the
 * shopping cart.
 */
public class Test17_RemoveProductsFromCart extends BaseTest {

	@Test(priority = 17)
	@Epic("Checkout Flow")
	@Feature("Cart Management")
	@Story("Add products and remove one from cart")
	@Description("Verify that a user can add products to cart and remove a product successfully")
	@Severity(SeverityLevel.CRITICAL)
	public void testRemoveProductsFromCart() {

		// Retrieve the expected remaining product from the JSON test data
		JsonObject products = testData.getAsJsonObject("products");
		String firstProduct = products.get("firstProduct").getAsString();

		// Add the first product to the shopping cart
		homePage.hoverAndClickAddFirstProduct();

		// Continue shopping and add the second product
		homePage.clickContinueShoppingBtn();
		homePage.hoverAndClickAddSecondProduct();
		homePage.clickContinueShoppingBtn();

		// Navigate to the Cart page
		homePage.clickCartBtn();

		// Verify that the Shopping Cart page is displayed
		Assert.assertTrue(cartPage.isShoppingCartMsgVisible().contains(Constants.SHOPPING_CART),
				"'Shopping Cart' Should Be Visible!");

		// Remove one product from the shopping cart
		viewCartPage.clickRemoveProductBtn();

		// Verify that the cart still contains products
		Assert.assertTrue(viewCartPage.areCartProductsVisible(), Constants.CART_PRODUCT_NOT_VISIBLE);

		// Verify that the expected product remains in the shopping cart
		Assert.assertTrue(viewCartPage.areeCartProductsVisible().contains(firstProduct),
				"Remaining product not Visible! Expected: " + firstProduct);

	}
}