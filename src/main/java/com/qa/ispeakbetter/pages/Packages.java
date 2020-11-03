package com.qa.ispeakbetter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.ispeakbetter.util.ElementUtil;

public class Packages {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	// Constructor
	public Packages(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	// Locators
	By duration = By.id("class_duration");
	By packageLength = By.id("package_length");
	By classes = By.id("per_week_class_number");
	By program = By.id("course_program");
	By promoCode = By.id("promo_code");
	By buyBtn = By.id("cmdPurchase");
	By currencySign = By.id("currencyHolder");
	By price = By.id("result-price");
	
	// Methods
	public String getPageTitle() {
		return elementUtil.doGetPageTitle();
	}
	
	public String selecPackage() {
		elementUtil.doSelectByVisibleText(duration, "60");
		elementUtil.doSelectByVisibleText(packageLength, "12 weeks");
		elementUtil.doSelectByVisibleText(classes, "4 Classes");
		elementUtil.doSelectByVisibleText(program, "TOEFL");
		elementUtil.doSendKeys(promoCode, "test123test");
		elementUtil.doWaitTextToBePresent(currencySign, "$");
		elementUtil.doWaitTextToBePresent(price, "768");
		String dollarSign = elementUtil.doGetText(currencySign);
		String resultPrice = elementUtil.doGetText(price);
		String totalPrice = dollarSign + resultPrice;
		System.out.println(totalPrice);
		elementUtil.doWaitElementToBeClickable(buyBtn);
		elementUtil.doClick(buyBtn);
		return totalPrice;
	}
}
