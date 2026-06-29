package pages;

import org.openqa.selenium.By;

import base.PageBase;
import io.qameta.allure.Step;
import seleniumFramework.SeleniumFrameWork;

/**
 * Page Object representing the Login page.
 */
public class LoginPage extends PageBase {

	// ==========================================================
	// Constructor
	// ==========================================================

	/**
	 * Initializes the page object.
	 */
	public LoginPage(SeleniumFrameWork FW) {
		super(FW);
	}

	// ==========================================================
	// Locators
	// ==========================================================

	// Signup section.
	private final By NewUserSignupText = By.xpath("//h2[text()=\"New User Signup!\"]");
	private final By NameInput = By.cssSelector("input[type='text'][data-qa='signup-name']");
	private final By EmailInput = By.cssSelector("input[type='email'][data-qa='signup-email']");
	private final By SignupBtn = By.cssSelector("button[type='submit'][data-qa='signup-button']");

	// Login section.
	private final By LoginToYourAccountText = By.xpath("//h2[text()=\"Login to your account\"]");
	private final By EmailAddress = By.cssSelector("input[type='email'][data-qa='login-email']");
	private final By Password = By.cssSelector("input[type='password'][data-qa='login-password']");
	private final By LoginBtn = By.cssSelector("button[type='submit'][data-qa='login-button']");

	// Validation messages.
	private final By LoginErrorText = By.cssSelector("p[style='color: red;']");
	private final By SignupErrorText = By.cssSelector("p[style='color: red;']");

	// ==========================================================
	// Actions
	// ==========================================================

	@Step("Get 'New User Signup!' text")
	public String isNewUserSignupVisible() {
		return FW.MS_getText(NewUserSignupText);
	}

	@Step("Enter name: Muhammad Safwat, email: MOCHA74@gmail.com in signup form")
	public void enterNameAndEmail(String name, String email) {
		FW.MS_sendKeys(NameInput, name);
		FW.MS_sendKeys(EmailInput, email);
	}

	@Step("Click Signup button")
	public void clickSignupBtn() {
		FW.MS_click(SignupBtn);
	}

	@Step("Get 'Login to your account' text")
	public String isLoginToYourAccountVisible() {
		return FW.MS_getText(LoginToYourAccountText);
	}

	@Step("Enter login email: MOCHA74@gmail.com, password: 2274")
	public void enterEmailAndPassword(String email, String password) {
		FW.MS_sendKeys(EmailAddress, email);
		FW.MS_sendKeys(Password, password);
	}

	@Step("Click Login button")
	public void clickLoginBtn() {
		FW.MS_click(LoginBtn);
	}

	@Step("Get login error text")
	public String isLoginErrorTextVisible() {
		return FW.MS_getText(LoginErrorText);
	}

	@Step("Get signup error text")
	public String isSignupErrorTextVisible() {
		return FW.MS_getText(SignupErrorText);
	}
}