package pages;

import org.openqa.selenium.By;

import base.PageBase;
import io.qameta.allure.Step;
import seleniumFramework.SeleniumFrameWork;

/**
 * Page Object representing the Contact Us page.
 */
public class ContactUs extends PageBase {

	// ==========================================================
	// Constructor
	// ==========================================================

	/**
	 * Initializes the page object.
	 */
	public ContactUs(SeleniumFrameWork FW) {
		super(FW);
	}

	// ==========================================================
	// Locators
	// ==========================================================

	// Contact form title.
	private final By GetInTouchMsg = By.cssSelector("div.col-sm-8 > div > h2");

	// Contact form fields.
	private final By NameInput = By.cssSelector("input[name='name']");
	private final By EmailInput = By.cssSelector("input[name='email']");
	private final By SubjectInput = By.cssSelector("input[name='subject']");
	private final By MessageInput = By.cssSelector("textarea[name='message']");

	// File upload control.
	private final By UploadFileInput = By.cssSelector("input[type='file']");

	// Submit button.
	private final By SubmitBtn = By.cssSelector("input[type='submit']");

	// ==========================================================
	// Actions
	// ==========================================================

	@Step("Get 'Get in Touch' message text")
	public String isGetInTouchMsgVisible() {
		return FW.MS_getText(GetInTouchMsg);
	}

	@Step("Fill contact form with Name: Muhammad Safwat, Email: MOCHA74@gmail.com,"
			+ "Subject: Testing Subject, Message: This is a Message")
	public void fillForm(String name, String email, String subject, String message) {
		FW.MS_sendKeys(NameInput, name);
		FW.MS_sendKeys(EmailInput, email);
		FW.MS_sendKeys(SubjectInput, subject);
		FW.MS_sendKeys(MessageInput, message);
	}

	@Step("Upload file from path: E:\\Software Testing Course\\Edges for Training\\Projects\\FP_1.txt")
	public void uploadFile(String filepath) {
		FW.MS_sendKeys(UploadFileInput, filepath);
	}

	@Step("Click on Submit button")
	public void clickSubmit() {
		FW.MS_click(SubmitBtn);
	}

	@Step("Accept confirmation alert")
	public void acceptAlert() {
		FW.MS_acceptAlert();
	}
}