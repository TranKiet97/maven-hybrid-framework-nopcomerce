package pageObjects.nopcommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.nopcommerce.admin.AdminDashboardPageUI;

public class AdminDashboardPageObject extends BasePage {
	WebDriver driver;

	public AdminDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDashboardHeaderDisplayed() {
		waitForElementVisible(driver, AdminDashboardPageUI.DASHBOARD_HEADER);
		return isElementDisplayed(driver, AdminDashboardPageUI.DASHBOARD_HEADER);
	}

	public void openCatalogProductPage() {
		waitForElementVisible(driver, AdminDashboardPageUI.NAVIGATE_TAB, "Catalog");
		if(getElementAttribute(driver, AdminDashboardPageUI.NAVIGATE_TAB, "class", "Catalog").contains("menu-open")) {
			waitForElementClickable(driver, AdminDashboardPageUI.NAVIGATE_LINK, "Product");
			clickToElement(driver, AdminDashboardPageUI.NAVIGATE_LINK, "Product");
		} else {
			clickToElement(driver, AdminDashboardPageUI.NAVIGATE_TAB, "Catalog");
			waitForElementClickable(driver, AdminDashboardPageUI.NAVIGATE_LINK, "Product");
			clickToElement(driver, AdminDashboardPageUI.NAVIGATE_LINK, "Product");
		}
	}

	public void clickToCatalogTab() {
		waitForElementVisible(driver, AdminDashboardPageUI.NAVIGATE_TAB, "Catalog");
		clickToElement(driver, AdminDashboardPageUI.NAVIGATE_TAB, "Catalog");
	}

	@Step("Navigate to 'Product' Page")
	public void openProductPage() {
		waitForElementClickable(driver, AdminDashboardPageUI.NAVIGATE_LINK, "Product");
		clickToElement(driver, AdminDashboardPageUI.NAVIGATE_LINK, "Product");
	}
	
}
