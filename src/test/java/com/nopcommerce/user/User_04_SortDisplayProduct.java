package com.nopcommerce.user;

import org.testng.annotations.Test;
import com.nopcommerce.common.Common_02_Register_Cookie;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.ComputerPageObject;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.util.Set;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class User_04_SortDisplayProduct extends BaseTest {
	private WebDriver driverTestClass;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private ComputerPageObject computerPage;
	private Set<Cookie> cookies;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driverTestClass = getBrowser(browserName, "user");
		driverTestClass.manage().window().maximize();
		userHomePage = PageGeneratorManager.getUserHomePage(driverTestClass);
		cookies = Common_02_Register_Cookie.loggedCookies;
		userLoginPage = userHomePage.clickToLoginLink();
		userLoginPage.setCookie(driverTestClass, cookies);
		userHomePage.clickToHomePageMenuByText("Computers");
		computerPage = PageGeneratorManager.getComputerPage(driverTestClass);
		computerPage.clickToCategoryByText("Computers");
		computerPage.clickToSubCategoryByText("Notebooks");
	}
	
	@Test
	public void Sort_Diplay_01_Product_Name_Ascending() {
		computerPage.selectSortByDropdown("Name: A to Z");
		Assert.assertTrue(computerPage.isTheProductBeSortAscendingByName());
	}

	@Test
	public void Sort_Diplay_02_Product_Name_Descending() {
		computerPage.selectSortByDropdown("Name: Z to A");
		Assert.assertTrue(computerPage.isTheProductBeSortDescendingByName());
	}

	@Test
	public void Sort_Diplay_03_Product_Price_Ascending() {
		computerPage.selectSortByDropdown("Price: Low to High");
		Assert.assertTrue(computerPage.isTheProductBeSortAscendingByPrice());
	}

	@Test
	public void Sort_Diplay_04_Product_Price_Descending() {
		computerPage.selectSortByDropdown("Price: High to Low");
		Assert.assertTrue(computerPage.isTheProductBeSortDescendingByPrice());
	}

	@Test
	public void Sort_Diplay_05_Display_With_3_Products_Per_Page() {
		computerPage.selectDisplayDropdown("3");
		Assert.assertTrue(computerPage.getNumberOfProductOnPage() <= 3);
		Assert.assertTrue(computerPage.isNavigateBarDisplayed());
	}
	
	@Test
	public void Sort_Diplay_06_Display_With_6_Products_Per_Page() {
		computerPage.selectDisplayDropdown("6");
		Assert.assertTrue(computerPage.getNumberOfProductOnPage() <= 6);
		Assert.assertTrue(computerPage.isNavigateBarUndisplayed());
	}
	
	@Test
	public void Sort_Diplay_07_Display_With_9_Products_Per_Page() {
		computerPage.selectDisplayDropdown("9");
		Assert.assertTrue(computerPage.getNumberOfProductOnPage() <= 9);
		Assert.assertTrue(computerPage.isNavigateBarUndisplayed());
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
	
}
