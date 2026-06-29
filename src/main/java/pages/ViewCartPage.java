package pages;

import org.openqa.selenium.By;

import base.PageBase;
import io.qameta.allure.Step;
import seleniumFramework.SeleniumFrameWork;

/**
 * Page Object representing the View Cart page.
 */
public class ViewCartPage extends PageBase {

	// ==========================================================
	// Constructor
	// ==========================================================

	/**
	 * Initializes the page object.
	 */
	public ViewCartPage(SeleniumFrameWork FW) {
		super(FW);
	}

	// ==========================================================
	// Locators
	// ==========================================================

	// Cart products.
	private final By CartProducts = By.cssSelector("tr[id^='product-']");
	private final By CartProductsVisible = By.cssSelector("tbody");

	// First product details.
	private final By FirstProductPrice = By.cssSelector("tr#product-1 td.cart_price p");
	private final By FirstProductQuantity = By.cssSelector("tr#product-1 td.cart_quantity button");
	private final By FirstProductTotal = By.cssSelector("tr#product-1 td.cart_total p");

	// Second product details.
	private final By SecondProductPrice = By.cssSelector("tr#product-2 td.cart_price p");
	private final By SecondProductQuantity = By.cssSelector("tr#product-2 td.cart_quantity button");
	private final By SecondProductTotal = By.cssSelector("tr#product-2 td.cart_total p");

	// Cart actions.
	private final By RemoveProductBtn = By.cssSelector("a[data-product-id=\"35\"]");

	// Cart validation.
	private final By ProductsAfterRemove = By.id("product-30");
	private final By ProductsAfterAddedFromRecommended = By.id("product-2");
	private final By cartProductQuantity = By.cssSelector("tr[id^='product-'] td.cart_quantity button");

	// ==========================================================
	// Actions
	// ==========================================================

	@Step("Check if 2 products are visible in the cart")
	public boolean areCartProductsVisible() {
		return FW.MS_Elements_count(CartProducts) == 2;
	}

	@Step("Get all cart products text")
	public String areeCartProductsVisible() {
		return FW.MS_getText(CartProductsVisible);
	}

	@Step("Verify product price × quantity = total for all products")
	public void verifyProductPriceQuantityTotal() {

		// First Product.
		int price1 = FW.MS_extractPrice(FW.MS_getElementText(FirstProductPrice));
		int quantity1 = Integer.parseInt(FW.MS_getElementText(FirstProductQuantity));
		int total1 = FW.MS_extractPrice(FW.MS_getElementText(FirstProductTotal));

		if (price1 * quantity1 == total1) {
			System.out.println("First product total is correct: " + total1);
		} else {
			System.out.println(
					"First product total mismatch! Expected: " + (price1 * quantity1) + " but found: " + total1);
		}

		// Second Product.
		int price2 = FW.MS_extractPrice(FW.MS_getElementText(SecondProductPrice));
		int quantity2 = Integer.parseInt(FW.MS_getElementText(SecondProductQuantity));
		int total2 = FW.MS_extractPrice(FW.MS_getElementText(SecondProductTotal));

		if (price2 * quantity2 == total2) {
			System.out.println("Second product total is correct: " + total2);
		} else {
			System.out.println(
					"Second product total mismatch! Expected: " + (price2 * quantity2) + " but found: " + total2);
		}
	}

	@Step("Get product quantity from cart")
	public String getProductQuantity() {
		return FW.MS_getText(cartProductQuantity);
	}

	@Step("Check if product quantity is '4'")
	public boolean isProductQuantityCorrect(String expectedQty) {
		String actualQty = getProductQuantity();
		System.out.println("Expected Qty: " + expectedQty + " | Actual Qty: " + actualQty);
		return actualQty.equals(expectedQty);
	}

	@Step("Remove a product from the cart")
	public void clickRemoveProductBtn() {
		FW.MS_click(RemoveProductBtn);
	}

	@Step("Get cart content after removing product")
	public String areCartProductsAfterRemoveVisible() {
		return FW.MS_getText(ProductsAfterRemove);
	}

	@Step("Get cart content after adding recommended product")
	public String isCartProductsAfterAddedFromRecommendedVisible() {
		return FW.MS_getText(ProductsAfterAddedFromRecommended);
	}
}