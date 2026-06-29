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
 * Test Case 10 Verify that the user can successfully subscribe from the Home
 * page footer.
 */
public class Test10_VerifySubscriptionInHomePage extends BaseTest {

	@Test(priority = 10)
	@Epic("User Management")
	@Feature("Subscription")
	@Story("Subscribe from home page footer")
	@Description("Verify that user can subscribe successfully from home page")
	@Severity(SeverityLevel.CRITICAL)
	public void testVerifySubscriptionInHomePage() {

		// Retrieve subscription data from the JSON test data
		JsonObject subscription = testData.getAsJsonObject("subscription");
		String userEmail = subscription.get("email").getAsString();

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