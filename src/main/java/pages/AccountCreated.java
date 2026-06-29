package pages;

import org.openqa.selenium.By;

import base.PageBase;
import io.qameta.allure.Step;
import seleniumFramework.SeleniumFrameWork;

/**
 * Page Object representing the Account Created page.
 */
public class AccountCreated extends PageBase {

	/**
	 * Initializes the page object.
	 */
	public AccountCreated(SeleniumFrameWork FW) {
		super(FW);
	}

	// ==========================================================
	// Locators
	// ==========================================================

	// Account creation success message.
	private final By accountCreateMsg = By.cssSelector("h2[data-qa='account-created'] b");

	// Continue button.
	private final By continueBtn = By.cssSelector("a[data-qa='continue-button']");

	// ==========================================================
	// Actions
	// ==========================================================

	@Step("Check if 'ACCOUNT CREATED!' message is visible")
	public String isAccountCreatedVisible() {
		return FW.MS_getText(accountCreateMsg);
	}

	@Step("Click Continue button after account creation")
	public void clickContinue() {
		FW.MS_click(continueBtn);
	}
}