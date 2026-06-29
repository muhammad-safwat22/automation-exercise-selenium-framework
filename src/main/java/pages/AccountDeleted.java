package pages;

import org.openqa.selenium.By;

import base.PageBase;
import io.qameta.allure.Step;
import seleniumFramework.SeleniumFrameWork;

/**
 * Page Object representing the Account Deleted page.
 */
public class AccountDeleted extends PageBase {

	/**
	 * Initializes the page object.
	 */
	public AccountDeleted(SeleniumFrameWork FW) {
		super(FW);
	}

	// ==========================================================
	// Locators
	// ==========================================================

	// Account deletion success message.
	private final By accountDeletedMsg = By.cssSelector("h2[data-qa='account-deleted'] b");

	// Continue button.
	private final By continueBtn = By.cssSelector("a[data-qa='continue-button']");

	// ==========================================================
	// Actions
	// ==========================================================

	@Step("Check if 'ACCOUNT DELETED!' message is visible")
	public String isAccountDeletedVisible() {
		return FW.MS_getText(accountDeletedMsg);
	}

	@Step("Click Continue button after account deletion")
	public void clickContinue() {
		FW.MS_click(continueBtn);
	}
}