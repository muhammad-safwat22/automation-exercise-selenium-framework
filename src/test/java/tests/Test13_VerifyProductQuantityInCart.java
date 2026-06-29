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

/**
 * Test Case 13 Verify that the user can add a product with a specific quantity
 * and view the correct quantity in the shopping cart.
 */
public class Test13_VerifyProductQuantityInCart extends BaseTest {

	@Test(priority = 13)
	@Epic("Shopping Cart")
	@Feature("Product Quantity")
	@Story("Verify product quantity in cart")
	@Description("Verify that user can add a product with a specific quantity and see it in the cart")
	@Severity(SeverityLevel.CRITICAL)
	public void testVerifyProductQuantityInCart() {

		// Retrieve product quantity data from the JSON test data
		JsonObject quantityVerification = testData.getAsJsonObject("products").getAsJsonObject("quantityVerification");
		String productName = quantityVerification.get("productNameWithPoloName").getAsString();
		String quantity = quantityVerification.get("quantity").getAsString();

		// Navigate to the Product Details page
		homePage.clickViewProductBtnInHomePage();

		// Verify that the Product Details page is displayed
		Assert.assertTrue(productDetailPage.isProductDetailVisible().contains(productName),
				"Product Detail not Visible!");

		// Set the desired product quantity
		productDetailPage.setProductQuantity(quantity);

		// Add the product to the shopping cart
		productDetailPage.clickAddToCartBtn();

		// Navigate to the Cart page
		productDetailPage.clickViewCartBtn();

		// Verify that the selected quantity is displayed correctly in the cart
		Assert.assertTrue(viewCartPage.isProductQuantityCorrect(quantity), "Quantity in Cart isn't Correct!");

	}
}