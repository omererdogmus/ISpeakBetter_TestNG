package com.qa.ispeakbetter.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ispeakbetter.base.BasePage;
import com.qa.ispeakbetter.pages.HomePage;
import com.qa.ispeakbetter.pages.PrivacyPolicyPage;
import com.qa.ispeakbetter.util.Constants;

public class PrivacyPolicyPageTest {

	WebDriver driver;
	BasePage basePage;
	Properties properties;
	PrivacyPolicyPage privacyPolicy;
	HomePage homePage;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		properties = basePage.init_properties();
		String browserName = properties.getProperty("browser");
		driver = basePage.init_driver(browserName);
		homePage = new HomePage(driver);
		privacyPolicy = homePage.doClickPrivacyPolicy();
	}

	@Test(priority = 1, description = "verify page title", enabled = true)
	public void verifyPageTitle() {
		String title = privacyPolicy.getPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.Privacy_Policy_Page_Title);
	}

	@Test(priority = 2, description = "verify page header", enabled = true)
	public void verifyPageHeader() {
		String header = privacyPolicy.getPageHeader();
		System.out.println(header);
		Assert.assertEquals(header, Constants.Privacy_Policy_Page_Header);
	}

	@Test(priority = 3, description = "verify url", enabled = true)
	public void verifyUrl() {
		privacyPolicy.getPageUrl();
		String url = privacyPolicy.getPageUrl();
		System.out.println(url);
		Assert.assertEquals(url, Constants.Privacy_Policy_Page_URL);
	}

	@AfterMethod
	public void tearDown() {
		basePage.quitBrowser();
	}
}
