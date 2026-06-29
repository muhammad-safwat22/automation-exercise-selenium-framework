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
 * Test Case 09 Verify that the user can search for a product and view the
 * correct search results.
 */
public class Test09_SearchProduct extends BaseTest {

	@Test(priority = 9)
	@Epic("Product Management")
	@Feature("Product Search")
	@Story("Search product and verify results")
	@Description("Verify that user can search for a product and view correct search results")
	@Severity(SeverityLevel.CRITICAL)
	public void testSearchProduct() throws InterruptedException {

		// Retrieve product search data from the JSON test data
		JsonObject products = testData.getAsJsonObject("products");
		String productName = products.get("searchProduct").getAsString();
		JsonObject quantityVerification = products.getAsJsonObject("quantityVerification");
		String productNameWithPoloName = quantityVerification.get("productNameWithPoloName").getAsString();

		// Navigate to the Products page
		homePage.clickProductsBtn();

		// Verify that the All Products page is displayed
		Assert.assertTrue(allProductsPage.isAllProductsVisible().contains(Constants.ALL_PRODUCTS),
				"'ALL PRODUCTS' page title isn't visible!");

		// Search for the specified product
		allProductsPage.searchforProduct(productName);

		// Verify that the Search Results section is displayed
		Assert.assertTrue(allProductsPage.isSearchedProductsTitleVisible().contains(Constants.SEARCHED_PRODUCTS),
				"'SEARCHED PRODUCTS' title isn't visible!");

		// Verify that the expected product appears in the search results
		Assert.assertTrue(allProductsPage.areSearchedProductListVisible().contains(productNameWithPoloName),
				"Expected product '" + productNameWithPoloName + "' should be visible in search results!");

	}
}