package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.user.UserAddressesPageUI;

public class UserAddressesPageObject extends BasePage {
	WebDriver driver;

	public UserAddressesPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAddNewAddressButton() {
		waitForElementClickable(driver, UserAddressesPageUI.ADD_NEW_ADDRESS_BUTTON);
		clickToElement(driver,  UserAddressesPageUI.ADD_NEW_ADDRESS_BUTTON);
	}

	public void inputToFirstNameTextbox(String firstname) {
		waitForElementVisible(driver, UserAddressesPageUI.ADDRESS_FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, UserAddressesPageUI.ADDRESS_FIRSTNAME_TEXTBOX, firstname);
	}

	public void inputToLastNameTextbox(String lastname) {
		waitForElementVisible(driver, UserAddressesPageUI.ADDRESS_LASTNAME_TEXTBOX);
		sendkeyToElement(driver, UserAddressesPageUI.ADDRESS_LASTNAME_TEXTBOX, lastname);
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, UserAddressesPageUI.ADDRESS_EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserAddressesPageUI.ADDRESS_EMAIL_TEXTBOX, email);
	}

	public void inputToCompanyTextbox(String company) {
		waitForElementVisible(driver, UserAddressesPageUI.ADDRESS_COMPANY_TEXTBOX);
		sendkeyToElement(driver, UserAddressesPageUI.ADDRESS_COMPANY_TEXTBOX, company);
	}

	public void selectCountry(String country) {
		waitForElementVisible(driver, UserAddressesPageUI.ADDRESS_COUNTRY_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserAddressesPageUI.ADDRESS_COUNTRY_DROPDOWN, country);
	}
	
	public void selectState(String state) {
		waitForElementVisible(driver, UserAddressesPageUI.ADDRESS_STATE_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserAddressesPageUI.ADDRESS_STATE_DROPDOWN, state);
	}

	public void inputToCityTextbox(String city) {
		waitForElementVisible(driver, UserAddressesPageUI.ADDRESS_CITY_TEXTBOX);
		sendkeyToElement(driver, UserAddressesPageUI.ADDRESS_CITY_TEXTBOX, city);
	}

	public void inputToAddressNo1Textbox(String addressNo1) {
		waitForElementVisible(driver, UserAddressesPageUI.ADDRESS_NO1_TEXTBOX);
		sendkeyToElement(driver, UserAddressesPageUI.ADDRESS_NO1_TEXTBOX, addressNo1);
	}

	public void inputToAddressNo2Textbox(String addressNo2) {
		waitForElementVisible(driver, UserAddressesPageUI.ADDRESS_NO2_TEXTBOX);
		sendkeyToElement(driver, UserAddressesPageUI.ADDRESS_NO2_TEXTBOX, addressNo2);
	}

	public void inputToZipCodeTextbox(String zipcode) {
		waitForElementVisible(driver, UserAddressesPageUI.ADDRESS_ZIPCODE_TEXTBOX);
		sendkeyToElement(driver, UserAddressesPageUI.ADDRESS_ZIPCODE_TEXTBOX, zipcode);
	}

	public void inputToPhoneNumTextbox(String phone) {
		waitForElementVisible(driver, UserAddressesPageUI.ADDRESS_PHONENUM_TEXTBOX);
		sendkeyToElement(driver, UserAddressesPageUI.ADDRESS_PHONENUM_TEXTBOX, phone);
	}

	public void inputToFaxNumTextbox(String fax) {
		waitForElementVisible(driver, UserAddressesPageUI.ADDRESS_FAXNUM_TEXTBOX);
		sendkeyToElement(driver, UserAddressesPageUI.ADDRESS_FAXNUM_TEXTBOX, fax);
	}

	public void clickToSaveButton() {
		waitForElementClickable(driver, UserAddressesPageUI.SAVE_BUTTON);
		clickToElement(driver, UserAddressesPageUI.SAVE_BUTTON);
	}

	public String getFullName() {
		return getElementText(driver, UserAddressesPageUI.NAME_FIELD);
	}

	public String getEmail() {
		return getElementText(driver, UserAddressesPageUI.EMAIL_FIELD);
	}

	public String getPhoneNum() {
		return getElementText(driver, UserAddressesPageUI.PHONE_FIELD);
	}

	public String getFaxNum() {
		return getElementText(driver, UserAddressesPageUI.FAX_FIELD);
	}

	public String getCompany() {
		return getElementText(driver, UserAddressesPageUI.COMPANY_FIELD);
	}

	public String getAddressNo1() {
		return getElementText(driver, UserAddressesPageUI.ADDRESS_NO1_FIELD);
	}

	public String getAddressNo2() {
		return getElementText(driver, UserAddressesPageUI.ADDRESS_NO2_FIELD);
	}

	public String getCityZipCode() {
		return getElementText(driver, UserAddressesPageUI.CITY_ZIPCODE_FIELD);
	}

	public String getCountry() {
		return getElementText(driver, UserAddressesPageUI.COUNTRY_FIELD);
	}
	
}
