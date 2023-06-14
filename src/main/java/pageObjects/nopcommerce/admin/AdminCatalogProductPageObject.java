package pageObjects.nopcommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.nopcommerce.admin.AdminBasePageUI;
import pageUIs.nopcommerce.admin.AdminCatalogProductPageUI;

public class AdminCatalogProductPageObject extends BasePage{
	WebDriver driver;
	public AdminCatalogProductPageObject(WebDriver driver) {
		this.driver = driver;
	}
	@Step("Search with Product Name: {0}")
	public void searchWithProductName(String productName) {
		waitForElementVisible(driver, AdminCatalogProductPageUI.PRODUCT_NAME_TEXTBOX);
		sendkeyToElement(driver, AdminCatalogProductPageUI.PRODUCT_NAME_TEXTBOX, productName);
		waitForElementClickable(driver, AdminCatalogProductPageUI.SEARCH_PRODUCT_BUTTON);
		clickToElement(driver, AdminCatalogProductPageUI.SEARCH_PRODUCT_BUTTON);
		waitForElementInvisible(driver, AdminBasePageUI.LOADING_ICON);
	}
	@Step("Verify {0} Information is Displayed Correctly")
	public String getProductNameInTable(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, AdminCatalogProductPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementVisible(driver, AdminCatalogProductPageUI.VALUE_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		return getElementText(driver, AdminCatalogProductPageUI.VALUE_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
	}
	@Step("Search with Product Name: {0} and Parent Category: 'Computers'")
	public void searchWithProductNameParentCategoryExludeSubCategories(String productName, String categoryType) {
		waitForElementVisible(driver, AdminCatalogProductPageUI.PRODUCT_NAME_TEXTBOX);
		sendkeyToElement(driver, AdminCatalogProductPageUI.PRODUCT_NAME_TEXTBOX, productName);
		waitForElementClickable(driver, AdminCatalogProductPageUI.CATEGORY_DROPDOWN);
		selectItemInDefaultDropdown(driver, AdminCatalogProductPageUI.CATEGORY_DROPDOWN, categoryType);
		waitForElementClickable(driver, AdminCatalogProductPageUI.SEARCH_INCLUDE_SUBCATEGORIES_CHECKBOX);
		uncheckToDefaultCheckbox(driver, AdminCatalogProductPageUI.SEARCH_INCLUDE_SUBCATEGORIES_CHECKBOX);
		waitForElementClickable(driver, AdminCatalogProductPageUI.SEARCH_PRODUCT_BUTTON);
		clickToElement(driver, AdminCatalogProductPageUI.SEARCH_PRODUCT_BUTTON);
		waitForElementInvisible(driver, AdminBasePageUI.LOADING_ICON);
	}
	@Step("Verify the Information is Displayed in Table: 'No data available in table'")
	public String getEmptyDataNoti() {
		waitForElementVisible(driver, AdminCatalogProductPageUI.EMPTY_DATA_NOTIFICATION);
		return getElementText(driver, AdminCatalogProductPageUI.EMPTY_DATA_NOTIFICATION);
	}
	@Step("Search with Product Name: {0} and Parent Category: 'Computers' and sub-Categories is selected")
	public void searchWithProductNameParentCategoryInludeSubCategories(String productName, String categoryType) {
		waitForElementVisible(driver, AdminCatalogProductPageUI.PRODUCT_NAME_TEXTBOX);
		sendkeyToElement(driver, AdminCatalogProductPageUI.PRODUCT_NAME_TEXTBOX, productName);
		waitForElementClickable(driver, AdminCatalogProductPageUI.CATEGORY_DROPDOWN);
		selectItemInDefaultDropdown(driver, AdminCatalogProductPageUI.CATEGORY_DROPDOWN, categoryType);
		waitForElementClickable(driver, AdminCatalogProductPageUI.SEARCH_INCLUDE_SUBCATEGORIES_CHECKBOX);
		checkToDefaultCheckboxRadio(driver, AdminCatalogProductPageUI.SEARCH_INCLUDE_SUBCATEGORIES_CHECKBOX);
		waitForElementClickable(driver, AdminCatalogProductPageUI.SEARCH_PRODUCT_BUTTON);
		clickToElement(driver, AdminCatalogProductPageUI.SEARCH_PRODUCT_BUTTON);
		waitForElementInvisible(driver, AdminBasePageUI.LOADING_ICON);
	}
	@Step("Search with Product Name: {0} and Parent Category: 'Computers >> Desktops'")
	public void searchWithProductNameChildCategory(String productName, String categoryType) {
		waitForElementVisible(driver, AdminCatalogProductPageUI.PRODUCT_NAME_TEXTBOX);
		sendkeyToElement(driver, AdminCatalogProductPageUI.PRODUCT_NAME_TEXTBOX, productName);
		waitForElementClickable(driver, AdminCatalogProductPageUI.CATEGORY_DROPDOWN);
		selectItemInDefaultDropdown(driver, AdminCatalogProductPageUI.CATEGORY_DROPDOWN, categoryType);
		waitForElementClickable(driver, AdminCatalogProductPageUI.SEARCH_INCLUDE_SUBCATEGORIES_CHECKBOX);
		uncheckToDefaultCheckbox(driver, AdminCatalogProductPageUI.SEARCH_INCLUDE_SUBCATEGORIES_CHECKBOX);
		waitForElementClickable(driver, AdminCatalogProductPageUI.SEARCH_PRODUCT_BUTTON);
		clickToElement(driver, AdminCatalogProductPageUI.SEARCH_PRODUCT_BUTTON);
		waitForElementInvisible(driver, AdminBasePageUI.LOADING_ICON);
	}
	@Step("Search with Product Name: {0} and Parent Category: 'All' and Manufacturer: 'Apple'")
	public void searchWithProductNameAllCategoryManufacturer(String productName, String categoryType, String Manufacturer) {
		waitForElementVisible(driver, AdminCatalogProductPageUI.PRODUCT_NAME_TEXTBOX);
		sendkeyToElement(driver, AdminCatalogProductPageUI.PRODUCT_NAME_TEXTBOX, productName);
		waitForElementClickable(driver, AdminCatalogProductPageUI.CATEGORY_DROPDOWN);
		selectItemInDefaultDropdown(driver, AdminCatalogProductPageUI.CATEGORY_DROPDOWN, categoryType);
		waitForElementClickable(driver, AdminCatalogProductPageUI.MANUFACTURER_DROPDOWN);
		selectItemInDefaultDropdown(driver, AdminCatalogProductPageUI.MANUFACTURER_DROPDOWN, Manufacturer);
		waitForElementClickable(driver, AdminCatalogProductPageUI.SEARCH_INCLUDE_SUBCATEGORIES_CHECKBOX);
		uncheckToDefaultCheckbox(driver, AdminCatalogProductPageUI.SEARCH_INCLUDE_SUBCATEGORIES_CHECKBOX);
		waitForElementClickable(driver, AdminCatalogProductPageUI.SEARCH_PRODUCT_BUTTON);
		clickToElement(driver, AdminCatalogProductPageUI.SEARCH_PRODUCT_BUTTON);
		waitForElementInvisible(driver, AdminBasePageUI.LOADING_ICON);
	}
}
