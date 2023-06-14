package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;
import utilities.DataHelper;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class User_01_Register extends BaseTest {
	private WebDriver driverTestClass;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private String emailAddress;
	private String firstName, lastName, password;
	private DataHelper dataFaker;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {	
		driverTestClass = getBrowser(browserName, "user");
		userHomePage = PageGeneratorManager.getUserHomePage(driverTestClass);
		
		dataFaker = DataHelper.getDataHelper();
		firstName = dataFaker.getFirstName();
		lastName = dataFaker.getLastName();
		emailAddress = dataFaker.getEmailAddress();
		password = dataFaker.getPassword();
	}
	
	@Test
	public void Register_01_Empty_Data() {
		userRegisterPage = userHomePage.clickToRegisterLink();
		
		userRegisterPage.clickToRegisterButton();
		
		Assert.assertEquals(userRegisterPage.getErrorMessageAtFirtNameTextbox(), "First name is required.");
		Assert.assertEquals(userRegisterPage.getErrorMessageAtLastNameTextbox(), "Last name is required.");
		Assert.assertEquals(userRegisterPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(userRegisterPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(userRegisterPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");
	}

	@Test
	public void Register_02_Invalid_Email() {
		userRegisterPage = userHomePage.clickToRegisterLink();
		
		userRegisterPage.inputToFirstNameTextbox(firstName);
		userRegisterPage.inputToLastNameTextbox(lastName);
		userRegisterPage.inputToEmailTextbox("xyz@?");
		userRegisterPage.inputToPasswordTextbox(password);
		userRegisterPage.inputToConfirmPasswordTextbox(password);
		
		userRegisterPage.clickToRegisterButton();
		
		Assert.assertEquals(userRegisterPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void Register_03_Success() {
		userRegisterPage = userHomePage.clickToRegisterLink();
		
		userRegisterPage.inputToFirstNameTextbox(firstName);
		userRegisterPage.inputToLastNameTextbox(lastName);
		userRegisterPage.inputToEmailTextbox(emailAddress);
		userRegisterPage.inputToPasswordTextbox(password);
		userRegisterPage.inputToConfirmPasswordTextbox(password);
		
		userRegisterPage.clickToRegisterButton();
		
		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");
		
		userRegisterPage.clickToContinueButton();
	}

	@Test
	public void Register_04_Existed_Email() {
		userRegisterPage = userHomePage.clickToRegisterLink();
		
		userRegisterPage.inputToFirstNameTextbox(firstName);
		userRegisterPage.inputToLastNameTextbox(lastName);
		userRegisterPage.inputToEmailTextbox(emailAddress);
		userRegisterPage.inputToPasswordTextbox(password);
		userRegisterPage.inputToConfirmPasswordTextbox(password);
		
		userRegisterPage.clickToRegisterButton();
		
		Assert.assertEquals(userRegisterPage.getExistedEmailErrorMessage(), "The specified email already exists");
	}

	@Test
	public void Register_05_Password_Less_Than_Six_Chars() {
		userRegisterPage = userHomePage.clickToRegisterLink();
		
		userRegisterPage.inputToFirstNameTextbox(firstName);
		userRegisterPage.inputToLastNameTextbox(lastName);
		userRegisterPage.inputToEmailTextbox(emailAddress);
		userRegisterPage.inputToPasswordTextbox("123");
		userRegisterPage.inputToConfirmPasswordTextbox("123");
		
		userRegisterPage.clickToRegisterButton();
		
		Assert.assertEquals(userRegisterPage.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void Register_06_Incorrect_Confirm_Password() {
		userRegisterPage = userHomePage.clickToRegisterLink();
		
		userRegisterPage.inputToFirstNameTextbox(firstName);
		userRegisterPage.inputToLastNameTextbox(lastName);
		userRegisterPage.inputToEmailTextbox(emailAddress);
		userRegisterPage.inputToPasswordTextbox(password);
		userRegisterPage.inputToConfirmPasswordTextbox("123666");
		
		userRegisterPage.clickToRegisterButton();
		
		Assert.assertEquals(userRegisterPage.getErrorMessageAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
	
}
