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
 * Test Case 02 Verify that an existing user can successfully login using valid
 * email and password credentials.
 */
public class Test02_LoginUserWithCorrect extends BaseTest {

	@Test(priority = 2)
	@Epic("User Management")
	@Feature("User Login")
	@Story("Valid user login with correct credentials")
	@Description("Verify that an existing user can login successfully with correct credentials")
	@Severity(SeverityLevel.CRITICAL)
	public void testLoginUserWithCorrect() {

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

		// Verify that the Login page is displayed
		Assert.assertTrue(loginPage.isLoginToYourAccountVisible().contains(Constants.LOGIN_TO_YOUR_ACCOUNT),
				"'Login to your account' Text isn't Visible!");

		// Login using the registered user's credentials
		loginPage.enterEmailAndPassword(userEmail, userPassword);

		loginPage.clickLoginBtn();

		// Verify that the user is successfully logged in
		Assert.assertTrue(homePage.isLoggedInDisplayed().contains(Constants.LOGGED_IN_AS),
				"'Logged in as Username' isn't visible!");

		// Delete the created account as part of test cleanup
		deleteUser();

	}
}