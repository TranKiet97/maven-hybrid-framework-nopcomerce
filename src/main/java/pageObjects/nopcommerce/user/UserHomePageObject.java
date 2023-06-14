package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopcommerce.user.UserBasePageUI;
import pageUIs.nopcommerce.user.UserHomePageUI;

public class UserHomePageObject extends BasePage {
	private WebDriver driver;
	
	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public UserRegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver);
	}
	

	public UserLoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, UserBasePageUI.MYACCOUNT_LINK);
		return isElementDisplayed(driver, UserBasePageUI.MYACCOUNT_LINK);
	}

	public UserProductInforPageObject clickToProductLink() {
		waitForElementClickable(driver, UserHomePageUI.CPU_LINK);
		clickToElement(driver, UserHomePageUI.CPU_LINK);
		return PageGeneratorManager.getUserProductInforPage(driver);
	}

	public void clickToHomePageMenuByText(String menuName) {
		waitForElementClickable(driver, UserHomePageUI.MENU_LINK_BY_TEXT, menuName);
		clickToElement(driver, UserHomePageUI.MENU_LINK_BY_TEXT, menuName);
	}
	
	public void clickToFooterMenuByText(String footerMenuName) {
		waitForElementClickable(driver, UserHomePageUI.FOOTER_LINK_BY_TEXT, footerMenuName);
		clickToElement(driver, UserHomePageUI.FOOTER_LINK_BY_TEXT, footerMenuName);
	}

}
