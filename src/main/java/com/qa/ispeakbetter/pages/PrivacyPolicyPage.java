package com.qa.ispeakbetter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ispeakbetter.util.Constants;
import com.qa.ispeakbetter.util.ElementUtil;

public class PrivacyPolicyPage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	// Constructor
	public PrivacyPolicyPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	// Locators
	By policyHeader = By.xpath("//span[contains(text(),'The ISpeakBetter Privacy Policy')]");
	
	// Methods
	public String getPageTitle() {
		elementUtil.doSwitchNextTab();
		elementUtil.doWaitTitleToBePresent(Constants.Privacy_Policy_Page_Title);
		return elementUtil.doGetPageTitle();
	}
	
	public String getPageHeader() {
		elementUtil.doSwitchNextTab();
		elementUtil.doWaitTextToBePresent(policyHeader, Constants.Privacy_Policy_Page_Header);
		String header = elementUtil.doGetText(policyHeader);
		return header;
	}
	
	public String getPageUrl() {
		elementUtil.doSwitchNextTab();
		elementUtil.doWaitURLToBePresent(Constants.Privacy_Policy_Page_URL);
		return elementUtil.doGetPageUrl();
	}

}
