package com.nopcommerce.common;

import java.util.Set;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;
import utilities.DataHelper;

public class Common_02_Register_Cookie extends BaseTest {
	private WebDriver driverTestClass;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private String firstName, lastName;
	public static Set<Cookie> loggedCookies;
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
		userHomePage = userRegisterPage.clickToContinueButton();
		userLoginPage = userHomePage.clickToLoginLink();
		userLoginPage.inputToTextboxByID(driverTestClass, emailAddress, "Email");
		userLoginPage.inputToTextboxByID(driverTestClass, password, "Password");
		userHomePage = userLoginPage.clickToLoginButton();
		loggedCookies = userHomePage.getAllCookie(driverTestClass);
		closeBrowserDriver();
	}
}

