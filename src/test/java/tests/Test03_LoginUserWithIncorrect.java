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
 * Test Case 03 Verify that a user cannot login with invalid credentials and
 * that the appropriate error message is displayed.
 */
public class Test03_LoginUserWithIncorrect extends BaseTest {

	@Test(priority = 3)
	@Epic("User Management")
	@Feature("User Login")
	@Story("Invalid user login with incorrect credentials")
	@Description("Verify that login fails when using incorrect credentials")
	@Severity(SeverityLevel.CRITICAL)
	public void testLoginUserWithIncorrect() {

		// Retrieve invalid user credentials from the JSON test data
		JsonObject user = testData.getAsJsonObject("users").getAsJsonObject("invalidUser");
		String userEmail = user.get("email").getAsString();
		String userPassword = user.get("password").getAsString();

		// Navigate to the Signup/Login page
		homePage.clickSignupLogin();

		// Verify that the Login page is displayed
		Assert.assertTrue(loginPage.isLoginToYourAccountVisible().contains(Constants.LOGIN_TO_YOUR_ACCOUNT),
				"'Login to your account' Text isn't Visible!");

		// Enter invalid login credentials
		loginPage.enterEmailAndPassword(userEmail, userPassword);

		// Attempt to login
		loginPage.clickLoginBtn();

		// Verify that the appropriate login error message is displayed
		Assert.assertTrue(loginPage.isLoginErrorTextVisible().contains(Constants.LOGIN_ERROR),
				"'Your email or password is incorrect!' Text isn't Visible!");

	}
}