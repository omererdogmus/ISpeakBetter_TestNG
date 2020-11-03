package com.qa.ispeakbetter.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ispeakbetter.base.BasePage;
import com.qa.ispeakbetter.pages.HomePage;
import com.qa.ispeakbetter.pages.TermsAndConditions;
import com.qa.ispeakbetter.util.Constants;

public class TermsAndConditionsTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties properties;
	TermsAndConditions termsAndConditions;
	HomePage homePage;
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		properties = basePage.init_properties();
		String browserName = properties.getProperty("browser");
		driver = basePage.init_driver(browserName);
		homePage = new HomePage(driver);
		termsAndConditions = homePage.doClickTermsAndConditions();
	}
	
	@Test(priority = 1, description = "verify page title", enabled = true)
	public void verifyPageTitle() {
		String title = termsAndConditions.getPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.Terms_And_Conditions_Page_Title);
	}
	
	@Test(priority = 2, description = "verify page header", enabled = true)
	public void verifyPageHeader() {
		termsAndConditions.getPageHeader();
		String header = termsAndConditions.getPageHeader();
		System.out.println(header);
		Assert.assertEquals(header, Constants.Terms_And_Conditions_Page_Header);
	}
	
	@Test(priority = 3, description = "verify url", enabled = true)
	public void verifyUrl() {
		termsAndConditions.getPageUrl();
		String url = termsAndConditions.getPageUrl();
		System.out.println(url);
		Assert.assertEquals(url, Constants.Terms_And_Conditions_Page_URL);
	}
	
	@AfterMethod
	public void tearDown() {
		basePage.quitBrowser();
	}

}
