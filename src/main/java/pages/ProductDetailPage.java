package pages;

import org.openqa.selenium.By;

import base.PageBase;
import io.qameta.allure.Step;
import seleniumFramework.SeleniumFrameWork;

/**
 * Page Object representing the Product Detail page.
 */
public class ProductDetailPage extends PageBase {

	// ==========================================================
	// Constructor
	// ==========================================================

	/**
	 * Initializes the page object.
	 */
	public ProductDetailPage(SeleniumFrameWork FW) {
		super(FW);
	}

	// ==========================================================
	// Locators
	// ==========================================================

	// Product information.
	private final By ProductName = By.cssSelector(".product-information h2");
	private final By Category = By.cssSelector("div[class=\"product-information\"] > p:nth-child(3)");
	private final By Price = By.cssSelector("div[class=\"product-information\"] > span > span");
	private final By Availability = By.cssSelector("div[class=\"product-information\"] > p:nth-child(6)");
	private final By Condition = By.cssSelector("div[class=\"product-information\"] > p:nth-child(7)");
	private final By Brand = By.cssSelector("div[class=\"product-information\"] > p:nth-child(8)");
	private final By ProductDetail = By.cssSelector("div.product-details > div.col-sm-7 > div");

	// Product actions.
	private final By AddToCartBtn = By.cssSelector("button[type='button']");
	private final By QuantityInput = By.id("quantity");
	private final By ViewCartBtn = By.cssSelector("a[href='/view_cart'] > u");

	// Review section.
	private final By WriteYourReviewHeading = By.cssSelector("a[href=\"#reviews\"]");
	private final By NameInput = By.id("name");
	private final By EmailInput = By.id("email");
	private final By ReviewInput = By.id("review");
	private final By SubmitBtn = By.id("button-review");
	private final By ReviewMsg = By.cssSelector("span[style=\"font-size: 20px;\"]");

	// ==========================================================
	// Actions
	// ==========================================================

	@Step("Get product name text")
	public String isProductNameVisible() {
		return FW.MS_getText(ProductName);
	}

	@Step("Get category text")
	public String isCategoryVisible() {
		return FW.MS_getText(Category);
	}

	@Step("Check if price is visible")
	public String isPriceVisible() {
		return FW.MS_getText(Price);
	}

	@Step("Check if availability is visible")
	public String isAvailabilityVisible() {
		return FW.MS_getText(Availability);
	}

	@Step("Check if condition is visible")
	public String isConditionVisible() {
		return FW.MS_getText(Condition);
	}

	@Step("Check if brand is visible")
	public String isBrandVisible() {
		return FW.MS_getText(Brand);
	}

	@Step("Get full product details")
	public String isProductDetailVisible() {
		return FW.MS_getText(ProductDetail);
	}

	@Step("Set product quantity to 4")
	public void setProductQuantity(String Quantity) {
		FW.MS_click(QuantityInput);
		FW.MS_clear(QuantityInput);
		FW.MS_sendKeys(QuantityInput, Quantity);
	}

	@Step("Click 'Add to Cart' button")
	public void clickAddToCartBtn() {
		FW.MS_click(AddToCartBtn);
	}

	@Step("Click 'View Cart' button")
	public void clickViewCartBtn() {
		FW.MS_click(ViewCartBtn);
	}

	@Step("Get 'Write Your Review' heading")
	public String isWriteYourReviewVisible() {
		return FW.MS_getText(WriteYourReviewHeading);
	}

	@Step("Enter name: Muhammad Safwat, email: MOCHA74@gmail.com, and review: This is a Beautiful Product., then submit")
	public void enterNameAndEmailAndReview(String name, String email, String review) {
		FW.MS_sendKeys(NameInput, name);
		FW.MS_sendKeys(EmailInput, email);
		FW.MS_sendKeys(ReviewInput, review);
		FW.MS_click(SubmitBtn);
		System.out.println("Entered Details Successfully!");
	}

	@Step("Get review confirmation message")
	public String isReviewMsgVisible() {
		return FW.MS_getText(ReviewMsg);
	}
}