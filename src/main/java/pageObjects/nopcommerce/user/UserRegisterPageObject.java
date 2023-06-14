package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopcommerce.user.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {
	
	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
	}

	public UserHomePageObject clickToContinueButton() {
		waitForElementClickable(driver, UserRegisterPageUI.CONTINUE_BUTTON);
		clickToElement(driver, UserRegisterPageUI.CONTINUE_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}
	
	public String getErrorMessageAtFirtNameTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.FIRSTNAME_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.FIRSTNAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtLastNameTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.LASTNAME_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.LASTNAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.CONFIRMPASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.CONFIRMPASSWORD_ERROR_MESSAGE);
	}
	
	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}
	
	public String getExistedEmailErrorMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.EXISTED_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.EXISTED_EMAIL_ERROR_MESSAGE);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX, firstName);	
	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, UserRegisterPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.LASTNAME_TEXTBOX, lastName);
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, UserRegisterPageUI.CONFIRMPASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.CONFIRMPASSWORD_TEXTBOX, confirmPassword);
	}

	private WebDriver driver;
	
}
