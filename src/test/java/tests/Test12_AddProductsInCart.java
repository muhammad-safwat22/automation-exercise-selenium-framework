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
 * Test Case 12 Verify that the user can add multiple products to the shopping
 * cart and validate their details.
 */
public class Test12_AddProductsInCart extends BaseTest {

	@Test(priority = 12)
	@Epic("Shopping Cart")
	@Feature("Add Products")
	@Story("Add multiple products to cart")
	@Description("Verify that user can add products to cart and view them correctly")
	@Severity(SeverityLevel.CRITICAL)
	public void testAddProductsInCart() throws InterruptedException {

		// Retrieve cart products data from the JSON test data
		JsonObject products = testData.getAsJsonObject("products");
		JsonArray cartProducts = products.getAsJsonArray("cartProducts");
		String firstProduct = cartProducts.get(0).getAsJsonObject().get("name").getAsString();
		String secondProduct = cartProducts.get(1).getAsJsonObject().get("name").getAsString();

		// Navigate to the Products page
		homePage.clickProductsBtn();

		// Add the first product to the shopping cart
		allProductsPage.hoverAndClickAddFirstProduct();

		// Continue shopping to add another product
		allProductsPage.clickContinueShoppingBtn();

		// Add the second product and navigate to the Cart page
		allProductsPage.hoverAndClickAddSecondProduct();
		allProductsPage.clickViewCartBtn();

		// Verify that the cart contains products
		Assert.assertTrue(viewCartPage.areCartProductsVisible(), Constants.CART_PRODUCT_NOT_VISIBLE);

		// Verify that the first product is displayed in the cart
		Assert.assertTrue(viewCartPage.areeCartProductsVisible().contains(firstProduct),
				"Cart First Product not Visible!");

		// Verify that the second product is displayed in the cart
		Assert.assertTrue(viewCartPage.areeCartProductsVisible().contains(secondProduct),
				"Cart Second Product not Visible!");

		// Verify the price, quantity, and total for the cart products
		viewCartPage.verifyProductPriceQuantityTotal();

	}
}