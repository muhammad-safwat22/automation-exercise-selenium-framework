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
 * Test Case 26 Verify that the user can scroll back to the top of the Home page
 * without using the Scroll Up arrow.
 */
public class Test26_VerifyScrollUpWithoutArrow extends BaseTest {

	@Test(priority = 26)
	@Epic("UI Navigation")
	@Feature("Scroll Functionality")
	@Story("Verify page scroll up without using the arrow button")
	@Description("Verify that the page scrolls to the top correctly when using direct scroll without clicking the 'Up' arrow button")
	@Severity(SeverityLevel.NORMAL)
	public void testVerifyScrollUpWithoutArrow() {

		// Scroll down to the footer section
		homePage.scrollToFooter();

		// Verify that the Subscription section is displayed
		homePage.isSubscriptionTitleVisible();

		// Scroll directly to the top of the page and verify the Home page content is
		// displayed
		Assert.assertTrue(homePage.scrollToUp().contains(Constants.FULL_FLEDGED), "Not Scrolled Up!");

	}
}