package pages;

import org.openqa.selenium.By;

import base.PageBase;
import io.qameta.allure.Step;
import seleniumFramework.SeleniumFrameWork;

/**
 * Page Object representing the Contact Us Submitted page.
 */
public class ContactUsSubmitted extends PageBase {

	// ==========================================================
	// Constructor
	// ==========================================================

	/**
	 * Initializes the page object.
	 */
	public ContactUsSubmitted(SeleniumFrameWork FW) {
		super(FW);
	}

	// ==========================================================
	// Locators
	// ==========================================================

	// Contact form submission success message.
	private final By SuccessMessage = By.cssSelector("div[class='status alert alert-success']");

	// Home button.
	private final By HomeBtn = By.cssSelector("a[class='btn btn-success']");

	// ==========================================================
	// Actions
	// ==========================================================

	@Step("Get success message text after contact form submission")
	public String isSuccessMessageDisplayed() {
		return FW.MS_getText(SuccessMessage);
	}

	@Step("Click Home button")
	public void clickHomeBtn() {
		FW.MS_click(HomeBtn);
	}
}