package pageObjects.nopcommerce.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.nopcommerce.user.ComputerPageUI;

public class ComputerPageObject extends BasePage{
	WebDriver driver;
	public ComputerPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void clickToCategoryByText(String categoryName) {
		waitForElementClickable(driver, ComputerPageUI.CATEGORY_BY_TEXT, categoryName);
		clickToElement(driver, ComputerPageUI.CATEGORY_BY_TEXT, categoryName);
	}
	public void clickToSubCategoryByText(String subcategoryName) {
		waitForElementClickable(driver, ComputerPageUI.SUBCATEGORY_BY_TEXT, subcategoryName);
		clickToElement(driver, ComputerPageUI.SUBCATEGORY_BY_TEXT, subcategoryName);
	}
	public void selectSortByDropdown(String sortType) {
		waitForElementClickable(driver, ComputerPageUI.SORT_TYPE);
		selectItemInDefaultDropdown(driver, ComputerPageUI.SORT_TYPE, sortType);
		sleepInSecond(1);
	}
	public boolean isTheProductBeSortAscendingByName() {
		ArrayList<String> productNameUIList = new ArrayList<String>();
		List<WebElement> productTitleElements = getListWebElements(driver, ComputerPageUI.PRODUCT_TITLE);
		
		for (WebElement productTitle : productTitleElements) {
			productNameUIList.add(productTitle.getText());
		}
		
		ArrayList<String> productNameSortList = new ArrayList<String>();
		for (String productNameUI : productNameUIList) {
			productNameSortList.add(productNameUI);
			System.out.println("product in UI: " + productNameUI);
		}
		
		Collections.sort(productNameSortList);
		return productNameSortList.equals(productNameUIList);
	}
	public boolean isTheProductBeSortDescendingByName() {
		ArrayList<String> productNameUIList = new ArrayList<String>();
		List<WebElement> productTitleElements = getListWebElements(driver, ComputerPageUI.PRODUCT_TITLE);
		
		for (WebElement productTitle : productTitleElements) {
			productNameUIList.add(productTitle.getText());
		}
		
		ArrayList<String> productNameSortList = new ArrayList<String>();
		for (String productNameUI : productNameUIList) {
			productNameSortList.add(productNameUI);
			System.out.println("product in UI: " + productNameUI);
		}
		
		Collections.sort(productNameSortList);
		Collections.reverse(productNameSortList);
		return productNameSortList.equals(productNameUIList);
	}
	public boolean isTheProductBeSortAscendingByPrice() {
		ArrayList<Float> productPriceUIList = new ArrayList<Float>();
		List<WebElement> productPriceElements = getListWebElements(driver, ComputerPageUI.PRODUCT_PRICE);
		
		for (WebElement productPrice : productPriceElements) {
			productPriceUIList.add(Float.parseFloat(productPrice.getText().replace("$", "").replace(",", "")));
		}
		
		ArrayList<Float> productPriceSortList = new ArrayList<Float>();
		for (Float productPriceUI : productPriceUIList) {
			productPriceSortList.add(productPriceUI);
			System.out.println("product in UI: " + productPriceUI);
		}
		
		Collections.sort(productPriceSortList);
		return productPriceSortList.equals(productPriceUIList);
	}
	public boolean isTheProductBeSortDescendingByPrice() {
		ArrayList<Float> productPriceUIList = new ArrayList<Float>();
		List<WebElement> productPriceElements = getListWebElements(driver, ComputerPageUI.PRODUCT_PRICE);
		
		for (WebElement productPrice : productPriceElements) {
			productPriceUIList.add(Float.parseFloat(productPrice.getText().replace("$", "").replace(",", "")));
		}
		
		ArrayList<Float> productPriceSortList = new ArrayList<Float>();
		for (Float productPriceUI : productPriceUIList) {
			productPriceSortList.add(productPriceUI);
			System.out.println("product in UI: " + productPriceUI);
		}
		
		Collections.sort(productPriceSortList);
		Collections.reverse(productPriceSortList);
		return productPriceSortList.equals(productPriceUIList);
	}
	public void selectDisplayDropdown(String numOfProduct) {
		waitForElementClickable(driver, ComputerPageUI.PRODUCT_DISPLAYED_PER_PAGE);
		selectItemInDefaultDropdown(driver, ComputerPageUI.PRODUCT_DISPLAYED_PER_PAGE, numOfProduct);
		sleepInSecond(1);
	}
	public int getNumberOfProductOnPage() {
		return getListWebElements(driver, ComputerPageUI.PRODUCT_TITLE).size();
	}
	public boolean isNavigateBarDisplayed() {
		return isElementDisplayed(driver, ComputerPageUI.NAVIGATION_BAR);
	}
	
	public boolean isNavigateBarUndisplayed() {
		return isElementUndisplayed(driver, ComputerPageUI.NAVIGATION_BAR);
	}
	
}
