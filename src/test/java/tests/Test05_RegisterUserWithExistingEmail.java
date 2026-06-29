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
 * Test Case 05 Verify that a user cannot register with an email address that
 * already exists in the system.
 */
public class Test05_RegisterUserWithExistingEmail extends BaseTest {

	@Test(priority = 5)
	@Epic("User Management")
	@Feature("User Registration")
	@Story("Register with existing email")
	@Description("Verify registration fails with an already registered email")
	@Severity(SeverityLevel.NORMAL)
	public void testRegisterUserWithExistingEmail() {

		// Retrieve an existing user's data from the JSON test data
		JsonObject user = testData.getAsJsonObject("users").getAsJsonObject("validUser");
		String userName = user.get("name").getAsString();
		String userEmail = user.get("email").getAsString();

		// Navigate to the Signup/Login page
		homePage.clickSignupLogin();

		// Verify that the "New User Signup!" section is displayed
		Assert.assertTrue(loginPage.isNewUserSignupVisible().contains(Constants.NEW_USER_SIGNUP),
				"'New User Signup!' text isn't visible!");

		// Enter an existing user's name and email address
		loginPage.enterNameAndEmail(userName, userEmail);

		// Attempt to register using an already registered email
		loginPage.clickSignupBtn();

		// Verify that the appropriate error message is displayed
		Assert.assertTrue(loginPage.isSignupErrorTextVisible().contains(Constants.EMAIL_ALREADY_EXISTS),
				"'Email Address already exist!' Text isn't Visible!");

	}
}