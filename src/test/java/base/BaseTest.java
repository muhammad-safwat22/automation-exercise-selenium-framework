package base;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.google.gson.JsonObject;

import pages.AccountCreated;
import pages.AccountDeleted;
import pages.AllProductsPage;
import pages.CartPage;
import pages.ContactUs;
import pages.ContactUsSubmitted;
import pages.HomePage;
import pages.LoginPage;
import pages.PaymentPage;
import pages.ProductDetailPage;
import pages.SignupPage;
import pages.TestCasePage;
import pages.ViewCartPage;
import seleniumFramework.SeleniumFrameWork;
import utilities.Constants;
import utilities.JsonDataReader;

/**
 * Base class for all test classes. Handles browser setup, page object
 * initialization, test data loading, and common reusable test flows.
 */
public class BaseTest {

	// Ads
	protected WebDriver driver;

	// ==========================================================
	// Framework
	// ==========================================================

	protected SeleniumFrameWork FW;

	// ==========================================================
	// Shared Page Objects
	// ==========================================================

	protected HomePage homePage;
	protected LoginPage loginPage;
	protected SignupPage signupPage;
	protected AccountCreated accountCreated;
	protected AccountDeleted accountDeleted;
	protected ContactUs contactUs;
	protected ContactUsSubmitted contactUsSubmitted;
	protected TestCasePage testCasePage;
	protected AllProductsPage allProductsPage;
	protected ProductDetailPage productDetailPage;
	protected CartPage cartPage;
	protected ViewCartPage viewCartPage;
	protected PaymentPage paymentPage;

	// ==========================================================
	// Test Data
	// ==========================================================

	protected JsonObject testData;

	// ==========================================================
	// Setup
	// ==========================================================

	@BeforeMethod
	public void setup() {

		FW = new SeleniumFrameWork();

		FW.MS_initializeBrowser();
		FW.MS_navigateToURL(Constants.BASE_URL);

		testData = JsonDataReader.readJsonFromResource(Constants.TEST_DATA_FILE);

		initializePages();

		Assert.assertTrue(homePage.isWordDisplayed().contains(Constants.HOME_PAGE), "Home Page word isn't visible!");
	}

	// ==========================================================
	// Initialize Page Objects
	// ==========================================================

	/**
	 * Creates all shared page object instances.
	 */
	private void initializePages() {

		homePage = new HomePage(FW);
		loginPage = new LoginPage(FW);
		signupPage = new SignupPage(FW);
		accountCreated = new AccountCreated(FW);
		accountDeleted = new AccountDeleted(FW);
		contactUs = new ContactUs(FW);
		contactUsSubmitted = new ContactUsSubmitted(FW);
		testCasePage = new TestCasePage(FW);
		allProductsPage = new AllProductsPage(FW);
		productDetailPage = new ProductDetailPage(FW);
		cartPage = new CartPage(FW);
		viewCartPage = new ViewCartPage(FW);
		paymentPage = new PaymentPage(FW);
	}

	// ==========================================================
	// Common Test Flows
	// ==========================================================

	/**
	 * Opens the Signup/Login page and verifies that both login and signup sections
	 * are displayed.
	 */
	protected void openSignupPage() {

		homePage.clickSignupLogin();

		Assert.assertTrue(loginPage.isNewUserSignupVisible().contains(Constants.NEW_USER_SIGNUP),
				"'New User Signup!' text isn't visible!");

		Assert.assertTrue(loginPage.isLoginToYourAccountVisible().contains(Constants.LOGIN_TO_YOUR_ACCOUNT),
				"'Login to your account' Text isn't Visible!");
	}

