package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.user.UserMyProductPreviewPageUI;

public class UserMyProductReviewsPageObject extends BasePage {
	WebDriver driver;

	public UserMyProductReviewsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getMyReviewTitle() {
		return getElementText(driver, UserMyProductPreviewPageUI.REVIEW_TITLE);
	}
	
}
