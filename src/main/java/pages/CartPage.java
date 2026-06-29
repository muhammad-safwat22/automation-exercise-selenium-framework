package pages;

import org.openqa.selenium.By;

import base.PageBase;
import io.qameta.allure.Step;
import seleniumFramework.SeleniumFrameWork;

/**
 * Page Object representing the Cart page.
 */
public class CartPage extends PageBase {

	// ==========================================================
	// Constructor
	// ==========================================================

	/**
	 * Initializes the page object.
	 */
	public CartPage(SeleniumFrameWork FW) {
		super(FW);
	}

	// ==========================================================
	// Locators
	// ==========================================================

	// Shopping cart status message.
	private final By CartIsEmptyMsg = By.cssSelector("li[class='active']");

	// Footer section.
	private final By Footer = By.cssSelector("footer[id='footer']");

	// Subscription section.
	private final By SubscriptionTitle = By.cssSelector("div[class='single-widget'] > h2");
	private final By SubscriptionEmailInput = By.id("susbscribe_email");
	private final By SubscriptionBtn = By.id("subscribe");
	private final By SuccessSubscriptionMsg = By.cssSelector("div[class='alert-success alert']");

	// Checkout section.
	private final By ProceedToCheckoutBtn = By.cssSelector("div[class='col-sm-6'] > a");
	private final By CheckoutRegisterLoginBtn = By.cssSelector("a[href=\"/login\"] > u");
	private final By TextareaMsg = By.cssSelector("textarea[name='message']");
	private final By PlaceOrderBtn = By.cssSelector("a[href='/payment']");

	// Address details.
	private final By DeliveryAddressBox = By.id("address_delivery");
	private final By BillingAddressBox = By.id("address_invoice");

	// Products in cart.
	private final By FirstProduct = By.cssSelector("a[href=\"/product_details/30\"]");
	private final By SecondProduct = By.cssSelector("a[href=\"/product_details/35\"]");

	// ==========================================================
	// Actions
	// ==========================================================

	@Step("Get shopping cart message text")
	public String isShoppingCartMsgVisible() {
		return FW.MS_getText(CartIsEmptyMsg);
	}

	@Step("Scroll to footer section")
	public void scrollToFooter() {
		FW.MS_scrollToElement(Footer);
	}

	@Step("Get subscription title text")
	public String isSubscriptionTitleVisible() {
		return FW.MS_getText(SubscriptionTitle);
	}

	@Step("Enter email 'MOCHA74@gmail.com' and click Subscribe")
	public void enterEmailAndClick(String email) {
		FW.MS_sendKeys(SubscriptionEmailInput, email);
		FW.MS_click(SubscriptionBtn);
	}

	@Step("Get success subscription message")
	public String isSuccessSubscriptionMesVisible() {
		return FW.MS_getText(SuccessSubscriptionMsg);
	}

	@Step("Click Proceed To Checkout button")
	public void clickProceedToCheckout() {
		FW.MS_click(ProceedToCheckoutBtn);
	}

	@Step("Click Register/Login button during checkout")
	public void clickCheckoutRegisterLoginBtn() {
		FW.MS_click(CheckoutRegisterLoginBtn);
	}

	@Step("Get first product name from cart")
	public String getFirstProduct() {
		FW.MS_scrollToElement(FirstProduct);
		return FW.MS_getText(FirstProduct);
	}

	@Step("Get second product name from cart")
	public String getSecondProduct() {
		FW.MS_scrollToElement(SecondProduct);
		return FW.MS_getText(SecondProduct);
	}

	@Step("Enter order comment: Please Deliver Between 9AM - 12PM")
	public void enterOrderComment(String comment) {
		FW.MS_sendKeys(TextareaMsg, comment);
		System.out.println("Entered comment: " + comment);
	}

	@Step("Click Place Order button")
	public void clickPlaceOrder() {
		FW.MS_click(PlaceOrderBtn);
		System.out.println("Clicked 'Place Order' button.");
	}

	@Step("Get delivery address details")
	public String getDeliveryAddressBox() {
		return FW.MS_getText(DeliveryAddressBox);
	}

	@Step("Get billing address details")
	public String getBillingAddressBox() {
		return FW.MS_getText(BillingAddressBox);
	}
}