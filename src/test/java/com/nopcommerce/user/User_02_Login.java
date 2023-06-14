package com.nopcommerce.user;

import org.testng.annotations.Test;
import com.nopcommerce.common.Common_02_Register_Cookie;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.util.Set;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class User_02_Login extends BaseTest {
	private WebDriver driverTestClass;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private String existedEmail, invalidEmail, notFoundEmail;
	private Set<Cookie> cookies;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driverTestClass = getBrowser(browserName, "user");
		userHomePage = PageGeneratorManager.getUserHomePage(driverTestClass);
		existedEmail = Common_02_Register_Cookie.emailAddress;
		notFoundEmail = "fake@gmail.net";
		invalidEmail = "fake@";
		cookies = Common_02_Register_Cookie.loggedCookies;
	}
	
	@Test
	public void Login_01_Empty_Data() {
		userLoginPage = userHomePage.clickToLoginLink();
		userLoginPage.clickToLoginButton();
		Assert.assertEquals(userLoginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {
		userLoginPage = userHomePage.clickToLoginLink();
		userLoginPage.inputToEmailTextbox(invalidEmail);
		userLoginPage.clickToLoginButton();
		Assert.assertEquals(userLoginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void Login_03_Email_Not_Found() {
		userLoginPage = userHomePage.clickToLoginLink();
		userLoginPage.inputToEmailTextbox(notFoundEmail);
		userLoginPage.clickToLoginButton();
		Assert.assertEquals(userLoginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_04_Registed_Email_Empty_Password() {
		userLoginPage = userHomePage.clickToLoginLink();
		userLoginPage.inputToEmailTextbox(existedEmail);
		userLoginPage.clickToLoginButton();
		Assert.assertEquals(userLoginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_05_Registed_Email_Incorrect_Password() {
		userLoginPage = userHomePage.clickToLoginLink();
		userLoginPage.inputToEmailTextbox(existedEmail);
		userLoginPage.inputToPasswordTextbox("123666");
		userLoginPage.clickToLoginButton();
		Assert.assertEquals(userLoginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_06_Registed_Email_Correct_Password() {
		userLoginPage = userHomePage.clickToLoginLink();
		userLoginPage.setCookie(driverTestClass, cookies);
		userLoginPage.refreshCurrentPage(driverTestClass);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
	
}
