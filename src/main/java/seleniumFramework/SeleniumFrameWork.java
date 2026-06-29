/*

			SeleniumFrameWork - Quick Notes

=========================================================

## Purpose:

Reusable Selenium Wrapper Framework that centralizes
browser actions, waits, element interactions, alerts,
window handling, validations, and utility functions.

=========================================================
METHOD CATEGORIES
==================

## [01] Browser Initialization & Wait Management ##

MS_initializeBrowser()
→ Open browser and create WebDriver.

MS_implicitWait()
→ Global wait for elements.

MS_explicitWait()
→ Wait until element exists.

MS_fluentWait()
→ Advanced wait with custom timeout.

//////////////////////////////////////////

## [02] Navigation Methods ##

MS_navigateToURL()
→ Open URL.

MS_getPageTitle()
→ Get page title.

MS_getCurrentURL()
→ Get current URL.

MS_navigateBack()
→ Go back.

MS_navigateForward()
→ Go forward.

MS_refreshPage()
→ Refresh page.

//////////////////////////////////////////

## [03] Element Interaction Methods ##

MS_click()
→ Click element.

MS_sendKeys()
→ Enter text.

MS_getText()
→ Get element text.
→ Get raw element text.

//////////////////////////////////////////

## [04] Dropdown Handling Methods ##

MS_selectDropdownByVisibleText()
→ Select option by text.

MS_selectDropdownByValue()
→ Select option by value.

MS_selectDropdownByIndex()
→ Select option by index.

//////////////////////////////////////////

## [05] Advanced Mouse Actions ##

MS_hoverOverElement()
→ Hover over element.

MS_rightClick()
→ Right click element.

MS_dragAndDrop()
→ Drag and drop element.

MS_scrollToElement()
→ Scroll to element.

//////////////////////////////////////////

## [06] Checkbox & Radio Button Methods ##

MS_checkCheckbox()
→ Check checkbox.

MS_uncheckCheckbox()
→ Uncheck checkbox.

MS_selectRadioButton()
→ Select radio button.

//////////////////////////////////////////

## [07] Window Handling Methods ##

MS_switchToWindowByTitle()
→ Switch window using title.

MS_switchToWindowByHandle()
→ Switch window using handle.

MS_closeCurrentWindow()
→ Close active window.

//////////////////////////////////////////

## [08] Alert Handling Methods ##

MS_acceptAlert()
→ Click OK.

MS_dismissAlert()
→ Click Cancel.

MS_getAlertText()
→ Get alert message.

MS_sendTextToAlert()
→ Enter text into alert.

//////////////////////////////////////////

## [09] Element Validation Methods ##

MS_isElementDisplayed()
→ Verify element is visible.

MS_isElementEnabled()
→ Verify element is enabled.

MS_isElementSelected()
→ Verify checkbox/radio button state.

//////////////////////////////////////////

## [10] Element Collection Methods ##

MS_findElements()
→ Get list of elements.

//////////////////////////////////////////

## [11] Element Utilities Methods ##

MS_Elements_count()
→ Count elements.

MS_getElementText()
→ Get cleaned text.
→ Get trimmed/cleaned element text.

MS_extractPrice()
→ Convert price text to integer.
Example:
"$500" → 500

MS_getElements()
→ Get all visible elements.

//////////////////////////////////////////

## [12] Input Field Methods ##

MS_clear()
→ Remove existing text from element.

//////////////////////////////////////////

## [13] File Validation Methods ##

MS_isFileDownloaded()
→ Verify file download.

//////////////////////////////////////////

## [14] Browser Cleanup Methods ##

MS_closeBrowser()
→ Close browser and end session.

=========================================================
Notes:
------

* All element interactions rely on Explicit Waits.
* Framework designed for reusable Page Objects.
* Supports UI validation, file downloads,
  alerts, windows, scrolling, and collections.
  =========================================================
  */

package seleniumFramework;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

//=====================================================
//Browser Initialization & Wait Management
//=====================================================

public class SeleniumFrameWork {

