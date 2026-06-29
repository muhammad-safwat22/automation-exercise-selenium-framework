package pages;

import org.openqa.selenium.By;

import base.PageBase;
import io.qameta.allure.Step;
import seleniumFramework.SeleniumFrameWork;

/**
 * Page Object representing the All Products page.
 */
public class AllProductsPage extends PageBase {

	// ==========================================================
	// Constructor
	// ==========================================================

	/**
	 * Initializes the page object.
	 */
	public AllProductsPage(SeleniumFrameWork FW) {
		super(FW);
	}

	// ==========================================================
	// Locators
	// ==========================================================

	// All Products page title.
	private final By AllProductsTitle = By.cssSelector("h2[class='title text-center']");

	// Products list section.
	private final By ProductsList = By.cssSelector("div[class='features_items']");

	// First product view button.
	private final By FirstProductViewBtn = By.cssSelector("a[href='/product_details/1']");

	// Product search controls.
	private final By SearchInput = By.cssSelector("input[id='search_product']");
	private final By SearchBtn = By.cssSelector("button[id='submit_search']");

	// Search results.
	private final By SearchedProductsTitle = By.cssSelector("h2[class='title text-center']");
	private final By SearchedProductList = By.cssSelector("div.col-sm-4 div.product-image-wrapper");

	// Product cards and Add to Cart buttons.
	private final By FirstProduct = By.cssSelector("div.features_items div.col-sm-4:nth-child(3)");
	private final By FirstAddToCartBtn = By.cssSelector(".product-overlay a[data-product-id='1']");
	private final By ScrollToProduct = By.cssSelector(
			"body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div > div:nth-child(3) > div > div.choose > ul > li > a");
	private final By ScrollToPoloProduct = By.cssSelector("a[href=\"/product_details/30\"]");
	private final By ContinueShoppingBtn = By.cssSelector("div.modal-footer > button");
	private final By SecondProduct = By.cssSelector("div.features_items div.col-sm-4:nth-child(4)");
	private final By SecondAddToCartBtn = By
			.cssSelector("div.features_items div.col-sm-4:nth-child(4) .overlay-content a.add-to-cart");
	private final By ViewCartBtn = By.cssSelector("p.text-center > a");

	// Category section.
	private final By WomenDressProductsTitle = By.cssSelector("div.features_items > h2");
	private final By MenBtn = By.cssSelector("h4.panel-title > a[href='#Men']");
	private final By JeansBtn = By.cssSelector("li:nth-child(2) > a[href=\"/category_products/6\"]");
	private final By MenJeansProductsTitle = By.cssSelector("div.features_items > h2");

	// Brand section.
	private final By BrandsList = By.cssSelector("div.brands_products");
	private final By PoloBtn = By.cssSelector("a[href=\"/brand_products/Polo\"]");
	private final By BrandPoloProductsTitle = By.cssSelector("div.features_items > h2");
	private final By KookieKidsBtn = By.cssSelector("a[href=\"/brand_products/Kookie Kids\"]");
	private final By BrandKookieKidsProductsTitle = By.cssSelector("div.features_items > h2");

	// ==========================================================
	// Actions
	// ==========================================================

	@Step("Verify 'All Products' page title is visible")
	public String isAllProductsVisible() {
		return FW.MS_getText(AllProductsTitle);
	}

	@Step("Verify products list section is visible")
	public String isProductsListVisible() {
		return FW.MS_getText(ProductsList);
	}

	@Step("Click on the first product view button")
	public void clickFirstProductView() {
		FW.MS_click(FirstProductViewBtn);
	}

	@Step("Search for product: Premium Polo T-Shirts")
	public void searchforProduct(String productName) {
		FW.MS_sendKeys(SearchInput, productName);
		FW.MS_click(SearchBtn);
	}

	@Step("Verify searched products title is visible")
	public String isSearchedProductsTitleVisible() {
		return FW.MS_getText(SearchedProductsTitle);
	}

	@Step("Verify searched product list is visible")
	public String areSearchedProductListVisible() {
		return FW.MS_getText(SearchedProductList);
	}

	@Step("Hover and add first product to cart")
	public void hoverAndClickAddFirstProduct() {
		FW.MS_scrollToElement(ScrollToProduct);
		FW.MS_hoverOverElement(FirstProduct);
		FW.MS_click(FirstAddToCartBtn);
	}

	@Step("Hover and add Polo product to cart")
	public void hoverAndClickAddFirstPoloProduct() {
		FW.MS_scrollToElement(ScrollToPoloProduct);
		FW.MS_hoverOverElement(FirstProduct);
		FW.MS_click(FirstAddToCartBtn);
	}

	@Step("Click 'Continue Shopping' button in modal")
	public void clickContinueShoppingBtn() {
		FW.MS_click(ContinueShoppingBtn);
	}

	@Step("Hover and add second product to cart")
	public void hoverAndClickAddSecondProduct() {
		FW.MS_scrollToElement(ScrollToProduct);
		FW.MS_hoverOverElement(SecondProduct);
		FW.MS_click(SecondAddToCartBtn);
	}

	@Step("Click 'View Cart' button")
	public void clickViewCartBtn() {
		FW.MS_click(ViewCartBtn);
	}

	@Step("Verify women dress products title is visible")
	public String isWomenDressProductsVisible() {
		return FW.MS_getText(WomenDressProductsTitle);
	}

	@Step("Click 'Men' category")
	public void clickMenBtn() {
		FW.MS_click(MenBtn);
	}

	@Step("Click 'Jeans' sub-category")
	public void clickJeansBtn() {
		FW.MS_click(JeansBtn);
	}

	@Step("Verify men jeans products title is visible")
	public String isMenJeansProductsVisible() {
		return FW.MS_getText(MenJeansProductsTitle);
	}

	@Step("Verify brands list is visible")
	public String isBrandsListVisible() {
		return FW.MS_getText(BrandsList);
	}

	@Step("Click 'Polo' brand")
	public void clickPoloBtn() {
		FW.MS_click(PoloBtn);
	}

	@Step("Verify Polo brand products title is visible")
	public String isBrandPoloProductsVisible() {
		return FW.MS_getText(BrandPoloProductsTitle);
	}

	@Step("Click 'Kookie Kids' brand")
	public void clickKookieKidsBtn() {
		FW.MS_click(KookieKidsBtn);
	}

	@Step("Verify Kookie Kids brand products title is visible")
	public String isBrandKookieKidsProductsVisible() {
		return FW.MS_getText(BrandKookieKidsProductsTitle);
	}
}