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
 * Test Case 21 Verify that a user can submit a review for a product
 * successfully.
 */
public class Test21_AddReviewOnProduct extends BaseTest {

	@Test(priority = 21)
	@Epic("Product Management")
	@Feature("Product Reviews")
	@Story("Add review on product")
	@Description("Verify that a user can add a review on a product successfully")
	@Severity(SeverityLevel.CRITICAL)
	public void testAddReviewOnProduct() throws InterruptedException {

		// Retrieve review data from the JSON test data
		JsonObject user = testData.getAsJsonObject("users").getAsJsonObject("validUser");
		String userName = user.get("name").getAsString();
		String userEmail = user.get("email").getAsString();
		String userComment = user.get("comment").getAsString();

		// Navigate to the Products page
		homePage.clickProductsBtn();

		// Verify that the All Products page is displayed
		Assert.assertTrue(allProductsPage.isProductsListVisible().contains(Constants.ALL_PRODUCTS),
				"User Should Be on 'ALL PRODUCTS' Page!");

		// Open the details page of the first product
		allProductsPage.clickFirstProductView();

		// Verify that the Review section is displayed
		Assert.assertTrue(productDetailPage.isWriteYourReviewVisible().contains(Constants.WRITE_YOUR_REVIEW),
				"'WRITE YOUR REVIEW' isn't Visible!");

		// Submit a product review
		productDetailPage.enterNameAndEmailAndReview(userName, userEmail, userComment);

		// Verify that the review submission is successful
		Assert.assertTrue(productDetailPage.isReviewMsgVisible().contains(Constants.THANK_YOU_FOR_REVIEW),
				"'Thank you for your review.' isn't Visible!");

	}
}