	private WebDriver driver;

	// Shared explicit wait instance used across framework methods
	private static WebDriverWait explicitWait;

	// Default timeout value (in seconds) used for waits
	private final int DEFAULT_TIMEOUT = 10;

	/*
	 * Initializes browser driver, maximizes browser window, and creates the default
	 * explicit wait object.
	 */
	public void MS_initializeBrowser() {

		// driver = new ChromeDriver();
		driver = new EdgeDriver();

		driver.manage().window().maximize();

		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));

		System.out.println("Msg: Browser Initialized.");
	}

	/*
	 * Sets global implicit wait for locating elements.
	 *
	 * Use carefully when combining with Explicit Waits.
	 */
	public void MS_implicitWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));

		System.out.println("Msg: Set Implicit Wait to " + seconds + " seconds.");
	}

	/*
	 * Waits until an element is present in the DOM.
	 *
	 * Presence means the element exists in HTML, but it may not be visible or
	 * clickable.
	 */
	public void MS_explicitWait(By locator, int timeoutSeconds) {

		new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
				.until(ExpectedConditions.presenceOfElementLocated(locator));

		System.out.println("Msg: Explicit wait for presence of " + locator);
	}

	/*
	 * Fluent Wait: - Custom timeout - Custom polling interval - Ignores
	 * NoSuchElementException
	 *
	 * Useful for dynamic elements that appear after unpredictable loading times.
	 */
	public void MS_fluentWait(By locator, int timeoutSeconds, int pollingMillis, String timeoutMessage) {

		Wait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeoutSeconds))
				.pollingEvery(Duration.ofMillis(pollingMillis)).withMessage(timeoutMessage)
				.ignoring(NoSuchElementException.class);

		fluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		System.out.println("Msg: Fluent wait found element " + locator);
	}

	// =====================================================
	// Navigation Methods
	// =====================================================

	/*
	 * Opens the specified URL in the current browser window.
	 */
	public void MS_navigateToURL(String url) {
		driver.get(url);
		System.out.println("Msg: Navigated to URL: " + url);
	}

	/*
	 * Returns the current page title.
	 *
	 * Commonly used for page validation and assertions.
	 */
	public String MS_getPageTitle() {
		String title = driver.getTitle();
		System.out.println("Msg: Page title is '" + title + "'");
		return title;
	}

	/*
	 * Returns the current browser URL.
	 *
	 * Useful for navigation verification and redirects validation.
	 */
	public String MS_getCurrentURL() {
		String currentURL = driver.getCurrentUrl();
		System.out.println("Msg: Current URL is '" + currentURL + "'");
		return currentURL;
	}

	// =====================================================
	// Element Interaction Methods
	// =====================================================

	/*
	 * Waits until the element becomes clickable then performs a click action.
	 */
	public void MS_click(By locator) {
		explicitWait.until(ExpectedConditions.elementToBeClickable(locator)).click();
		System.out.println("Msg: Clicked element " + locator);
	}

	/*
	 * Performs a right-click (context click) on the specified element.
	 */
	public void MS_rightClick(By locator) {
		WebElement element = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
		System.out.println("Msg: Right-clicked on element " + locator);
	}

	/*
	 * Waits for the element to become visible then enters the provided text.
	 */
	public void MS_sendKeys(By locator, String text) {
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
		System.out.println("Msg: Sent keys to element " + locator);
	}

	/*
	 * Retrieves and returns the visible text from the specified element.
	 */
	public String MS_getText(By locator) {
		String text = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
		System.out.println("Msg: Got text from element " + locator + ": " + text);
		return text;
	}

	// =====================================================
	// Dropdown Handling Methods
	// =====================================================

	/*
	 * Selects an option from a dropdown menu using the visible text displayed to
	 * the user.
	 */
	public void MS_selectDropdownByVisibleText(By locator, String visibleText) {
		WebElement dropdown = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		Select select = new Select(dropdown);
		select.selectByVisibleText(visibleText);
		System.out.println("Msg: Selected dropdown value by visible text: " + visibleText);
	}

	/*
	 * Selects an option from a dropdown menu using the option's value attribute.
	 */
	public void MS_selectDropdownByValue(By locator, String value) {
		WebElement dropdown = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		Select select = new Select(dropdown);
		select.selectByValue(value);
		System.out.println("Msg: Selected dropdown value by value: " + value);
	}

	/*
	 * Selects an option from a dropdown menu using the option index.
	 *
	 * Index starts from 0.
	 */
	public void MS_selectDropdownByIndex(By locator, int index) {
		WebElement dropdown = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		Select select = new Select(dropdown);
		select.selectByIndex(index);
		System.out.println("Msg: Selected dropdown by index: " + index);
	}

	// =====================================================
	// Advanced Mouse Actions
	// =====================================================

	/*
	 * Drags an element from the source location and drops it onto the target
	 * element.
	 *
	 * Useful for drag-and-drop UI interactions.
	 */
	public void MS_dragAndDrop(By sourceLocator, By targetLocator) {
		WebElement source = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(sourceLocator));
		WebElement target = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(targetLocator));
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).perform();
		System.out.println("Msg: Dragged element " + sourceLocator + " and dropped on " + targetLocator);
	}

	// =====================================================
	// Checkbox & Radio Button Methods
	// =====================================================

	/*
	 * Selects a checkbox only if it is not already selected.
	 *
	 * Prevents unnecessary click actions.
	 */
	public void MS_checkCheckbox(By locator) {
		WebElement checkbox = explicitWait.until(ExpectedConditions.elementToBeClickable(locator));
		if (!checkbox.isSelected()) {
			checkbox.click();
			System.out.println("Msg: Checked the checkbox " + locator);
		} else {
			System.out.println("Msg: Checkbox already checked " + locator);
		}
	}

	/*
	 * Deselects a checkbox only if it is currently selected.
	 *
	 * Prevents unnecessary click actions.
	 */
	public void MS_uncheckCheckbox(By locator) {
		WebElement checkbox = explicitWait.until(ExpectedConditions.elementToBeClickable(locator));
		if (checkbox.isSelected()) {
			checkbox.click();
			System.out.println("Msg: Unchecked the checkbox " + locator);
		} else {
			System.out.println("Msg: Checkbox already unchecked " + locator);
		}
	}

	/*
	 * Selects a radio button if it is not already selected.
	 */
	public void MS_selectRadioButton(By locator) {
		WebElement radioButton = explicitWait.until(ExpectedConditions.elementToBeClickable(locator));
		if (!radioButton.isSelected()) {
			radioButton.click();
			System.out.println("Edges: Selected radio button " + locator);
		} else {
			System.out.println("Msg: Radio button already selected " + locator);
		}
	}

	// =====================================================
	// Window Handling Methods
	// =====================================================

	/*
	 * Switches to a browser window based on its title.
	 *
	 * If the target window is not found, the driver returns to the original window.
	 */
	public void MS_switchToWindowByTitle(String windowTitle) {
		String currentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();

		for (String window : allWindows) {
			driver.switchTo().window(window);
			if (driver.getTitle().equals(windowTitle)) {
				System.out.println("Msg: Switched to window with title: " + windowTitle);
				return;
			}
		}

		driver.switchTo().window(currentWindow);
		System.out.println("Msg: Window with title '" + windowTitle + "' not found. Stayed in original window.");
	}

	/*
	 * Switches to a browser window using its unique window handle.
	 *
	 * No action is performed if the handle does not exist.
	 */
	public void MS_switchToWindowByHandle(String windowHandle) {
		Set<String> allWindows = driver.getWindowHandles();
		if (allWindows.contains(windowHandle)) {
			driver.switchTo().window(windowHandle);
			System.out.println("Edges: Switched to window handle: " + windowHandle);
		} else {
			System.out.println("Msg: Window handle " + windowHandle + " does not exist. No switch performed.");
		}
	}

	/*
	 * Closes the currently active browser window.
	 *
	 * Does not terminate the entire browser session.
	 */
	public void MS_closeCurrentWindow() {
		driver.close();
		System.out.println("Msg: Closed current window.");
	}

	// =====================================================
	// Navigation Methods
	// =====================================================

	/*
	 * Navigates back to the previous page in the browser history.
	 */
	public void MS_navigateBack() {
		driver.navigate().back();
		System.out.println("Msg: Navigated back.");
	}

	/*
	 * Navigates forward to the next page in the browser history.
	 */
	public void MS_navigateForward() {
		driver.navigate().forward();
		System.out.println("Msg: Navigated forward.");
	}

	/*
	 * Refreshes the currently loaded page.
	 */
	public void MS_refreshPage() {
		driver.navigate().refresh();
		System.out.println("Msg: Page refreshed.");
	}

	// =====================================================
	// Scrolling & Viewport Methods
	// =====================================================

	/*
	 * Scrolls the page until the target element becomes visible in the viewport.
	 *
	 * Uses Selenium Actions API.
	 */
	public void MS_scrollToElement(By locator) {
		WebElement element = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		Actions actions = new Actions(driver);
		actions.scrollToElement(element).perform();
		System.out.println("Msg: Scrolled to element " + locator + " using Actions.scrollToElement().");
	}

	// =====================================================
	// Alert Handling Methods
	// =====================================================

	/*
	 * Accepts the currently displayed alert dialog.
	 *
	 * Equivalent to clicking "OK" or "Accept".
	 */
	public void MS_acceptAlert() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		System.out.println("Msg: Alert accepted.");
	}

	/*
	 * Dismisses the currently displayed alert dialog.
	 *
	 * Equivalent to clicking "Cancel".
	 */
	public void MS_dismissAlert() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.dismiss();
		System.out.println("Msg: Alert dismissed.");
	}

	/*
	 * Retrieves and returns the text displayed inside the alert dialog.
	 */
	public String MS_getAlertText() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		String text = alert.getText();
		System.out.println("Msg: Alert text: " + text);
		return text;
	}

	/*
	 * Enters text into a prompt alert and accepts the alert afterward.
	 */
	public void MS_sendTextToAlert(String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.sendKeys(text);
		alert.accept();
		System.out.println("Msg: Sent text to alert and accepted it: " + text);
	}

	// =====================================================
	// Element Validation Methods
	// =====================================================

	/*
	 * Verifies whether the specified element is displayed on the page.
	 *
	 * Returns: - true -> element is visible - false -> element is not visible
	 */
	public boolean MS_isElementDisplayed(By locator) {
		WebElement element = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		if (element.isDisplayed()) {
			System.out.println("The element is displayed: " + locator);
			return true;
		} else {
			System.out.println("The element is not displayed: " + locator);
			return false;
		}
	}

	/*
	 * Verifies whether the specified element is enabled.
	 *
	 * Returns: - true -> element is enabled - false -> element is disabled
	 */
	public boolean MS_isElementEnabled(By locator) {
		WebElement element = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		if (element.isEnabled()) {
			System.out.println("The element is enabled: " + locator);
			return true;
		} else {
			System.out.println("The element is disabled: " + locator);
			return false;
		}
	}

	/*
	 * Verifies whether the specified checkbox or radio button is selected.
	 *
	 * Returns: - true -> element is selected - false -> element is not selected
	 */
	public boolean MS_isElementSelected(By locator) {
		WebElement element = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		if (element.isSelected()) {
			System.out.println("The element is selected: " + locator);
			return true;
		} else {
			System.out.println("The element is not selected: " + locator);
			return false;
		}
	}

	// =====================================================
	// Mouse Actions Methods
	// =====================================================

	/*
	 * Moves the mouse cursor over the target element without performing a click
	 * action.
	 *
	 * Commonly used for menus and hidden elements.
	 */
	public void MS_hoverOverElement(By locator) {
		WebElement element = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		System.out.println("Msg: Hovered over element " + locator);
	}

	// =====================================================
	// Element Collection Methods
	// =====================================================

	/*
	 * Returns a list of elements matching the provided locator.
	 *
	 * Useful for tables, products, lists, and repeated UI components.
	 */
	public List<WebElement> MS_findElements(By locator) {
		List<WebElement> elements = driver.findElements(locator);
		System.out.println("Msg: Found " + elements.size() + " elements for " + locator);
		return elements;
	}

	// =====================================================
	// Element Utilities Methods
	// =====================================================

	/*
	 * Legacy implementation with Exception Handling. Replaced by a cleaner
	 * implementation that relies on Explicit Wait failure reporting.
	 */
	/*
	 * public int MS_Elements_count(By locator) { try { موجودة List<WebElement>
	 * elements =
	 * explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator)
	 * );
	 * 
	 * int size = elements.size(); System.out.println("Msg: Elements_count for " +
	 * locator + " = " + size); return size;
	 * 
	 * } catch (Exception e) {
	 * System.out.println("Msg: Error in Elements_count for " + locator + " - " +
	 * e.getMessage()); return 0; } }
	 */

	/*
	 * Returns the total number of elements matching the specified locator.
	 *
	 * Waits until at least one matching element is present in the DOM.
	 */
	public int MS_Elements_count(By locator) {
		List<WebElement> elements = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		int size = elements.size();
		System.out.println("Msg: Found " + size + " elements for locator: " + locator);
		return size;
	}

	/*
	 * Retrieves and returns trimmed text from the specified element.
	 *
	 * Commonly used for: - Prices - Quantities - Totals - Labels
	 */
	public String MS_getElementText(By locator) {
		WebElement element = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		String text = element.getText().trim();
		System.out.println("Msg: Got text from " + locator + " = " + text);
		return text;
	}

	/*
	 * Extracts numeric value from a price string.
	 *
	 * Examples: "$500" -> 500 "Rs. 500" -> 500 "USD 1200" -> 1200
	 */
	public int MS_extractPrice(String priceText) {
		// Remove everything except digits
		String numberOnly = priceText.replaceAll("[^0-9]", "");
		int value = Integer.parseInt(numberOnly);
		System.out.println("Msg: Converted price text '" + priceText + "' to integer: " + value);
		return value;
	}

	/*
	 * Returns all visible elements matching the specified locator.
	 *
	 * Useful for: - Product lists - Tables - Search results - Repeated UI
	 * components
	 */
	public List<WebElement> MS_getElements(By locator) {
		List<WebElement> elements = explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		System.out.println("Msg: Found " + elements.size() + " elements for " + locator);
		return elements;
	}

	// =====================================================
	// Input Field Methods
	// =====================================================

	/*
	 * Clears any existing text from the specified input field.
	 */
	public void MS_clear(By locator) {
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator)).clear();
		System.out.println("Msg: Cleared text from element " + locator);
	}

	// =====================================================
	// File Validation Methods
	// =====================================================

	/*
	 * Waits until a file is downloaded in the specified directory.
	 *
	 * Returns: - Downloaded file name if found - Empty string if file is not found
	 */
	public String MS_isFileDownloaded(String downloadPath, String fileName) {
		File folder = new File(downloadPath);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		/*
		 * Wait until a file matching the expected name appears.
		 * 
		 * (Note: _ -> wd, _ ->dir)
		 */
		File downloadedFile = wait.until((ExpectedCondition<File>) wd -> {
			File[] files = folder.listFiles((dir, name) -> name.contains(fileName));
			return (files != null && files.length > 0) ? files[0] : null;
		});

		if (downloadedFile != null) {
			System.out.println("File downloaded: " + downloadedFile.getName());
			return downloadedFile.getName();
		} else {
			System.out.println("File not found containing: " + fileName);
			return "";
		}
	}

	// =====================================================
	// Browser Cleanup Methods
	// =====================================================

	/*
	 * Terminates the browser session and closes all opened browser windows.
	 */
	public void MS_closeBrowser() {
		if (driver != null) {
			driver.quit();
			System.out.println("Msg: Browser Closed.");
		}
	}
}