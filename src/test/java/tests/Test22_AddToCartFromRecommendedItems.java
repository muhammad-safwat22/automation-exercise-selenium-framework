package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonArray;
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
 * Test Case 22 Verify that a user can add a product from the Recommended Items
 * section to the shopping cart.
 */
public class Test22_AddToCartFromRecommendedItems extends BaseTest {

	@Test(priority = 22)
	@Epic("Shopping Cart")
	@Feature("Recommended Items")
	@Story("Add recommended product to cart")
	@Description("Verify that a user can add a product from the recommended items section to the cart successfully")
	@Severity(SeverityLevel.CRITICAL)
	public void testAddToCartFromRecommendedItems() throws InterruptedException {

		// Retrieve the expected recommended product from the JSON test data
		JsonObject products = testData.getAsJsonObject("products");
		JsonArray cartProducts = products.getAsJsonArray("cartProducts");
		String recommendedProduct = cartProducts.get(1).getAsJsonObject().get("name").getAsString();

		// Scroll down to the Recommended Items section
		homePage.ScrollToBottomOfPage();

		// Verify that the Recommended Items section is displayed
		Assert.assertTrue(homePage.isRecommendedItemsVisible().contains(Constants.RECOMMENDED_ITEMS),
				"'RECOMMENDED ITEMS' isn't Visible!");

		// Scroll slightly upward to make the recommended product visible
		homePage.clickArrow();

		// Add the recommended product to the shopping cart
		homePage.clickAddToCartBtnOfBottom();

		// Navigate to the Cart page
		allProductsPage.clickViewCartBtn();

		// Verify that the recommended product is displayed in the shopping cart
		Assert.assertTrue(viewCartPage.isCartProductsAfterAddedFromRecommendedVisible().contains(recommendedProduct),
				"Cart Product not Visible!");

	}
}