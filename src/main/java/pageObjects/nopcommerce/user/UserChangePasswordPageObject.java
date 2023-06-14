package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.user.UserChangePasswordPageUI;

public class UserChangePasswordPageObject extends BasePage {
	WebDriver driver;

	public UserChangePasswordPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToOldPasswordTextbox(String currentPassword) {
		waitForElementVisible(driver, UserChangePasswordPageUI.CURRENT_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserChangePasswordPageUI.CURRENT_PASSWORD_TEXTBOX, currentPassword);
	}

	public void inputToNewPasswordTextbox(String newPassword) {
		waitForElementVisible(driver, UserChangePasswordPageUI.NEW_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserChangePasswordPageUI.NEW_PASSWORD_TEXTBOX, newPassword);
	}

	public void inputToConfirmPasswordTextbox(String newPassword) {
		waitForElementVisible(driver, UserChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX, newPassword);
	}

	public void clickToChangePasswrodButton() {
		waitForElementClickable(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, UserChangePasswordPageUI.CLOSE_BUTTON);
	}
	
}
