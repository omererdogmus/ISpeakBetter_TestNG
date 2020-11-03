package com.qa.ispeakbetter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ispeakbetter.util.Constants;
import com.qa.ispeakbetter.util.ElementUtil;
import com.qa.ispeakbetter.util.JavaScriptUtil;

public class HomePage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil javaScriptUtil;

	// Locators
	By languageMenu = By.id("dropdownMenuLink");
	By faqLink = By.xpath("//a[contains(text(),'FAQ')]");
	By policyLink = By.xpath("//body/footer[1]/div[4]/p[1]/a[2]");
	By termsLink = By.xpath("//a[contains(text(), 'Terms & Conditions')]");
	By loginLink = By.xpath("//a[@id='cmdSiginLink']");
	By signUpLink = By.id("cmdSignupLink");
	By contactPage = By.xpath("//span[contains(text(),'Contact')]");
	By email = By.id("_email");
	By password = By.id("_password");
	By loginBtn= By.id("cmdSignin");
	
	// Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		javaScriptUtil = new JavaScriptUtil(driver);
	}

	// Methods
	
	// Page title method
	public String getPageTitle() {
		return elementUtil.doGetPageTitle();
	}
	
	// Page url method
	public String getPageUrl() {
		return elementUtil.doGetPageUrl();
	}
	
	// Navigate to Language Menu
	public LanguageMenu doClickLanguageMenu() {
		elementUtil.doWaitElementToBeClickable(languageMenu);
		elementUtil.doClick(languageMenu);
		return new LanguageMenu(driver);
	}
	
	// Navigate FAQ
	public FAQPage doClickFAQ() {
		elementUtil.doWaitPresenceOfElementLocated(faqLink);
		elementUtil.doClick(faqLink);
		return new FAQPage(driver);
	}
	
	// Navigate Privacy Policy
	public PrivacyPolicyPage doClickPrivacyPolicy() {
		elementUtil.doWaitPresenceOfElementLocated(policyLink);
		elementUtil.doClick(policyLink);
		return new PrivacyPolicyPage(driver);
	}
	
	// Navigate Terms and Conditions
	public TermsAndConditions doClickTermsAndConditions() {
		elementUtil.doWaitPresenceOfElementLocated(termsLink);
		elementUtil.doClick(termsLink);
		return new TermsAndConditions(driver);
	}
	
	// Navigate Login
	public LoginPage doClickLoginLink() {
		elementUtil.doWaitElementToBeClickable(loginLink);
		elementUtil.doClick(loginLink);
		return new LoginPage(driver);
	}
	
	// Navigate SignUp
	public SignUpPage doClickSignUpLink() {
		elementUtil.doWaitElementToBeClickable(signUpLink);
		elementUtil.doClick(signUpLink);
		return new SignUpPage(driver);
	}	
	
	// Navigate Contact
	public ContactPage doClickContact() {
		elementUtil.doWaitElementToBeClickable(contactPage);
		elementUtil.doClick(contactPage);
		return new ContactPage(driver);
	}
	
	//Navigate Student Page
	public StudentPage loginStudent() {
		elementUtil.doWaitElementToBeClickable(loginLink);
		elementUtil.doClick(loginLink);
		elementUtil.doSendKeys(email, Constants.Email);
		elementUtil.doSendKeys(password, Constants.Password);
		elementUtil.doClick(loginBtn);
		return new StudentPage(driver);
	}

}
