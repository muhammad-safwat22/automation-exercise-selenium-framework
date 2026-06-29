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
 * Test Case 18 Verify that the user can browse products by selecting different
 * product categories.
 */
public class Test18_ViewCategoryProducts extends BaseTest {

	@Test(priority = 18)
	@Epic("Product Management")
	@Feature("Category Navigation")
	@Story("View products by category")
	@Description("Verify that user can view products by category (Women Dresses & Men Jeans)")
	@Severity(SeverityLevel.CRITICAL)
	public void testViewCategoryProducts() throws InterruptedException {

		// Retrieve category data from the JSON test data
		JsonObject categories = testData.getAsJsonObject("categories");
		String categoryName = categories.get("categoryGroupName").getAsString();
		String womenDress = categories.get("womenOnly").getAsString();
		String menJeans = categories.get("menOnly").getAsString();

		// Verify that the Categories section is displayed
		Assert.assertTrue(homePage.areCategoriesGroupVisible().contains(categoryName),
				"Categories Group aren't Visible!");

		// Navigate to the Women > Dress category
		homePage.clickWomenBtn();
		homePage.clickDressBtn();

		// Verify that Women's Dress products are displayed
		Assert.assertTrue(allProductsPage.isWomenDressProductsVisible().contains(womenDress),
				"'" + womenDress + "' isn't Visible!");

		// Navigate to the Men > Jeans category
		allProductsPage.clickMenBtn();
		allProductsPage.clickJeansBtn();

		// Verify that Men's Jeans products are displayed
		Assert.assertTrue(allProductsPage.isMenJeansProductsVisible().contains(menJeans),
				"'" + menJeans + "' isn't Visible!");

	}
}