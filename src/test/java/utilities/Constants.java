package utilities;

/**
 * Centralized application constants. Contains URLs, resource paths, expected
 * messages, and reusable values used across the test framework.
 */
public final class Constants {

	private Constants() {
		// Prevent instantiation.
	}

	// ==========================================================
	// Application
	// ==========================================================

	// Application base URL.
	public static final String BASE_URL = "https://automationexercise.com";

	// ==========================================================
	// Test Data
	// ==========================================================

	// JSON test data file.
	public static final String TEST_DATA_FILE = "testdata/testData.json";

	// ==========================================================
	// Expected Messages
	// ==========================================================

	public static final String HOME_PAGE = "AutomationExercise";
	public static final String LOGIN_TO_YOUR_ACCOUNT = "Login to your account";
	public static final String NEW_USER_SIGNUP = "New User Signup!";
	public static final String ENTER_ACCOUNT_INFORMATION = "ENTER ACCOUNT INFORMATION";
	public static final String ACCOUNT_CREATED = "ACCOUNT CREATED!";
	public static final String ACCOUNT_DELETED = "ACCOUNT DELETED!";
	public static final String LOGGED_IN_AS = "Logged in as";
	public static final String LOGIN_ERROR = "Your email or password is incorrect!";
	public static final String EMAIL_ALREADY_EXISTS = "Email Address already exist!";
	public static final String GET_IN_TOUCH = "GET IN TOUCH";
	public static final String SUBSCRIPTION = "SUBSCRIPTION";
	public static final String SUBSCRIPTION_SUCCESS = "You have been successfully subscribed!";
	public static final String ALL_PRODUCTS = "ALL PRODUCTS";
	public static final String SEARCHED_PRODUCTS = "SEARCHED PRODUCTS";
	public static final String PAYMENT = "Payment";
	public static final String ORDER_PLACED = "ORDER PLACED!";

	// ==========================================================
	// Contact Us
	// ==========================================================

	public static final String SUCCESS_MESSAGE = "Success!";

	// ==========================================================
	// Test Cases
	// ==========================================================

	public static final String TEST_CASES = "TEST CASES";

	// ==========================================================
	// Product Details
	// ==========================================================

	public static final String CATEGORY = "Category:";
	public static final String AVAILABILITY = "Availability:";
	public static final String CONDITION = "Condition:";
	public static final String BRAND = "Brand:";
	public static final String BLUE_TOP = "Blue Top";
	public static final String PRODUCT_PRICE = "500";

	// ==========================================================
	// Cart
	// ==========================================================

	public static final String SHOPPING_CART = "Shopping Cart";
	public static final String SUCCESSFULLY = "successfully";
	public static final String CART_PRODUCT_NOT_VISIBLE = "Cart Products not Visible!";

	// ==========================================================
	// Checkout
	// ==========================================================

	public static final String YOUR_DELIVERY_ADDRESS = "YOUR DELIVERY ADDRESS";
	public static final String YOUR_BILLING_ADDRESS = "YOUR BILLING ADDRESS";
	public static final String QUANTITY_IS_NOT_CORRECT = "Quantity in Cart isn't Correct!";

	// ==========================================================
	// Categories & Brands
	// ==========================================================

	public static final String BRANDS = "BRANDS";

	// ==========================================================
	// Reviews
	// ==========================================================

	public static final String WRITE_YOUR_REVIEW = "WRITE YOUR REVIEW";
	public static final String THANK_YOU_FOR_REVIEW = "Thank you for your review.";

	// ==========================================================
	// Home Page
	// ==========================================================

	public static final String RECOMMENDED_ITEMS = "RECOMMENDED ITEMS";
	public static final String FULL_FLEDGED = "Full-Fledged";

	// ==========================================================
	// Download & Products
	// ==========================================================

	public static final String FIRST_PRODUCT = "Premium Polo T-Shirts";
	public static final String SECOND_PRODUCT = "Regular Fit Straight Jeans";
	public static final String INVOICE = "invoice";
}