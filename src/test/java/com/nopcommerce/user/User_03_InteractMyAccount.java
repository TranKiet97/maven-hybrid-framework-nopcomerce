package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserAddressesPageObject;
import pageObjects.nopcommerce.user.UserChangePasswordPageObject;
import pageObjects.nopcommerce.user.UserCustomerInforPageObject;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserMyProductReviewsPageObject;
import pageObjects.nopcommerce.user.UserProductInforPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;
import utilities.DataHelper;

public class User_03_InteractMyAccount extends BaseTest {
	private WebDriver driverTestClass;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerInforPageObject userCustomerInforPage;
	private UserAddressesPageObject userAddressesPage;
	private UserChangePasswordPageObject userChangePasswordPage;
	private UserProductInforPageObject userProductInforPage;
	private UserMyProductReviewsPageObject userMyProductReviewPage;
	private String firstName, lastName, currentPassword, newPassword, email, gender, company, country, state, city, addNo1, addNo2, zipCode, phoneNum, faxNum, reviewTitle, reviewText, rating;
	private DataHelper dataFaker;

	@Parameters({"browser", "osName", "osVersion"})
	@BeforeClass
	public void beforeClass(String browserName, String osName, String osVersion) {
		driverTestClass = getBrowserOnBrowserStack(browserName, "user", osName, osVersion);
		driverTestClass.manage().window().maximize();

		userHomePage = PageGeneratorManager.getUserHomePage(driverTestClass);

		dataFaker = DataHelper.getDataHelper();
		firstName = dataFaker.getFirstName();
		lastName = dataFaker.getLastName();
		email = dataFaker.getEmailAddress();
		currentPassword = "123456";
		newPassword = "654321";
		gender = "Female";
		company = "Automation FC Company";
		country = "Viet Nam";
		state = "Other";
		city = dataFaker.getCityName();
		addNo1 = dataFaker.getAddress();
		addNo2 = dataFaker.getAddress();
		zipCode = dataFaker.getZipCode();
		phoneNum = dataFaker.getPhoneNumber();
		faxNum = dataFaker.getPhoneNumber();
		reviewTitle = "Add Review";
		reviewText = "Review Text";
		rating = "Good";
		
		userRegisterPage = userHomePage.clickToRegisterLink();

		userRegisterPage.inputToFirstNameTextbox(firstName);
		userRegisterPage.inputToLastNameTextbox(lastName);
		userRegisterPage.inputToEmailTextbox(email);
		userRegisterPage.inputToPasswordTextbox(currentPassword);
		userRegisterPage.inputToConfirmPasswordTextbox(currentPassword);

		userRegisterPage.clickToRegisterButton();

		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");

		userHomePage = userRegisterPage.clickToContinueButton();
		userLoginPage = userHomePage.clickToLoginLink();

		userLoginPage.inputToEmailTextbox(email);
		userLoginPage.inputToPasswordTextbox(currentPassword);
		userHomePage = userLoginPage.clickToLoginButton();

		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void MyAccount_01_Update_Customer_Info() {
		userCustomerInforPage = userHomePage.clickToMyAccountLink(driverTestClass);
		userCustomerInforPage.selectGender(gender);
		userCustomerInforPage.inputToFirstNameTextbox(firstName);
		userCustomerInforPage.inputToLastNameTextbox(lastName);
		userCustomerInforPage.selectDayOfBirth("1");
		userCustomerInforPage.selectMonthOfBirth("January");
		userCustomerInforPage.selectYearOfBirth("1999");
		userCustomerInforPage.inputToEmailTextbox(email);
		userCustomerInforPage.inputToCompanyTextbox(company);
		userCustomerInforPage.clickToSaveButton();

		Assert.assertTrue(userCustomerInforPage.isSelectedGenderFemale());
		Assert.assertEquals(userCustomerInforPage.getFirstNameValue(), firstName);
		Assert.assertEquals(userCustomerInforPage.getLastNameValue(), lastName);
		Assert.assertEquals(userCustomerInforPage.getDayOfBirthValue(), "1");
		Assert.assertEquals(userCustomerInforPage.getMonthOfBirthValue(), "January");
		Assert.assertEquals(userCustomerInforPage.getYearOfBirthValue(), "1999");
		Assert.assertEquals(userCustomerInforPage.getEmailValue(), email);
		Assert.assertEquals(userCustomerInforPage.getCompanyValue(), company);
	}

	@Test
	public void MyAccount_02_Add_Addresses() {
		userCustomerInforPage.OpenPageInMyAccountMenu(driverTestClass, "Addresses");
		userAddressesPage = PageGeneratorManager.getUserAddressesPage(driverTestClass);
		userAddressesPage.clickToAddNewAddressButton();
		userAddressesPage.inputToFirstNameTextbox(firstName);
		userAddressesPage.inputToLastNameTextbox(lastName);
		userAddressesPage.inputToEmailTextbox(email);
		userAddressesPage.inputToCompanyTextbox(company);
		userAddressesPage.selectCountry(country);
		userAddressesPage.selectState(state);
		userAddressesPage.inputToCityTextbox(city);
		userAddressesPage.inputToAddressNo1Textbox(addNo1);
		userAddressesPage.inputToAddressNo2Textbox(addNo2);
		userAddressesPage.inputToZipCodeTextbox(zipCode);
		userAddressesPage.inputToPhoneNumTextbox(phoneNum);
		userAddressesPage.inputToFaxNumTextbox(faxNum);
		userAddressesPage.clickToSaveButton();

		Assert.assertEquals(userAddressesPage.getFullName(), firstName + " " + lastName);
		Assert.assertEquals(userAddressesPage.getEmail(), "Email: " + email);
		Assert.assertEquals(userAddressesPage.getPhoneNum(), "Phone number: " + phoneNum);
		Assert.assertEquals(userAddressesPage.getFaxNum(), "Fax number: " + faxNum);
		Assert.assertEquals(userAddressesPage.getCompany(), company);
		Assert.assertEquals(userAddressesPage.getAddressNo1(), addNo1);
		Assert.assertEquals(userAddressesPage.getAddressNo2(), addNo2);
		Assert.assertEquals(userAddressesPage.getCityZipCode(), city + ", " + zipCode);
		Assert.assertEquals(userAddressesPage.getCountry(), country);
	}

	@Test
	public void MyAccount_03_Change_Password() {
		userCustomerInforPage.OpenPageInMyAccountMenu(driverTestClass, "Change password");
		userChangePasswordPage = PageGeneratorManager.getUserChangePasswordPage(driverTestClass);
		userChangePasswordPage.inputToOldPasswordTextbox(currentPassword);
		userChangePasswordPage.inputToNewPasswordTextbox(newPassword);
		userChangePasswordPage.inputToConfirmPasswordTextbox(newPassword);
		userChangePasswordPage.clickToChangePasswrodButton();

		userHomePage = userChangePasswordPage.clickToLogoutLink(driverTestClass);
		userHomePage.clickToLoginLink();
		userLoginPage.inputToEmailTextbox(email);
		userLoginPage.inputToPasswordTextbox(currentPassword);
		userLoginPage.clickToLoginButton();

		Assert.assertEquals(userLoginPage.getErrorMessageUnsuccessful(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

		userLoginPage = userHomePage.clickToLoginLink();
		userLoginPage.inputToEmailTextbox(email);
		userLoginPage.inputToPasswordTextbox(newPassword);
		userHomePage = userLoginPage.clickToLoginButton();

		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void MyAccount_04_Add_Product_Reviews() {
		userProductInforPage = userHomePage.clickToProductLink();
		userProductInforPage.clickAddReviewLink();
		userProductInforPage.inputToReviewTitleTextbox(reviewTitle);
		userProductInforPage.inputToReviewTextTextbox(reviewText);
		userProductInforPage.selectRating(rating);
		userProductInforPage.clickSubmitReview();
		
		userCustomerInforPage = userProductInforPage.clickToMyAccountLink(driverTestClass);
		userCustomerInforPage.OpenPageInMyAccountMenu(driverTestClass, "My product reviews");
		userMyProductReviewPage = PageGeneratorManager.getUserMyProductReviewsPage(driverTestClass);
		Assert.assertEquals(userMyProductReviewPage.getMyReviewTitle(), reviewTitle);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
