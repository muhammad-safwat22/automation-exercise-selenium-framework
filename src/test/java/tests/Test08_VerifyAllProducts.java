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
 * Test Case 08 Verify that the user can view all products, open a product
 * details page, and validate the displayed product information.
 */
public class Test08_VerifyAllProducts extends BaseTest {

	@Test(priority = 8)
	@Epic("Product Management")
	@Feature("Products Browsing")
	@Story("View all products and product details")
	@Description("Verify user can access all products and view product details correctly")
	@Severity(SeverityLevel.CRITICAL)
	public void testVerifyAllProducts() throws InterruptedException {

		// Navigate to the Products page
		homePage.clickProductsBtn();

		// Verify that the All Products page is displayed
		Assert.assertTrue(allProductsPage.isAllProductsVisible().contains(Constants.ALL_PRODUCTS),
				"'ALL PRODUCTS' title isn't visible!");

		// Verify that the products list is displayed
		Assert.assertTrue(allProductsPage.isProductsListVisible().contains(Constants.ALL_PRODUCTS),
				"Products list should be visible!");

		// Open the details page of the first product
		allProductsPage.clickFirstProductView();

		// Verify that the product name is displayed
		Assert.assertTrue(productDetailPage.isProductNameVisible().contains(Constants.BLUE_TOP),
				"Product Name isn't visible!");

		// Verify that the product category is displayed
		Assert.assertTrue(productDetailPage.isCategoryVisible().contains(Constants.CATEGORY),
				"Category isn't visible!");

		// Verify that the product price is displayed
		Assert.assertTrue(productDetailPage.isPriceVisible().trim().contains(Constants.PRODUCT_PRICE),
				"Price isn't visible or incorrect!");

		// Verify that the product availability is displayed
		Assert.assertTrue(productDetailPage.isAvailabilityVisible().contains(Constants.AVAILABILITY),
				"Availability info isn't visible!");

		// Verify that the product condition is displayed
		Assert.assertTrue(productDetailPage.isConditionVisible().contains(Constants.CONDITION),
				"Condition info isn't visible!");

		// Verify that the product brand is displayed
		Assert.assertTrue(productDetailPage.isBrandVisible().contains(Constants.BRAND), "Brand info isn't visible!");

	}
}