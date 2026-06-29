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
 * Test Case 07 Verify that the user can navigate to the Test Cases page and
 * view the page title.
 */
public class Test07_VerifyTestCasesPage extends BaseTest {

	@Test(priority = 7)
	@Epic("Navigation")
	@Feature("Test Cases")
	@Story("Navigate to Test Cases Page")
	@Description("Verify user can access Test Cases page and see correct title")
	@Severity(SeverityLevel.NORMAL)
	public void testVerifyTestCasesPage() {

		// Navigate to the Test Cases page
		homePage.clickTestCaseBtn();

		// Verify that the Test Cases page title is displayed
		Assert.assertTrue(testCasePage.isTitleTestCaseVisible().contains(Constants.TEST_CASES),
				"'TEST CASES' title isn't visible!");

	}
}