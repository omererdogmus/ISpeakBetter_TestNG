package com.qa.ispeakbetter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ispeakbetter.util.Constants;
import com.qa.ispeakbetter.util.ElementUtil;

public class FAQPage {

	WebDriver driver;
	ElementUtil elementUtil;

	// Constructor
	public FAQPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	// Locators
	By faqHeader = By.xpath("//span[contains(text(), 'ISpeakBetter Knowledge Base')]");

	// Methods
	public String getPageTitle() {
		elementUtil.doWaitTitleToBePresent(Constants.FAQ_Page_Title);
		return elementUtil.doGetPageTitle();
	}

	public String getPageHeader() {
		elementUtil.doWaitTextToBePresent(faqHeader, Constants.FAQ_Page_Header);
		String header = elementUtil.doGetText(faqHeader);
		return header;
	}

	public String getPageUrl() {
		elementUtil.doWaitURLToBePresent(Constants.FAQ_Page_URL);
		return elementUtil.doGetPageUrl();
	}

}
