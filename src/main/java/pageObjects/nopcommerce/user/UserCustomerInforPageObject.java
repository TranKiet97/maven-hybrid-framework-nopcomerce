package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.user.UserCustomerInforPageUI;

public class UserCustomerInforPageObject extends BasePage {
	WebDriver driver;

	public UserCustomerInforPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectGender(String gender) {
		switch (gender) {
		case "Male":
			waitForElementClickable(driver, UserCustomerInforPageUI.GENDER_MALE);
			checkToDefaultCheckboxRadio(driver, UserCustomerInforPageUI.GENDER_MALE);
			break;
		case "Female":
			waitForElementClickable(driver, UserCustomerInforPageUI.GENDER_FEMALE);
			checkToDefaultCheckboxRadio(driver, UserCustomerInforPageUI.GENDER_FEMALE);
			break;
		}
	}

	public void inputToFirstNameTextbox(String firstname) {
		waitForElementVisible(driver, UserCustomerInforPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInforPageUI.FIRSTNAME_TEXTBOX, firstname);
	}

	public void inputToLastNameTextbox(String lastname) {
		waitForElementVisible(driver, UserCustomerInforPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInforPageUI.LASTNAME_TEXTBOX, lastname);
	}

	public void selectDayOfBirth(String dayOfBirth) {
		waitForElementVisible(driver, UserCustomerInforPageUI.DAY_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserCustomerInforPageUI.DAY_DROPDOWN, dayOfBirth);
	}

	public void selectMonthOfBirth(String monthOfBirth) {
		waitForElementVisible(driver, UserCustomerInforPageUI.MONTH_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserCustomerInforPageUI.MONTH_DROPDOWN, monthOfBirth);
	}

	public void selectYearOfBirth(String yearOfBirth) {
		waitForElementVisible(driver, UserCustomerInforPageUI.YEAR_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserCustomerInforPageUI.YEAR_DROPDOWN, yearOfBirth);
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, UserCustomerInforPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInforPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToCompanyTextbox(String companyName) {
		waitForElementVisible(driver, UserCustomerInforPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInforPageUI.COMPANY_TEXTBOX, companyName);
	}

	public void clickToSaveButton() {
		waitForElementClickable(driver, UserCustomerInforPageUI.SAVE_BUTTON);
		clickToElement(driver, UserCustomerInforPageUI.SAVE_BUTTON);
		clickToElementByJS(driver, UserCustomerInforPageUI.CLOSE_BUTTON);
	}
	
	public boolean isSelectedGenderFemale() {
		return isElementSelected(driver, UserCustomerInforPageUI.GENDER_FEMALE);
	}

	public boolean isSelectedGenderMale() {
			return isElementSelected(driver, UserCustomerInforPageUI.GENDER_MALE);
	}

	public String getFirstNameValue() {
		return getElementAttribute(driver, UserCustomerInforPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getLastNameValue() {
		return getElementAttribute(driver, UserCustomerInforPageUI.LASTNAME_TEXTBOX, "value");
	}

	public String getDayOfBirthValue() {
		return getSelectedItemInDefaultDropdown(driver, UserCustomerInforPageUI.DAY_DROPDOWN);
	}

	public String getMonthOfBirthValue() {
		return getSelectedItemInDefaultDropdown(driver, UserCustomerInforPageUI.MONTH_DROPDOWN);
	}

	public String getYearOfBirthValue() {
		return getSelectedItemInDefaultDropdown(driver, UserCustomerInforPageUI.YEAR_DROPDOWN);
	}

	public String getEmailValue() {
		return getElementAttribute(driver, UserCustomerInforPageUI.EMAIL_TEXTBOX, "value");
	}

	public String getCompanyValue() {
		return getElementAttribute(driver, UserCustomerInforPageUI.COMPANY_TEXTBOX, "value");
	}


}
