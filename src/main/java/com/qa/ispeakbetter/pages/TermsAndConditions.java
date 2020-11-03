package com.qa.ispeakbetter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ispeakbetter.util.Constants;
import com.qa.ispeakbetter.util.ElementUtil;

public class TermsAndConditions {

	WebDriver driver;
	ElementUtil elementUtil;

	// Constructor
	public TermsAndConditions(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	// Locator
	By headerText = By.xpath("//span[contains(text(), 'The ISpeakBetter Terms & Conditions')]");

	// Methods
	public String getPageTitle() {
		elementUtil.doSwitchNextTab();
		elementUtil.doWaitTitleToBePresent(Constants.Terms_And_Conditions_Page_Title);
		return elementUtil.doGetPageTitle();
	}

	public String getPageHeader() {
		elementUtil.doSwitchNextTab();
		elementUtil.doWaitTextToBePresent(headerText, Constants.Terms_And_Conditions_Page_Header);
		String header = elementUtil.doGetText(headerText);
		return header;
	}

	public String getPageUrl() {
		elementUtil.doSwitchNextTab();
		elementUtil.doWaitURLToBePresent(Constants.Terms_And_Conditions_Page_URL);
		return elementUtil.doGetPageUrl();
	}

}
