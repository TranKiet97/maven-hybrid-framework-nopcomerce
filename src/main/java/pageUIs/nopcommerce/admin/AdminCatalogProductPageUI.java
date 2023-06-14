package pageUIs.nopcommerce.admin;

public class AdminCatalogProductPageUI {
	public static final String PRODUCT_NAME_TEXTBOX = "xpath=//input[@id='SearchProductName']";
	public static final String CATEGORY_DROPDOWN = "xpath=//select[@id='SearchCategoryId']";
	public static final String MANUFACTURER_DROPDOWN = "xpath=//select[@id='SearchManufacturerId']";
	public static final String SEARCH_INCLUDE_SUBCATEGORIES_CHECKBOX = "xpath=//input[@id='SearchIncludeSubCategories']";
	public static final String SEARCH_PRODUCT_BUTTON = "xpath=//button[@id='search-products']";
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//thead//th[text()='%s']/preceding-sibling::th";
	public static final String VALUE_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody//tr[%s]//td[%s]";
	public static final String EMPTY_DATA_NOTIFICATION = "xpath=//td[@class='dataTables_empty']";
}
