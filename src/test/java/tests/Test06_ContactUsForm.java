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
 * Test Case 06 Verify that a user can successfully submit the Contact Us form
 * with a file attachment.
 */
public class Test06_ContactUsForm extends BaseTest {

	@Test(priority = 6)
	@Epic("User Management")
	@Feature("Contact Us")
	@Story("Submit Contact Us form with attachment")
	@Description("Verify user can submit Contact Us form successfully")
	@Severity(SeverityLevel.CRITICAL)
	public void testContactUsForm() {

		// Retrieve Contact Us form data from the JSON test data
		JsonObject contact = testData.getAsJsonObject("contact");
		String userName = contact.get("name").getAsString();
		String userEmail = contact.get("email").getAsString();
		String subjectName = contact.get("subject").getAsString();
		String message = contact.get("message").getAsString();
		String filePath = contact.get("filePath").getAsString();

		// Navigate to the Contact Us page
		homePage.clickContactUsBtn();

		// Verify that the Contact Us page is displayed
		Assert.assertTrue(contactUs.isGetInTouchMsgVisible().contains(Constants.GET_IN_TOUCH),
				"'GET IN TOUCH' Text isn't Visible");

		// Fill in the Contact Us form
		contactUs.fillForm(userName, userEmail, subjectName, message);

		// Upload a file and submit the form
		contactUs.uploadFile(filePath);
		contactUs.clickSubmit();

		// Accept the confirmation alert
		contactUs.acceptAlert();

		// Verify that the success message is displayed
		Assert.assertTrue(contactUsSubmitted.isSuccessMessageDisplayed().contains(Constants.SUCCESS_MESSAGE),
				"Success Message Should Be Displayed!");

		// Return to the Home page
		contactUsSubmitted.clickHomeBtn();

		// Verify successful navigation to the Home page
		Assert.assertTrue(homePage.isWordDisplayed().contains(Constants.HOME_PAGE), "Home Page word isn't visible!");

	}
}