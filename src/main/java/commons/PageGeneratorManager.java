package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.nopcommerce.admin.AdminCatalogProductPageObject;
import pageObjects.nopcommerce.admin.AdminDashboardPageObject;
import pageObjects.nopcommerce.admin.AdminLoginPageObject;
import pageObjects.nopcommerce.user.ComputerPageObject;
import pageObjects.nopcommerce.user.SearchPageObject;
import pageObjects.nopcommerce.user.UserAddressesPageObject;
import pageObjects.nopcommerce.user.UserBackinStokSubscriptionsPageObject;
import pageObjects.nopcommerce.user.UserChangePasswordPageObject;
import pageObjects.nopcommerce.user.UserCustomerInforPageObject;
import pageObjects.nopcommerce.user.UserDowloadableProductsPageObject;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserMyProductReviewsPageObject;
import pageObjects.nopcommerce.user.UserOrdersPageObject;
import pageObjects.nopcommerce.user.UserProductInforPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;
import pageObjects.nopcommerce.user.UserRewardPointsPageObject;

public class PageGeneratorManager {
	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}
	
	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}
	
	public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}
	
	public static UserCustomerInforPageObject getUserCustomerInforPage(WebDriver driver) {
		return new UserCustomerInforPageObject(driver);
	}
	
	public static UserAddressesPageObject getUserAddressesPage(WebDriver driver) {
		return new UserAddressesPageObject(driver);
	}
	
	public static UserOrdersPageObject getUserOrdersPage(WebDriver driver) {
		return new UserOrdersPageObject(driver);
	}
	
	public static UserDowloadableProductsPageObject getUserDowloadableProductsPage(WebDriver driver) {
		return new UserDowloadableProductsPageObject(driver);
	}
	
	public static UserBackinStokSubscriptionsPageObject getUserBackinStokSubscriptionsPage(WebDriver driver) {
		return new UserBackinStokSubscriptionsPageObject(driver);
	}
	
	public static UserRewardPointsPageObject getUserRewardPointsPage(WebDriver driver) {
		return new UserRewardPointsPageObject(driver);
	}
	
	public static UserChangePasswordPageObject getUserChangePasswordPage(WebDriver driver) {
		return new UserChangePasswordPageObject(driver);
	}
	
	public static UserMyProductReviewsPageObject getUserMyProductReviewsPage(WebDriver driver) {
		return new UserMyProductReviewsPageObject(driver);
	}

	public static UserProductInforPageObject getUserProductInforPage(WebDriver driver) {
		return new UserProductInforPageObject(driver);
	}
	
	public static ComputerPageObject getComputerPage(WebDriver driver) {
		return new ComputerPageObject(driver);
	}
	
	public static SearchPageObject getSearchPage(WebDriver driver) {
		return new SearchPageObject(driver);
	}
	
	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	
	public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}
	
	public static AdminCatalogProductPageObject getAdminCatalogProductPage(WebDriver driver) {
		return new AdminCatalogProductPageObject(driver);
	}
}
