package com.nopcommerce.user;

import org.testng.annotations.Test;
import com.nopcommerce.common.Common_02_Register_Cookie;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.SearchPageObject;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class User_05_SearchProduct extends BaseTest {
	private WebDriver driverTestClass;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private SearchPageObject searchPage;
	private Set<Cookie> cookies;
	private static String notExistProduct = "Macbook Pro 2050";
	private static String absoluteProduct = "Lenovo";
	private static String relativeProduct = "Thinkpad X1 Carbon Laptop";
	private static String advandcedSerachProduct = "Apple Macbook Pro";
	private static ArrayList<String> listOfProducts = new ArrayList<String>(Arrays.asList("Lenovo IdeaCentre 600 All-in-One PC", "Lenovo Thinkpad X1 Carbon Laptop"));
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driverTestClass = getBrowser(browserName, "user");
		driverTestClass.manage().window().maximize();
		userHomePage = PageGeneratorManager.getUserHomePage(driverTestClass);
		cookies = Common_02_Register_Cookie.loggedCookies;
		userLoginPage = userHomePage.clickToLoginLink();
		userLoginPage.setCookie(driverTestClass, cookies);
		userHomePage.clickToFooterMenuByText("Search");
		searchPage = PageGeneratorManager.getSearchPage(driverTestClass);
	}
	
	@Test
	public void Search_01_Empty_Data() {
		searchPage.clickToSearchButton();
		Assert.assertEquals(searchPage.getErrorMessageTextByType("warning"), "Search term minimum length is 3 characters");
	}
	
	@Test
	public void Search_02_Data_Not_Exist() {
		searchPage.inputToSearchKeywordTextbox(notExistProduct);
		searchPage.clickToSearchButton();
		Assert.assertEquals(searchPage.getErrorMessageTextByType("no-result"), "No products were found that matched your criteria.");
	}
	
	@Test
	public void Search_03_Absolute_Product_Name() {
		searchPage.inputToSearchKeywordTextbox(absoluteProduct);
		searchPage.clickToSearchButton();
		Assert.assertEquals(searchPage.getAllDisplayedProducts(), listOfProducts);
	}
	
	@Test
	public void Search_04_Relative_Product_Name() {
		searchPage.inputToSearchKeywordTextbox(relativeProduct);
		searchPage.clickToSearchButton();
		Assert.assertEquals(searchPage.getDisplayedProduct(), listOfProducts.get(1));
	}
	
	@Test
	public void Search_05_Parent_Category() {
		searchPage.inputToSearchKeywordTextbox(advandcedSerachProduct);
		searchPage.clickToCheckboxByLabel("Advanced search");
		searchPage.selectCategoryDropdown("Computers");
		searchPage.clickToSearchButton();
		Assert.assertEquals(searchPage.getErrorMessageTextByType("no-result"), "No products were found that matched your criteria.");
	}
	
	@Test
	public void Search_06_Sub_Category() {
		searchPage.inputToSearchKeywordTextbox(advandcedSerachProduct);
		searchPage.clickToCheckboxByLabel("Advanced search");
		searchPage.selectCategoryDropdown("Computers");
		searchPage.clickToCheckboxByLabel("Automatically search sub categories");
		searchPage.clickToSearchButton();
		Assert.assertEquals(searchPage.getDisplayedProduct(), "Apple MacBook Pro 13-inch");
	}
	
	@Test
	public void Search_07_Incorrect_Manufacturer() {
		searchPage.inputToSearchKeywordTextbox(advandcedSerachProduct);
		searchPage.clickToCheckboxByLabel("Advanced search");
		searchPage.selectCategoryDropdown("Computers");
		searchPage.clickToCheckboxByLabel("Automatically search sub categories");
		searchPage.selectManufacturerDropdown("HP");
		searchPage.clickToSearchButton();
		Assert.assertEquals(searchPage.getErrorMessageTextByType("no-result"), "No products were found that matched your criteria.");
	}

	@Test
	public void Search_08_Correct_Manufacturer() {
		searchPage.inputToSearchKeywordTextbox(advandcedSerachProduct);
		searchPage.clickToCheckboxByLabel("Advanced search");
		searchPage.selectCategoryDropdown("Computers");
		searchPage.clickToCheckboxByLabel("Automatically search sub categories");
		searchPage.selectManufacturerDropdown("Apple");
		searchPage.clickToSearchButton();
		Assert.assertEquals(searchPage.getDisplayedProduct(), "Apple MacBook Pro 13-inch");
	}

	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
	
}
