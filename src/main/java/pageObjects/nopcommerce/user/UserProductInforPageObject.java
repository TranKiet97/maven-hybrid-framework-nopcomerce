package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.user.UserProductInforPageUI;

public class UserProductInforPageObject extends BasePage{
	WebDriver driver;

	public UserProductInforPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickAddReviewLink() {
		waitForElementVisible(driver, UserProductInforPageUI.ADD_REVIEW_LINK);
		clickToElement(driver, UserProductInforPageUI.ADD_REVIEW_LINK);
	}

	public void inputToReviewTitleTextbox(String reviewTitle) {
		waitForElementVisible(driver, UserProductInforPageUI.REVIEW_TITLE_TEXTBOX);
		sendkeyToElement(driver, UserProductInforPageUI.REVIEW_TITLE_TEXTBOX, reviewTitle);
	}

	public void inputToReviewTextTextbox(String reviewText) {
		waitForElementVisible(driver, UserProductInforPageUI.REVIEW_TEXT_TEXTBOX);
		sendkeyToElement(driver, UserProductInforPageUI.REVIEW_TEXT_TEXTBOX, reviewText);
	}

	public void selectRating(String rate) {
		switch (rate) {
		case "Bad":
			waitForElementVisible(driver, UserProductInforPageUI.BAD_RATING_RADIO_BUTTON);
			clickToElement(driver, UserProductInforPageUI.BAD_RATING_RADIO_BUTTON);
			break;
		case "Not Good":
			waitForElementVisible(driver, UserProductInforPageUI.NOTGOOD_RATING_RADIO_BUTTON);
			clickToElement(driver, UserProductInforPageUI.NOTGOOD_RATING_RADIO_BUTTON);
			break;
		case "Normal":
			waitForElementVisible(driver, UserProductInforPageUI.NORMAL_RATING_RADIO_BUTTON);
			clickToElement(driver, UserProductInforPageUI.NORMAL_RATING_RADIO_BUTTON);
			break;
		case "Good":
			waitForElementVisible(driver, UserProductInforPageUI.GOOD_RATING_RADIO_BUTTON);
			clickToElement(driver, UserProductInforPageUI.GOOD_RATING_RADIO_BUTTON);
			break;
		case "Excellent":
			waitForElementVisible(driver, UserProductInforPageUI.EXCELLENT_RATING_RADIO_BUTTON);
			clickToElement(driver, UserProductInforPageUI.EXCELLENT_RATING_RADIO_BUTTON);
			break;
		}
	}

	public void clickSubmitReview() {
		waitForElementVisible(driver, UserProductInforPageUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver, UserProductInforPageUI.SUBMIT_REVIEW_BUTTON);
	}
}
