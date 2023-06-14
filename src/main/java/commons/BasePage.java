package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonUIs.BasePageUI;
import pageObjects.nopcommerce.user.UserCustomerInforPageObject;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageUIs.nopcommerce.admin.AdminBasePageUI;
import pageUIs.nopcommerce.user.UserBasePageUI;

public class BasePage {
	
	protected void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}
	
	protected String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	protected String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	protected String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	
	protected void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	protected void forwardToPage(WebDriver driver) {
		driver.navigate().forward();;
	}
	
	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	protected Alert waitForAlertPrecence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	
	protected void acceptAlert(WebDriver driver) {
		Alert alert = waitForAlertPrecence(driver);
		alert.accept();
	}
	
	protected void cancelAlert(WebDriver driver) {
		Alert alert = waitForAlertPrecence(driver);
		alert.dismiss();
	}
	
	protected String getTextAlert(WebDriver driver) {
		Alert alert = waitForAlertPrecence(driver);
		return alert.getText();
	}
	
	protected void sendKeyToAlert(WebDriver driver, String textValue) {
		Alert alert = waitForAlertPrecence(driver);
		alert.sendKeys(textValue);
	}
	
	protected void switchToWindowByID(WebDriver driver, String windowID) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			if(!id.equals(windowID)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}
	
	protected void switchToWindowByPageTitle(WebDriver driver, String expectedPageTitle) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			driver.switchTo().window(id);
			String actualPageTitle = driver.getTitle();
			System.out.println(actualPageTitle);
			if(actualPageTitle.equals(expectedPageTitle)) {
				break;
			}
		}
	}
	
	protected void closeAllWindowWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			if(!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.close();
			}
			driver.switchTo().window(parentID);
		}
	}
	
	private String getDynamicXpath(String locatorType, String... dynamicValues) {
		
		locatorType = String.format(locatorType, (Object[]) dynamicValues);
		return locatorType;
	}
	
	private By getByLocator(String locatorType, String... dynamicValues) {
		By by = null;
		if(locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {
			by = By.id(locatorType.substring(3));
		} else if(locatorType.startsWith("name=") || locatorType.startsWith("NAME=") || locatorType.startsWith("Name=")) {
			by = By.name(locatorType.substring(5));
		} else if(locatorType.startsWith("class=") || locatorType.startsWith("CLASS=") || locatorType.startsWith("Class=")) {
			by = By.className(locatorType.substring(6));
		} else if(locatorType.startsWith("css=") || locatorType.startsWith("CSS=") || locatorType.startsWith("Css=")) {
			by = By.cssSelector(locatorType.substring(4));
		} else if(locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=")) {
			if(locatorType.contains("%s")) {
				by = By.xpath(getDynamicXpath(locatorType, dynamicValues).substring(6));
			} else {
				by = By.xpath(locatorType.substring(6));
			}
		} else {
			throw new RuntimeException("Locator Type is Not Supported!");
		}
		return by;
	}
	
	private WebElement getWebElement(WebDriver driver, String locator, String... dynamicValues) {
		return driver.findElement(getByLocator(locator, dynamicValues));
	}
	
	protected List<WebElement> getListWebElements (WebDriver driver, String locator, String... dynamicValues) {
		return driver.findElements(getByLocator(locator, dynamicValues));
	}

	protected void clickToElement(WebDriver driver, String locator, String... dynamicValues) {
		getWebElement(driver, locator, dynamicValues).click();
	}
	
	protected void sendkeyToElement(WebDriver driver, String locator, String textValue, String... dynamicValues) {
		WebElement element = getWebElement(driver, locator, dynamicValues);
		element.clear();
		element.sendKeys(textValue);
	}
	
	protected String getElementText(WebDriver driver, String locator, String... dynamicValues) {
		return getWebElement(driver, locator, dynamicValues).getText();
	}
	
	protected void selectItemInDefaultDropdown(WebDriver driver, String locator, String textItem, String... dynamicValues) {
		Select select = new Select(getWebElement(driver, locator, dynamicValues));
		select.selectByVisibleText(textItem);
	}
	
	protected String getSelectedItemInDefaultDropdown(WebDriver driver, String locator, String... dynamicValues) {
		Select select = new Select(getWebElement(driver, locator, dynamicValues));
		return select.getFirstSelectedOption().getText();
	}
	
	protected boolean isDropdownMultiple(WebDriver driver, String locator, String... dynamicValues) {
		Select select = new Select(getWebElement(driver, locator, dynamicValues));
		return select.isMultiple();
	}
	
	protected void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childLocator, String expectedTextItem, String... dynamicValues) {
		getWebElement(driver, parentLocator, dynamicValues).click();
		sleepInSecond(1);
		
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childLocator, dynamicValues)));
		for (WebElement item : allItems) {
			if(item.getText().trim().equals(expectedTextItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);
				item.click();
				break;
			}
		}
	}
	
	protected void sleepInSecond(long time) {
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	protected String getElementAttribute(WebDriver driver, String locator, String attributeName, String... dynamicValues) {
		return getWebElement(driver, locator, dynamicValues).getAttribute(attributeName);
	}
	
	protected String getElementCss(WebDriver driver, String locator, String propertyName, String... dynamicValues) {
		return getWebElement(driver, locator, dynamicValues).getCssValue(propertyName);
	}
	
	protected String getHexaColorByRgbaColor(String grbaValue) {
		return Color.fromString(grbaValue).asHex();
	}
	
	protected int getElementSize(WebDriver driver, String locator, String... dynamicValues) {
		return getListWebElements(driver, locator, dynamicValues).size();
	}
	
	protected void checkToDefaultCheckboxRadio(WebDriver driver, String locator, String... dynamicValues) {
		WebElement element = getWebElement(driver, locator, dynamicValues);
		if(!element.isSelected()) {
			element.click();
		}
	}
	
	protected void uncheckToDefaultCheckbox(WebDriver driver, String locator, String... dynamicValues) {
		WebElement element = getWebElement(driver, locator, dynamicValues);
		if(element.isSelected()) {
			element.click();
		}
	}
	
	protected boolean isElementDisplayed(WebDriver driver, String locator, String... dynamicValues) {
		return getWebElement(driver, locator, dynamicValues).isDisplayed();
	}
	
	protected void overrideImplicitTimeout(WebDriver driver, long timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}
	
	protected boolean isElementUndisplayed(WebDriver driver, String locator, String... dynamicValues) {
		overrideImplicitTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
		List<WebElement> elements = getListWebElements(driver, locator, dynamicValues);
		overrideImplicitTimeout(driver, GlobalConstants.LONG_TIMEOUT);
		if(elements.size() == 0) {
			return true;
		} else if(elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	protected boolean isElementEnable(WebDriver driver, String locator, String... dynamicValues) {
		return getWebElement(driver, locator, dynamicValues).isEnabled();
	}
	
	protected boolean isElementSelected(WebDriver driver, String locator, String... dynamicValues) {
		return getWebElement(driver, locator, dynamicValues).isSelected();
	}
	
	protected void switchToFrameIframe(WebDriver driver, String locator, String... dynamicValues) {
		driver.switchTo().frame(getWebElement(driver, locator, dynamicValues));
	}
	
	protected void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	protected void hoverToElement(WebDriver driver, String locator, String... dynamicValues) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locator, dynamicValues)).perform();
	}
	
	protected void pressKeyToElement(WebDriver driver, String locator, Keys key, String... dynamicValues) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, locator, dynamicValues), key).perform();
	}

	protected void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	protected void highlightElement(WebDriver driver, String locator, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, locator, dynamicValues);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	protected void clickToElementByJS(WebDriver driver, String locator, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locator, dynamicValues));
	}

	protected void scrollToElement(WebDriver driver, String locator, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locator, dynamicValues));
	}
	
	protected String getElementValueByJS (WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return $(document.evaluate(\"" + locator + "\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue).val();");
	}

	protected void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locator, dynamicValues));
	}

	protected boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	protected String getElementValidationMessage(WebDriver driver, String locator, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, locator, dynamicValues));
	}

	protected boolean isImageLoaded(WebDriver driver, String locator, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, locator, dynamicValues));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	
	protected void waitForElementVisible(WebDriver driver, String locator, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator, dynamicValues)));
	}
	
	protected void waitForAllElementVisible(WebDriver driver, String locator, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locator, dynamicValues)));
	}
	
	protected void waitForElementInvisible(WebDriver driver, String locator, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator, dynamicValues)));
	}
	
	/*
	 * Wait for element is not displayed in DOM or not in DOM as well as override implicitWait
	 * @param driver
	 * @param locator
	 * @param dynamicValues
	 * @author Kiet Tran
	 */
	protected void waitForElementUndisplayed(WebDriver driver, String locator, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.SHORT_TIMEOUT);
		overrideImplicitTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator, dynamicValues)));
		overrideImplicitTimeout(driver, GlobalConstants.LONG_TIMEOUT);
	}
	
	protected void waitForAllElementInvisible(WebDriver driver, String locator, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElements(driver, locator, dynamicValues)));
	}
	
	protected void waitForElementClickable(WebDriver driver, String locator, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locator, dynamicValues)));
	}
	
	protected void uploadMultipleFiles(WebDriver driver, String... fileNames) {
		String fullFileNames = "";
		for (String file : fileNames) {
			fullFileNames = fullFileNames + GlobalConstants.UPLOAD_FILE + file + "\n";
		}
		getWebElement(driver, AdminBasePageUI.UPLOAD_FILE_INPUT).sendKeys(fullFileNames.trim());
	}
	
	public Set<Cookie> getAllCookie(WebDriver driver) {
		return driver.manage().getCookies();
	}
	
	public void setCookie(WebDriver driver, Set<Cookie> cookies) {
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}
		sleepInSecond(1);
	}
	
	public void OpenPageInMyAccountMenu(WebDriver driver, String pageName) {
		waitForElementClickable(driver, UserBasePageUI.DYNAMIC_PAGE_IN_MY_ACCOUNT_MENU, pageName);
		clickToElement(driver, UserBasePageUI.DYNAMIC_PAGE_IN_MY_ACCOUNT_MENU, pageName);
	}
	
	/**
	 * Enter to Dynamic Textbox by ID
	 * @param driver
	 * @param value
	 * @param textboxID
	 * @author Kiet Tran
	 */
	public void inputToTextboxByID(WebDriver driver, String value, String textboxID) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		sendkeyToElement(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, value, textboxID);
	}
	
	public UserHomePageObject clickToLogoutLink(WebDriver driver) {
		clickToElementByJS(driver, UserBasePageUI.LOGOUT_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public UserCustomerInforPageObject clickToMyAccountLink(WebDriver driver) {
		waitForElementClickable(driver, UserBasePageUI.MYACCOUNT_LINK);
		clickToElement(driver, UserBasePageUI.MYACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInforPage(driver);
	}
	
}
