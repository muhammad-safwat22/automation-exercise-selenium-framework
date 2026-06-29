package pages;

import org.openqa.selenium.By;

import base.PageBase;
import io.qameta.allure.Step;
import seleniumFramework.SeleniumFrameWork;

/**
 * Page Object representing the Signup page.
 */
public class SignupPage extends PageBase {

	// ==========================================================
	// Constructor
	// ==========================================================

	/**
	 * Initializes the page object.
	 */
	public SignupPage(SeleniumFrameWork FW) {
		super(FW);
	}

	// ==========================================================
	// Locators
	// ==========================================================

	// Account information section.
	private final By EnterAccountInfo = By.xpath("/html/body/section/div/div/div/div[1]/h2/b");
	private final By titleMr = By.cssSelector("#id_gender1");
	private final By titleMrs = By.cssSelector("#id_gender2");
	private final By passwordInput = By.cssSelector("#password");
	private final By dayDropdown = By.cssSelector("#days");
	private final By monthDropdown = By.cssSelector("#months");
	private final By yearDropdown = By.cssSelector("#years");

	// Preferences.
	private final By NewsLetterCheckbox = By.cssSelector("#newsletter");
	private final By OffersCheckbox = By.cssSelector("#optin");

	// Address details section.
	private final By firstNameInput = By.cssSelector("#first_name");
	private final By lastNameInput = By.cssSelector("#last_name");
	private final By companyInput = By.cssSelector("#company");
	private final By address1Input = By.cssSelector("#address1");
	private final By address2Input = By.cssSelector("#address2");
	private final By countryDropdown = By.cssSelector("#country");
	private final By stateInput = By.cssSelector("input[data-qa='state']");
	private final By cityInput = By.cssSelector("input[data-qa='city']");
	private final By zipcodeInput = By.cssSelector("input[data-qa='zipcode']");
	private final By mobileNumberInput = By.cssSelector("#mobile_number");

	// Account creation button.
	private final By CreateAccountBtn = By.cssSelector("button[type='submit'][data-qa='create-account']");

	// ==========================================================
	// Actions
	// ==========================================================

	@Step("Get 'Enter Account Information' heading text")
	public String isEnterAccountInfo() {
		return FW.MS_getText(EnterAccountInfo);
	}

	@Step("Fill account info with Title: Mr, Password: 2274, DOB: 2-November-1999")
	public void fillAccountInfo(String title, String password, String day, String month, String year) {
		if (title.equalsIgnoreCase("Mr")) {
			FW.MS_click(titleMr);
		} else if (title.equalsIgnoreCase("Mrs")) {
			FW.MS_click(titleMrs);
		}
		FW.MS_sendKeys(passwordInput, password);
		FW.MS_selectDropdownByVisibleText(dayDropdown, day);
		FW.MS_selectDropdownByVisibleText(monthDropdown, month);
		FW.MS_selectDropdownByVisibleText(yearDropdown, year);
	}

	@Step("Select newsletter checkbox")
	public void selectNewsLetter() {
		FW.MS_click(NewsLetterCheckbox);
	}

	@Step("Select special offers checkbox")
	public void selectSpecialOffers() {
		FW.MS_click(OffersCheckbox);
	}

	@Step("Fill address details: FirstName = Muhammad, LastName = Safwat, Company = Giza System,"
			+ "Address1 = NO.1 Street, Address2 = NO.7 Street, Country = United States,"
			+ "State = Cairo, City = Giza, Zip = M22, Mobile = 12345678910")
	public void fillAddressDetails(String firstName, String lastName, String company, String address1, String address2,
			String country, String state, String city, String zipcode, String mobileNumber) {
		FW.MS_sendKeys(firstNameInput, firstName);
		FW.MS_sendKeys(lastNameInput, lastName);
		FW.MS_sendKeys(companyInput, company);
		FW.MS_sendKeys(address1Input, address1);
		FW.MS_sendKeys(address2Input, address2);
		FW.MS_selectDropdownByVisibleText(countryDropdown, country);
		FW.MS_sendKeys(stateInput, state);
		FW.MS_sendKeys(cityInput, city);
		FW.MS_sendKeys(zipcodeInput, zipcode);
		FW.MS_sendKeys(mobileNumberInput, mobileNumber);
	}

	@Step("Click 'Create Account' button")
	public void clickCreateAccount() {
		FW.MS_click(CreateAccountBtn);
	}
}