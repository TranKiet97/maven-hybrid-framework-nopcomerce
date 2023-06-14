package com.nopcommerce.common;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;
import utilities.DataHelper;

public class Common_01_Register_EndUser extends BaseTest {
	private WebDriver driverTestClass;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private String firstName, lastName;
	public static String emailAddress;
	public static String password;
	private DataHelper dataFaker;

	@Parameters("browser")
	@BeforeTest (description = "Create New Common User For All Class Test")
	public void Register(String browserName) {
		driverTestClass = getBrowser(browserName, "user");
		
		dataFaker = DataHelper.getDataHelper();
		firstName = dataFaker.getFirstName();
		lastName = dataFaker.getLastName();
		emailAddress = dataFaker.getEmailAddress();
		password = dataFaker.getPassword();

		userHomePage = PageGeneratorManager.getUserHomePage(driverTestClass);
		userRegisterPage = userHomePage.clickToRegisterLink();
		userRegisterPage.inputToTextboxByID(driverTestClass, firstName, "FirstName");
		userRegisterPage.inputToTextboxByID(driverTestClass, lastName, "LastName");
		userRegisterPage.inputToTextboxByID(driverTestClass, emailAddress, "Email");
		userRegisterPage.inputToTextboxByID(driverTestClass, password, "Password");
		userRegisterPage.inputToTextboxByID(driverTestClass, password, "ConfirmPassword");
		userRegisterPage.clickToRegisterButton();
		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");
		closeBrowserDriver();
	}
}

