package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import commons.PageGeneratorManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.nopcommerce.admin.AdminCatalogProductPageObject;
import pageObjects.nopcommerce.admin.AdminDashboardPageObject;
import pageObjects.nopcommerce.admin.AdminLoginPageObject;

public class Admin_01_Product extends BaseTest {
	private WebDriver driverTestClass;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	private AdminCatalogProductPageObject adminCatalogProductPage;
	private String adminEmail = "admin@yourstore.com";
	private String adminPassword = "admin";
	private String productName = "Lenovo IdeaCentre 600 All-in-One PC";

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driverTestClass = getBrowser(browserName, "admin");
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driverTestClass);
		adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmail, adminPassword);
		Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed());
		adminDashboardPage.clickToCatalogTab();
	}

	@Description("Search With Product Name")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void Product_01_Search_With_Product_Name() {
		adminDashboardPage.openProductPage();
		adminCatalogProductPage = PageGeneratorManager.getAdminCatalogProductPage(driverTestClass);
		adminCatalogProductPage.searchWithProductName(productName);
		Assert.assertEquals(adminCatalogProductPage.getProductNameInTable("Product name", "1"), productName);
	}

	@Description("Search With Product Name And Parent Category Exclude Sub-Category")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void Product_02_Search_With_Product_Name_Parent_Category_Exclude_Sub_Categories() {
		adminDashboardPage.openProductPage();
		adminCatalogProductPage = PageGeneratorManager.getAdminCatalogProductPage(driverTestClass);
		adminCatalogProductPage.searchWithProductNameParentCategoryExludeSubCategories(productName, "Computers");
		Assert.assertEquals(adminCatalogProductPage.getEmptyDataNoti(), "No data available in table");
	}

	@Description("Search With Product Name And Parent Category Include Sub-Category")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void Product_03_Search_With_Product_Name_Parent_Category_Include_Sub_Categories() {
		adminDashboardPage.openProductPage();
		adminCatalogProductPage = PageGeneratorManager.getAdminCatalogProductPage(driverTestClass);
		adminCatalogProductPage.searchWithProductNameParentCategoryInludeSubCategories(productName, "Computers");
		Assert.assertEquals(adminCatalogProductPage.getProductNameInTable("Product name", "1"), productName);
	}

	@Description("Search With Product Name And Child Category")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void Product_04_Search_With_Product_Name_Child_Category() {
		adminDashboardPage.openProductPage();
		adminCatalogProductPage = PageGeneratorManager.getAdminCatalogProductPage(driverTestClass);
		adminCatalogProductPage.searchWithProductNameChildCategory(productName, "Computers >> Desktops");
		Assert.assertEquals(adminCatalogProductPage.getProductNameInTable("Product name", "1"), productName);
	}
	
	@Description("Search With Product Name And Manufacturer")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void Product_05_Search_With_Product_Name_Manufacturer() {
		adminDashboardPage.openProductPage();
		adminCatalogProductPage = PageGeneratorManager.getAdminCatalogProductPage(driverTestClass);
		adminCatalogProductPage.searchWithProductNameAllCategoryManufacturer(productName, "All", "Apple");
		Assert.assertEquals(adminCatalogProductPage.getEmptyDataNoti(), "No data available in table");
	}
	
	@Test
	public void Product_06_Go_Directly_To_Product_SKU() {
		
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
