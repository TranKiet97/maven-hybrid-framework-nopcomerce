package pageObjects.nopcommerce.user;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.nopcommerce.user.SearchPageUI;

public class SearchPageObject extends BasePage{
	WebDriver driver;

	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, SearchPageUI.SEARCH_PRODUCT_BUTTON);
		clickToElement(driver, SearchPageUI.SEARCH_PRODUCT_BUTTON);
	}

	public String getErrorMessageTextByType(String classValue) {
		waitForElementVisible(driver, SearchPageUI.ERROR_MESSAGE_BY_TYPE, classValue);
		return getElementText(driver, SearchPageUI.ERROR_MESSAGE_BY_TYPE, classValue);
	}

	public void inputToSearchKeywordTextbox(String notExistProduct) {
		waitForElementVisible(driver, SearchPageUI.SEARCH_KEYWORD_TEXTBOX);
		sendkeyToElement(driver, SearchPageUI.SEARCH_KEYWORD_TEXTBOX, notExistProduct);
	}

	public ArrayList<String> getAllDisplayedProducts() {
		List<WebElement> productTitleElements = getListWebElements(driver, SearchPageUI.DISPLAYED_PRODUCT_TITLE);
		ArrayList<String> productName = new ArrayList<String>();
		for (WebElement productTitleElement : productTitleElements) {
			productName.add(productTitleElement.getText());
		}
		return productName;
	}

	public String getDisplayedProduct() {
		waitForElementVisible(driver, SearchPageUI.DISPLAYED_PRODUCT_TITLE);
		return getElementText(driver, SearchPageUI.DISPLAYED_PRODUCT_TITLE);
	}

	public void clickToCheckboxByLabel(String label) {
		waitForElementClickable(driver, SearchPageUI.CHECKBOX_BY_LABEL, label);
		checkToDefaultCheckboxRadio(driver, SearchPageUI.CHECKBOX_BY_LABEL, label);
	}

	public void selectCategoryDropdown(String category) {
		waitForElementClickable(driver, SearchPageUI.CATEGORIES_DROPDOWN);
		selectItemInDefaultDropdown(driver, SearchPageUI.CATEGORIES_DROPDOWN, category);
	}

	public void selectManufacturerDropdown(String manufacturer) {
		waitForElementClickable(driver, SearchPageUI.MANUFACTURER_DROPDOWN);
		selectItemInDefaultDropdown(driver, SearchPageUI.MANUFACTURER_DROPDOWN, manufacturer);
	}
	
}
