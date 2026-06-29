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
 * Test Case 25 Verify that clicking the Scroll Up arrow returns the user to the
 * top of the Home page.
 */
public class Test25_VerifyScrollUpUsingArrow extends BaseTest {

	@Test(priority = 25)
	@Epic("UI Functionality")
	@Feature("Scroll Feature")
	@Story("Verify Scroll Up Using Arrow Button")
	@Description("Ensure that clicking the arrow button scrolls the page back to top")
	@Severity(SeverityLevel.CRITICAL)
	public void testVerifyScrollUpUsingArrow() {

		// Scroll down to the footer section
		homePage.scrollToFooter();

		// Verify that the Subscription section is displayed
		homePage.isSubscriptionTitleVisible();

		// Click the Scroll Up arrow and verify that the page returns to the top
		Assert.assertTrue(homePage.clickArrowToUpBtn().contains(Constants.FULL_FLEDGED), "Not Scrolled Up!");

	}
}