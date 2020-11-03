package com.qa.ispeakbetter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ispeakbetter.base.BasePage;
import com.qa.ispeakbetter.util.ElementUtil;

public class ContactPage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;

	// Constructor
	public ContactPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	// Locators
	By header = By.xpath("//span[contains(text(),'Contact us')]");
	By helloText = By.xpath("//div[contains(text(),'WANNA SAY HELLO?')]");
	By name = By.name("name");
	By email = By.name("email");
	By subject = By.name("subject");
	By message = By.name("message");
	By contactUsBtn = By.xpath("//body/div[@id='page']/section[@id='contact-section']/"
			+ "div[1]/div[3]/div[1]/form[1]/fieldset[1]/div[3]/input[1]");
	By thanksMessage = By.xpath("//div[contains(text(),'Thanks for contacting us!')]");

	// Methods
	public String getContactPageTitle() {
		return elementUtil.doGetPageTitle();
	}

	public String getContactPageHeader() {
		elementUtil.doWaitTextToBePresent(header, "Contact us");
		return elementUtil.doGetText(header);
	}

	public String getHelloText() {
		elementUtil.doWaitTextToBePresent(helloText, "WANNA SAY HELLO?");
		return elementUtil.doGetText(helloText);
	}

	public void sendMessage() {
		elementUtil.doSendKeys(name, "Test");
		elementUtil.doSendKeys(email, "test@test.com");
		elementUtil.doSelectByVisibleText(subject, "Others");
		elementUtil.doSendKeys(message, "test");
		elementUtil.doClick(contactUsBtn);
	}
}