	/**
	 * Completes the user registration flow using the configured test data.
	 */
	protected void completeRegistration() {

		JsonObject user = testData.getAsJsonObject("users").getAsJsonObject("validUser");

		loginPage.enterNameAndEmail(user.get("name").getAsString(), user.get("email").getAsString());

		loginPage.clickSignupBtn();

		Assert.assertTrue(signupPage.isEnterAccountInfo().trim().contains(Constants.ENTER_ACCOUNT_INFORMATION),
				"'ENTER ACCOUNT INFORMATION' text isn't visible!");

		signupPage.fillAccountInfo(user.get("title").getAsString(), user.get("password").getAsString(),
				user.get("day").getAsString(), user.get("month").getAsString(), user.get("year").getAsString());

		signupPage.selectNewsLetter();
		signupPage.selectSpecialOffers();

		signupPage.fillAddressDetails(user.get("firstName").getAsString(), user.get("lastName").getAsString(),
				user.get("company").getAsString(), user.get("address1").getAsString(),
				user.get("address2").getAsString(), user.get("country").getAsString(), user.get("state").getAsString(),
				user.get("city").getAsString(), user.get("zipcode").getAsString(), user.get("mobile").getAsString());

		signupPage.clickCreateAccount();

		Assert.assertTrue(accountCreated.isAccountCreatedVisible().contains(Constants.ACCOUNT_CREATED),
				"'ACCOUNT CREATED!' Message isn't Visible!");

		accountCreated.clickContinue();

		Assert.assertTrue(homePage.isLoggedInDisplayed().contains(Constants.LOGGED_IN_AS),
				"'Logged in as Username' isn't visible!");
	}

	/**
	 * Deletes the currently logged-in user account.
	 */
	protected void deleteUser() {

		homePage.clickDeleteAccount();

		Assert.assertTrue(accountDeleted.isAccountDeletedVisible().contains(Constants.ACCOUNT_DELETED),
				"'ACCOUNT DELETED!' Message isn't Visible!");

		accountDeleted.clickContinue();
	}

	/**
	 * Completes the checkout flow and verifies that the order is placed
	 * successfully.
	 */
	protected void proceedToCheckout() {

		completeCheckout();

		Assert.assertTrue(paymentPage.isOrderPlacedTitleVisible().contains(Constants.ORDER_PLACED),
				"'ORDER PLACED!' not Visible!");

		paymentPage.clickContinueBtn();
	}

	/**
	 * Completes the checkout flow and verifies that the invoice file is downloaded
	 * successfully.
	 */
	protected void downloadFile() {

		JsonObject download = testData.getAsJsonObject("download");

		completeCheckout();

		Assert.assertTrue(paymentPage.isOrderPlacedTitleVisible().contains(Constants.ORDER_PLACED),
				"'ORDER PLACED!' not Visible!");

		Assert.assertTrue(
				paymentPage.testFileDownload(download.get("path").getAsString(), download.get("fileName").getAsString())
						.contains(Constants.INVOICE),
				"The downloaded file name doesn't contain 'invoice'");

		paymentPage.clickContinueBtn();
	}

	// ==========================================================
	// Checkout Helper
	// ==========================================================

	/**
	 * Completes the payment process before placing the order.
	 */
	private void completeCheckout() {

		JsonObject products = testData.getAsJsonObject("products");
		JsonObject checkout = testData.getAsJsonObject("checkout");
		JsonObject payment = checkout.getAsJsonObject("payment");

		cartPage.clickProceedToCheckout();

		Assert.assertTrue(cartPage.getDeliveryAddressBox().contains(Constants.YOUR_DELIVERY_ADDRESS),
				"Delivery Address not visible!");

		Assert.assertTrue(cartPage.getBillingAddressBox().contains(Constants.YOUR_BILLING_ADDRESS),
				"Billing Address not visible!");

		Assert.assertTrue(cartPage.getFirstProduct().contains(products.get("firstProduct").getAsString()),
				"First Product isn't Visible!");

		Assert.assertTrue(cartPage.getSecondProduct().contains(products.get("secondProduct").getAsString()),
				"Second Product isn't Visible!");

		cartPage.enterOrderComment(checkout.get("orderComment").getAsString());

		cartPage.clickPlaceOrder();

		paymentPage.enterPaymentDetails(payment.get("cardName").getAsString(), payment.get("cardNumber").getAsString(),
				payment.get("cvc").getAsString(), payment.get("expiryMonth").getAsString(),
				payment.get("expiryYear").getAsString());

		paymentPage.scrollToElement();
		paymentPage.clickPayAndConfirmOrder();
	}

	// ==========================================================
	// Tear Down
	// ==========================================================

	@AfterMethod
	public void teardown() {

		if (FW != null) {
			FW.MS_closeBrowser();
		}
	}
}