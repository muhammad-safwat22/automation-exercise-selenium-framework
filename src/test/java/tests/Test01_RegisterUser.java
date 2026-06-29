package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

/**
 * Test Case 01 Verify that a new user can successfully register and then delete
 * the created account.
 */
public class Test01_RegisterUser extends BaseTest {

	@Test(priority = 1)
	@Epic("User Management")
	@Feature("User Registration")
	@Story("Register and delete a user account")
	@Description("Verify that a new user can successfully register and then delete the account")
	@Severity(SeverityLevel.CRITICAL)
	public void testRegisterUserFlow() {

		// ==========================================
		// Test Data
		// ==========================================

		// Navigate to the Signup/Login page
		openSignupPage();

		// Complete the registration process with valid user data
		completeRegistration();

		// Delete the newly created account and verify successful deletion
		deleteUser();
	}
}