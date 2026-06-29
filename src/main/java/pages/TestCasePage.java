package pages;

import org.openqa.selenium.By;

import base.PageBase;
import io.qameta.allure.Step;
import seleniumFramework.SeleniumFrameWork;

/**
 * Page Object representing the Test Cases page.
 */
public class TestCasePage extends PageBase {

	// ==========================================================
	// Constructor
	// ==========================================================

	/**
	 * Initializes the page object.
	 */
	public TestCasePage(SeleniumFrameWork FW) {
		super(FW);
	}

	// ==========================================================
	// Locators
	// ==========================================================

	// Test Cases page title.
	private final By testCasesTitle = By.cssSelector("#form > div > div.row > div > h2 > b");

	// ==========================================================
	// Actions
	// ==========================================================

	@Step("Get 'Test Cases' page title text")
	public String isTitleTestCaseVisible() {
		return FW.MS_getText(testCasesTitle);
	}
}