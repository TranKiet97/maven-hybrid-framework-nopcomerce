package pageObjects.nopcommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopcommerce.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
	WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextbox(String adminEmail) {
		waitForElementVisible(driver, AdminLoginPageUI.ADMIN_EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.ADMIN_EMAIL_TEXTBOX, adminEmail);
	}

	public void inputToPaswswordTextbox(String adminPassword) {
		waitForElementVisible(driver, AdminLoginPageUI.ADMIN_PASSWWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.ADMIN_PASSWWORD_TEXTBOX, adminPassword);
	}

	public AdminDashboardPageObject clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashboardPage(driver);
	}
	
	public AdminDashboardPageObject loginAsAdmin(String adminEmail, String adminPassword) {
		inputToEmailTextbox(adminEmail);
		inputToPaswswordTextbox(adminPassword);
		clickToLoginButton();
		return PageGeneratorManager.getAdminDashboardPage(driver);
	}
}
