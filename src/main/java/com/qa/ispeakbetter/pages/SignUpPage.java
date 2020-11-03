package com.qa.ispeakbetter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.ispeakbetter.util.Credentials;
import com.qa.ispeakbetter.util.ElementUtil;

public class SignUpPage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	//Constructor
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	// Locators
	By signUpLink = By.id("cmdSignupLink");
	By firstName = By.id("fname");
	By lastName = By.id("lname");
	By email = By.id("email");
	By password = By.id("password");
	By confirmPassword = By.id("confirmPass");
	By country = By.id("timezone");
	By checkTerms = By.id("check_term");
	By mobileNumber = By.id("mobile");
	By signUpBtn = By.id("cmdSignup");
	By invalidEmailText = By.id("alertmsg");
	
	// Methods
	public String getPageTitle() {
		return elementUtil.doGetPageTitle();
	}
	
	public void signUpWithValidCredentials(Credentials credentials) {
		elementUtil.doWaitElementToBeClickable(signUpLink);
		elementUtil.doClick(signUpLink);
		elementUtil.doSendKeys(firstName, credentials.getFirstName());
		elementUtil.doSendKeys(lastName, credentials.getLastName());
		elementUtil.doSendKeys(email, credentials.getEmail());
		elementUtil.doSendKeys(password, credentials.getPassword());
		elementUtil.doSendKeys(confirmPassword, credentials.getPassword());
		elementUtil.doSelectByVisibleText(country, "America - America/New_York");
		elementUtil.doSendKeys(mobileNumber, "0123456789");
		elementUtil.doClick(checkTerms);
		elementUtil.doClick(signUpBtn);
	}
	
	public void signUpWithInvalidCredentials(Credentials credentials) {
		elementUtil.doWaitElementToBeClickable(signUpLink);
		elementUtil.doClick(signUpLink);
		elementUtil.doSendKeys(firstName, credentials.getFirstName());
		elementUtil.doSendKeys(lastName, credentials.getLastName());
		elementUtil.doSendKeys(email, credentials.getEmail());
		elementUtil.doSendKeys(password, credentials.getPassword());
		elementUtil.doSendKeys(confirmPassword, credentials.getPassword());
		elementUtil.doSelectByVisibleText(country, "America - America/New_York");
		elementUtil.doSendKeys(mobileNumber, "0123456789");
		elementUtil.doClick(checkTerms);
		elementUtil.doClick(signUpBtn);
		elementUtil.doWaitTextToBePresent(invalidEmailText, "Email Invalid");
		String alertText = elementUtil.doGetText(invalidEmailText);
		System.out.println(alertText);
		
	}

}
