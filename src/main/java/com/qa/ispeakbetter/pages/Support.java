package com.qa.ispeakbetter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ispeakbetter.util.ElementUtil;

public class Support {

	WebDriver driver;
	ElementUtil elementUtil;

	// Constructor
	public Support(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		
	}

	// Locators
	By supportBtn = By.id("zsiq_agtpic");
	By frameLoc = By.id("siqiframe");
	By nameInput = By.id("visname");
	By emailInput = By.id("visemail");
	By msgInput = By.id("msgarea");
	By startChatBtn = By.id("sqico-send");
	By errorMsg = By.id("info_banr");
	By twitter = By.className("fa fa-twitter wow fadeIn animated");

	// Methods
	public String getPageTitle() {
		return elementUtil.doGetPageTitle();
	}

	public void chatWithUsWithValidCredentials() {
		elementUtil.doClick(supportBtn);
		driver.switchTo().frame("siqiframe");
		elementUtil.doSendKeys(nameInput, "test");
		elementUtil.doSendKeys(emailInput, "test@test.com");
		elementUtil.doSendKeys(msgInput, "test123test");
		elementUtil.doClick(startChatBtn);
	}

	public void chatWithUsWithInvalidCredentials() {
		elementUtil.doClick(supportBtn);
		driver.switchTo().frame("siqiframe");
		elementUtil.doSendKeys(nameInput, "test");
		elementUtil.doSendKeys(emailInput, "test@test");
		elementUtil.doSendKeys(msgInput, "test123test");
		elementUtil.doWaitTextToBePresent(errorMsg, "Please enter a valid email address");
		String text = elementUtil.doGetText(errorMsg);
		System.out.println(text);
	}

}
