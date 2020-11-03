package com.qa.ispeakbetter.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.ispeakbetter.base.BasePage;

public class ElementUtil extends BasePage {

	WebDriver driver;
	WebElement element;
	JavaScriptUtil jsUtil;
	WebDriverWait wait;

	// Constructor
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		jsUtil = new JavaScriptUtil(driver);
	}

	public String doGetPageTitle() {
		try {
			return driver.getTitle();
		} catch (Exception e) {
			System.out.println("some exception got occured while getting the title...");
		}
		return null;
	}

	public String doGetPageUrl() {
		try {
			return driver.getCurrentUrl();
		} catch (Exception e) {
			System.out.println("some exception got occured while getting URL...");
		}
		return null;
	}

	/**
	 * titleIs
	 * 
	 * @param title
	 * @return
	 */
	public boolean waitForTitlePresent(String title) {
		wait.until(ExpectedConditions.titleIs(title));
		return true;
	}

	/**
	 * presenceOfElementLocated
	 * 
	 * @param locator
	 * @return
	 */
	public boolean waitForElementPresent(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return true;
	}

	/**
	 * visibilityOfElementLocated
	 * 
	 * @param locator
	 * @return
	 */
	public boolean waitForElementVisible(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return true;
	}

	/**
	 * @author omer this method is used to create the weblement on the basis of By
	 *         locator
	 * @param locator
	 * @return
	 */
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
			if (flash.equals("yes")) {
				jsUtil.flash(element);
			}
		} catch (Exception e) {
			System.out.println("some exception got occured while creating the web element...");
		}
		return element;
	}

	/**
	 * this method is used to click the weblement on the basis of By locator
	 * 
	 * @param locator
	 */
	public void doClick(By locator) {
		try {
			getElement(locator).click();
		} catch (Exception e) {
			System.out.println("some exception got occured while clicking the web element...");
		}
	}

	/**
	 * this method is used to send value in a field
	 * 
	 * @param locator
	 * @param value
	 */
	public void doSendKeys(By locator, String value) {
		try {
			WebElement element = getElement(locator);
			element.clear();
			element.sendKeys(value);
		} catch (Exception e) {
			System.out.println("some exception got occured while entering values in a field...");
		}
	}

	/**
	 * isDisplayed
	 * 
	 * @param locator
	 * @return
	 */
	public boolean doIsDisplayed(By locator) {
		try {
			return getElement(locator).isDisplayed();
		} catch (Exception e) {
			System.out.println("some exception got occured...");
		}
		return false;
	}

	/**
	 * isEnabled
	 * 
	 * @param locator
	 * @return
	 */
	public boolean doIsEnabled(By locator) {
		try {
			return getElement(locator).isEnabled();
		} catch (Exception e) {
			System.out.println("some exception got occured...");
		}
		return false;
	}

	/**
	 * isSeelcted
	 * 
	 * @param locator
	 * @return
	 */
	public boolean doIsSelected(By locator) {
		try {
			return getElement(locator).isSelected();
		} catch (Exception e) {
			System.out.println("some exception got occured...");
		}
		return false;
	}

	/**
	 * Gettext
	 * 
	 * @param locator
	 * @return
	 */
	public String doGetText(By locator) {
		try {
			return getElement(locator).getText();
		} catch (Exception e) {
			System.out.println("some exception got occured while getting text...");
		}
		return null;
	}

	/**
	 * Select value from dropdown menu
	 * 
	 * @param element
	 * @param locator
	 * @param text
	 */
	public void doSelectByVisibleText(By locator, String text) {

		try {
			element = driver.findElement(locator);
			Select select = new Select(element);
			select.selectByVisibleText(text);
		} catch (Exception e) {
			System.out.println("some exception occured while selecting...");
		}

	}

	/**
	 * 
	 * @param wait
	 * @param locator
	 */

	public void doWaitElementToBeClickable(By locator) {
		try {
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (Exception e) {
			System.out.println("some exception occured while waiting for element to be clikable");
		}

	}

	public void doWaitPresenceOfElementLocated(By locator) {
		try {
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception e) {
			System.out.println("some exception occured while waiting for element");
		}
	}

	/**
	 * 
	 * @param wait
	 * @param locator
	 * @param text
	 */
	public void doWaitTextToBePresent(By locator, String text) {
		try {
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.textToBe(locator, text));
		} catch (Exception e) {
			System.out.println("some exception occured while waiting for text to be present");
		}
	}

	/**
	 * 
	 * @param title
	 */
	public void doWaitTitleToBePresent(String title) {
		try {
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.titleIs(title));
		} catch (Exception e) {
			System.out.println("some exception occured while waiting for title to be present");
		}
	}

	/**
	 * 
	 * @param url
	 */
	public void doWaitURLToBePresent(String url) {
		try {
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.urlMatches(url));
		} catch (Exception e) {
			System.out.println("some exception occured while waiting for url to be present");
		}
	}

	/**
	 * this method switches to next window
	 */
	public void doSwitchNextTab() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
	}

}
