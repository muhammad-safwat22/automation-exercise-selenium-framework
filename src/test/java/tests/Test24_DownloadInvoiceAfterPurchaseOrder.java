package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import utilities.Constants;

/**
 * Test Case 24 Verify that a user can place an order, complete the payment
 * process, and successfully download the invoice.
 */
public class Test24_DownloadInvoiceAfterPurchaseOrder extends BaseTest {

	@Test(priority = 24)
	@Epic("Checkout Flow")
	@Feature("Order Management")
	@Story("Place order and download invoice")
	@Description("Verify that a user can place an order, confirm payment, and successfully download the invoice")
	@Severity(SeverityLevel.CRITICAL)
	public void testDownloadInvoiceAfterPurchaseOrder() {

		// Add two products to the shopping cart
		homePage.hoverAndClickAddFirstProduct();
		homePage.clickContinueShoppingBtn();
		homePage.hoverAndClickAddSecondProduct();
		homePage.clickContinueShoppingBtn();

		// Navigate to the Cart page
		homePage.clickCartBtn();

		// Verify that the Shopping Cart page is displayed
		Assert.assertTrue(cartPage.isShoppingCartMsgVisible().contains(Constants.SHOPPING_CART),
				"'Shopping Cart' Should Be Visible!");

		// Proceed to checkout and navigate to the Login/Register page
		cartPage.clickProceedToCheckout();
		cartPage.clickCheckoutRegisterLoginBtn();

		// Register a new user account
		completeRegistration();

		// Return to the Cart page
		homePage.clickCartBtn();

		// Complete the purchase and download the invoice
		downloadFile();

		// Delete the created account as part of test cleanup
		deleteUser();

	}
}