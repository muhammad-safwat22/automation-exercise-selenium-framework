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
 * Test Case 19 Verify that the user can browse products by brand and view the
 * corresponding brand-specific product listings.
 */
public class Test19_ViewAndCartBrandProducts extends BaseTest {

	@Test(priority = 19)
	@Epic("Product Management")
	@Feature("Brand Products")
	@Story("View and add brand products to cart")
	@Description("Verify that brand products can be viewed and added to cart")
	@Severity(SeverityLevel.CRITICAL)
	public void testViewAndCartBrandProducts() throws InterruptedException {

		// Retrieve brand data from the JSON test data
		JsonObject brands = testData.getAsJsonObject("brands");
		String brandTitle = brands.get("title").getAsString();
		String poloBrand = brands.get("titleOnly").getAsString();
		String kookieKidsBrand = brands.get("titleOnly").getAsString();

		// Navigate to the Products page
		homePage.clickProductsBtn();

		// Verify that the Brands section is displayed
		Assert.assertTrue(allProductsPage.isBrandsListVisible().contains(brandTitle), "'BRANDS' List isn't Visible!");

		// Open the POLO brand products page
		allProductsPage.clickPoloBtn();

		// Verify that the POLO brand products are displayed
		Assert.assertTrue(allProductsPage.isBrandPoloProductsVisible().contains(poloBrand),
				"'BRAND - POLO PRODUCTS' isn't Visible!");

		// Open the Kookie Kids brand products page
		allProductsPage.clickKookieKidsBtn();

		// Verify that the Kookie Kids brand products are displayed
		Assert.assertTrue(allProductsPage.isBrandKookieKidsProductsVisible().contains(kookieKidsBrand),
				"'Brand - Kookie Kids Products' isn't Visible!");

	}
}