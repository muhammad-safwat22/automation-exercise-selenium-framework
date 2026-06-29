package pages;

import org.openqa.selenium.By;

import base.PageBase;
import io.qameta.allure.Step;
import seleniumFramework.SeleniumFrameWork;

/**
 * Page Object representing the Home page.
 */
public class HomePage extends PageBase {

	// ==========================================================
	// Constructor
	// ==========================================================

	/**
	 * Initializes the page object.
	 */
	public HomePage(SeleniumFrameWork FW) {
		super(FW);
	}

	// ==========================================================
	// Locators
	// ==========================================================

	// Home page welcome text.
	private final By Word = By.cssSelector("div[class='col-sm-6'] > h1");

	// Navigation menu.
	private final By SignupLoginBtn = By.cssSelector("a[href='/login']");
	private final By LoggedIn = By.cssSelector("ul > li:nth-child(10)");
	private final By DeleteAccountBtn = By.cssSelector("a[href='/delete_account']");
	private final By LogoutAccountBtn = By.cssSelector("a[href='/logout']");
	private final By ContactUsBtn = By.cssSelector("a[href='/contact_us']");
	private final By TestCaseBtn = By.cssSelector("ul > li:nth-child(5)>a[href='/test_cases']");
	private final By ProductsBtn = By.cssSelector("ul > li:nth-child(2)>a[href='/products']");
	private final By CartBtn = By.cssSelector("ul > li:nth-child(3)>a[href='/view_cart']");

	// Footer and subscription section.
	private final By Footer = By.cssSelector("footer[id='footer']");
	private final By SubscriptionTitle = By.cssSelector("div[class='single-widget'] > h2");
	private final By SubscriptionEmailInput = By.id("susbscribe_email");
	private final By SubscriptionBtn = By.id("subscribe");
	private final By SuccessSubscriptionMsg = By.cssSelector("div[class=\"alert-success alert\"]");

	// Products section.
	private final By ViewProductBtnInHomePage = By.cssSelector("div:nth-child(26) > div > div.choose > ul > li > a");
	private final By FirstProduct = By.cssSelector("div:nth-child(26) > div");
	private final By FirstAddToCartBtn = By
			.cssSelector("div.features_items div.col-sm-4:nth-child(26) .overlay-content a.add-to-cart");
	private final By ContinueShoppingBtn = By.cssSelector("div.modal-footer > button");
	private final By SecondProduct = By.cssSelector("div:nth-child(29) > div");
	private final By SecondAddToCartBtn = By.cssSelector(
			"body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(29) > div > div.single-products > div.product-overlay > div > a");

	// Categories section.
	private final By CategoriesGroup = By.cssSelector("div[class=\"panel-group category-products\"]");
	private final By WomenBtn = By.cssSelector("h4[class='panel-title'] > a[href='#Women']");
	private final By DressBtn = By.cssSelector("li:nth-child(1) > a[href=\"/category_products/1\"]");

	// Recommended items section.
	private final By ScrollToBottom = By.cssSelector("div[class=\"recommended_items\"]");
	private final By RecommendedItemsTitle = By.cssSelector("div[class=\"recommended_items\"] > h2");
	private final By Picture = By
			.cssSelector("#recommended-item-carousel > div > div.item.active.left > div:nth-child(2)");
	private final By AddToCartBtnOfBottom = By.cssSelector(
			"#recommended-item-carousel > div > div:nth-child(1) > div:nth-child(2) > div > div > div > a");
	private final By ArrowLocator = By.cssSelector("#recommended-item-carousel > a.right.recommended-item-control");

	// Scroll controls.
	private final By ArrowToUpBtn = By.cssSelector("a[id='scrollUp']");
	private final By ScrolledUp = By.cssSelector("div[class=\"col-sm-6\"] > h2");

	// ==========================================================
	// Actions
	// ==========================================================

	@Step("Get main word text on Home Page")
	public String isWordDisplayed() {
		return FW.MS_getText(Word);
	}

	@Step("Click on 'Signup / Login' button")
	public void clickSignupLogin() {
		FW.MS_click(SignupLoginBtn);
	}

