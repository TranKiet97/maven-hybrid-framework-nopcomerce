package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.admin.AdminDashboardPageObject;
import pageObjects.nopcommerce.admin.AdminLoginPageObject;

public class Admin_02_Customer extends BaseTest {
	private WebDriver driverTestClass;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	private String adminEmail = "admin@yourstore.com";
	private String adminPassword = "admin";
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driverTestClass = getBrowser(browserName, "admin");
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driverTestClass);
		adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmail, adminPassword);
		Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed());
	}
	
	@Test
	public void Customer_01() {
		
	}
	
	@Test
	public void Customer_02() {
		
	}
	
	@Test
	public void Customer_03() {
		
	}
	
	@Test
	public void Customer_04() {
		
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
