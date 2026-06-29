package pages;

import org.openqa.selenium.By;

import base.PageBase;
import io.qameta.allure.Step;
import seleniumFramework.SeleniumFrameWork;

/**
 * Page Object representing the Payment page.
 */
public class PaymentPage extends PageBase {

	// ==========================================================
	// Constructor
	// ==========================================================

	/**
	 * Initializes the page object.
	 */
	public PaymentPage(SeleniumFrameWork FW) {
		super(FW);
	}

	// ==========================================================
	// Locators
	// ==========================================================

	// Payment page heading.
	private final By PaymentHeading = By.cssSelector("h2[class='heading']");

	// Payment form fields.
	private final By NameOnCardInput = By.name("name_on_card");
	private final By CardNumberInput = By.name("card_number");
	private final By CVCInput = By.name("cvc");
	private final By ExpairyMonthInput = By.name("expiry_month");
	private final By ExpairyYearInput = By.name("expiry_year");

	// Payment actions.
	private final By PayAndConfirmOrderBtn = By.cssSelector("button[data-qa='pay-button']");
	private final By ScrollToTitle = By.cssSelector("div.col-sm-3.col-sm-offset-1 > div > h2");

	// Order confirmation section.
	private final By OrderPlacedTitle = By.cssSelector("h2 > b");
	private final By ContinueBtn = By.cssSelector("a[href='/'][data-qa='continue-button']");
	private final By DownloadInvoiceBtn = By.cssSelector("a[class=\"btn btn-default check_out\"]");

	// ==========================================================
	// Actions
	// ==========================================================

	@Step("Get Payment heading text")
	public String isPaymentHeading() {
		return FW.MS_getText(PaymentHeading);
	}

	@Step("Enter payment details: Name = MUHAMMAD SAFWAT MUHAMMAD, Card = 1234 1234 1234 1234,"
			+ "CVC = 123, Expiry = 11/25")
	public void enterPaymentDetails(String name, String cardNumber, String cvc, String month, String year) {
		FW.MS_sendKeys(NameOnCardInput, name);
		FW.MS_sendKeys(CardNumberInput, cardNumber);
		FW.MS_sendKeys(CVCInput, cvc);
		FW.MS_sendKeys(ExpairyMonthInput, month);
		FW.MS_sendKeys(ExpairyYearInput, year);
		System.out.println("Entered Payment Details Successfully!");
	}

	@Step("Click Pay and Confirm Order button")
	public void clickPayAndConfirmOrder() {
		FW.MS_click(PayAndConfirmOrderBtn);
	}

	@Step("Scroll to payment section")
	public void scrollToElement() {
		FW.MS_scrollToElement(ScrollToTitle);
	}

	@Step("Get 'Order Placed' title")
	public String isOrderPlacedTitleVisible() {
		return FW.MS_getText(OrderPlacedTitle);
	}

	@Step("Click Continue button after placing order")
	public void clickContinueBtn() {
		FW.MS_click(ContinueBtn);
	}

	@Step("Download invoice file: invoice from C:\\Users\\MOCHA\\Downloads")
	public String testFileDownload(String downloadPath, String fileName) {
		FW.MS_click(DownloadInvoiceBtn);
		return FW.MS_isFileDownloaded(downloadPath, fileName);
	}
}