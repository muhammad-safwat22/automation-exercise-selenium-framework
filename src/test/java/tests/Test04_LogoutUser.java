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
 * Test Case 04 Verify that a registered user can successfully login and logout
 * from the application.
 */
public class Test04_LogoutUser extends BaseTest {

	@Test(priority = 4)
	@Epic("User Management")
	@Feature("User Logout")
	@Story("Valid user logout flow")
	@Description("Verify successful login and logout flow for a user")
	@Severity(SeverityLevel.CRITICAL)
	public void testLogoutUser() {

		// Retrieve valid user credentials from the JSON test data
		JsonObject user = testData.getAsJsonObject("users").getAsJsonObject("validUser");
		String userEmail = user.get("email").getAsString();
		String userPassword = user.get("password").getAsString();

		// Navigate to the Signup/Login page
		openSignupPage();

		// Register a new user account
		completeRegistration();

		// Logout to verify the login functionality
		homePage.clickLogoutAccount();

		// Login using the registered user's credentials
		loginPage.enterEmailAndPassword(userEmail, userPassword);

		loginPage.clickLoginBtn();

		// Verify that the user is successfully logged in
		Assert.assertTrue(homePage.isLoggedInDisplayed().contains(Constants.LOGGED_IN_AS),
				"'Logged in as Username' isn't visible!");

		// Logout from the application
		homePage.clickLogoutAccount();

		// Verify that the user is redirected to the Login page
		Assert.assertTrue(loginPage.isLoginToYourAccountVisible().contains(Constants.LOGIN_TO_YOUR_ACCOUNT),
				"'Login to your account' Text isn't Visible!");

	}
}