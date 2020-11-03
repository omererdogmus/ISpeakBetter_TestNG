package com.qa.ispeakbetter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.ispeakbetter.util.Constants;
import com.qa.ispeakbetter.util.Credentials;
import com.qa.ispeakbetter.util.ElementUtil;

public class LoginPage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	// Locator
	By userName = By.id("_email");
	By password = By.id("_password");
	By loginBtn = By.id("cmdSignin");
	By credentialError = By.id("crendentialsError");
	
	// Methods
	public String getPageTitle() {
		return elementUtil.doGetPageTitle();
	}
	
	public void loginWithValidCredentials(Credentials credentials) {
		elementUtil.doSendKeys(userName, credentials.getUserName());
		elementUtil.doSendKeys(password, credentials.getPassword());
		elementUtil.doClick(loginBtn);
	}
	
	public boolean checkLoginErrorMessage() {
		elementUtil.doWaitTextToBePresent(credentialError, Constants.Credential_Invalid_Login_Error);
		return elementUtil.doIsDisplayed(credentialError);
	}
}
