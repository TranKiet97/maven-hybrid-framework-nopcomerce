package pageUIs.nopcommerce.user;

public class ComputerPageUI {
	public static final String CATEGORY_BY_TEXT = "xpath=//div[@class='side-2']//a[contains(text(), '%s')]";
	public static final String SUBCATEGORY_BY_TEXT = "xpath=//ul[@class='sublist']//a[contains(text(), '%s')]";
	public static final String SORT_TYPE = "xpath=//select[@id='products-orderby']";
	public static final String PRODUCT_TITLE = "xpath=//h2[@class='product-title']/a";
	public static final String PRODUCT_PRICE = "xpath=//div[@class='add-info']//span";
	public static final String PRODUCT_DISPLAYED_PER_PAGE = "xpath=//select[@id='products-pagesize']";
	public static final String NAVIGATION_BAR = "xpath=//div[@class='pager']";
}