	@Step("Check if user is logged in")
	public String isLoggedInDisplayed() {
		return FW.MS_getText(LoggedIn);
	}

	@Step("Click 'Delete Account' button")
	public void clickDeleteAccount() {
		FW.MS_click(DeleteAccountBtn);
	}

	@Step("Click 'Logout' button")
	public void clickLogoutAccount() {
		FW.MS_click(LogoutAccountBtn);
	}

	@Step("Navigate to Contact Us page")
	public void clickContactUsBtn() {
		FW.MS_click(ContactUsBtn);
	}

	@Step("Navigate to Test Cases page")
	public void clickTestCaseBtn() {
		FW.MS_click(TestCaseBtn);
	}

	@Step("Navigate to Products page")
	public void clickProductsBtn() {
		FW.MS_click(ProductsBtn);
	}

	@Step("Scroll down to footer")
	public void scrollToFooter() {
		FW.MS_scrollToElement(Footer);
	}

	@Step("Get subscription title text")
	public String isSubscriptionTitleVisible() {
		return FW.MS_getText(SubscriptionTitle);
	}

	@Step("Enter email and click Subscribe")
	public void enterEmailAndClick(String email) {
		FW.MS_sendKeys(SubscriptionEmailInput, email);
		FW.MS_click(SubscriptionBtn);
	}

	@Step("Get subscription success message")
	public String isSuccessSubscriptionMesVisible() {
		return FW.MS_getText(SuccessSubscriptionMsg);
	}

	@Step("Click 'Cart' button")
	public void clickCartBtn() {
		FW.MS_click(CartBtn);
	}

	@Step("Click 'View Product' button from Home Page")
	public void clickViewProductBtnInHomePage() {
		FW.MS_scrollToElement(ViewProductBtnInHomePage);
		FW.MS_click(ViewProductBtnInHomePage);
	}

	@Step("Hover & add first product to cart")
	public void hoverAndClickAddFirstProduct() {
		FW.MS_scrollToElement(FirstProduct);
		FW.MS_hoverOverElement(FirstProduct);
		FW.MS_click(FirstAddToCartBtn);
	}

	@Step("Click 'Continue Shopping' button")
	public void clickContinueShoppingBtn() {
		FW.MS_click(ContinueShoppingBtn);
	}

	@Step("Hover & add second product to cart")
	public void hoverAndClickAddSecondProduct() {
		FW.MS_scrollToElement(SecondProduct);
		FW.MS_hoverOverElement(SecondProduct);
		FW.MS_click(SecondAddToCartBtn);
	}

	@Step("Get Categories group text")
	public String areCategoriesGroupVisible() {
		return FW.MS_getText(CategoriesGroup);
	}

	@Step("Click 'Women' category")
	public void clickWomenBtn() {
		FW.MS_click(WomenBtn);
	}

	@Step("Click 'Dress' subcategory")
	public void clickDressBtn() {
		FW.MS_click(DressBtn);
	}

	@Step("Scroll down to Recommended Items section")
	public void ScrollToBottomOfPage() {
		FW.MS_scrollToElement(ScrollToBottom);
	}

	@Step("Get Recommended Items section title")
	public String isRecommendedItemsVisible() {
		return FW.MS_getText(RecommendedItemsTitle);
	}

	@Step("Click right arrow in carousel")
	public void clickArrow() {
		FW.MS_click(ArrowLocator);
	}

	@Step("Click 'Add to Cart' in Recommended Items")
	public void clickAddToCartBtnOfBottom() {
		if (FW.MS_isElementDisplayed(Picture)) {
			FW.MS_click(AddToCartBtnOfBottom);
		} else {
			FW.MS_click(ArrowLocator);
			FW.MS_click(AddToCartBtnOfBottom);
		}
	}

	@Step("Click scroll-up arrow and get top section text")
	public String clickArrowToUpBtn() {
		FW.MS_click(ArrowToUpBtn);
		return FW.MS_getText(ScrolledUp);
	}

	@Step("Scroll up and get top section text")
	public String scrollToUp() {
		FW.MS_scrollToElement(ScrolledUp);
		return FW.MS_getText(ScrolledUp);
	}
}