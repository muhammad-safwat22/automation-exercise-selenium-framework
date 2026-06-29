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
 * Test Case 11 Verify that the user can successfully subscribe from the Cart
 * page footer.
 */
public class Test11_VerifySubscriptionInCartPage extends BaseTest {

	@Test(priority = 11)
	@Epic("User Management")
	@Feature("Subscription")
	@Story("Subscribe from cart page footer")
	@Description("Verify that user can successfully subscribe from the cart page")
	@Severity(SeverityLevel.CRITICAL)
	public void testVerifySubscriptionInCartPage() {

		// Retrieve subscription data from the JSON test data
		JsonObject subscription = testData.getAsJsonObject("subscription");
		String userEmail = subscription.get("email").getAsString();

		// Navigate to the Cart page
		homePage.clickCartBtn();

		// Verify that the Shopping Cart page is displayed
		Assert.assertTrue(cartPage.isShoppingCartMsgVisible().contains(Constants.SHOPPING_CART),
				"'Shopping Cart' Should Be Visible!");

		// Scroll down to the footer section
		homePage.scrollToFooter();

		// Verify that the Subscription section is displayed
		Assert.assertTrue(homePage.isSubscriptionTitleVisible().contains(Constants.SUBSCRIPTION),
				"'SUBSCRIPTION' Title isn't Visible!");

		// Enter the email address and subscribe
		homePage.enterEmailAndClick(userEmail);

		// Verify that the subscription is completed successfully
		Assert.assertTrue(homePage.isSuccessSubscriptionMesVisible().toLowerCase().contains(Constants.SUCCESSFULLY),
				"Success Message Not Visible!");

	}
}