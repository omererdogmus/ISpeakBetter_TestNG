package com.qa.ispeakbetter.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ispeakbetter.base.BasePage;
import com.qa.ispeakbetter.pages.FAQPage;
import com.qa.ispeakbetter.pages.HomePage;
import com.qa.ispeakbetter.util.Constants;

public class FAQPageTest {

	WebDriver driver;
	BasePage basePage;
	Properties properties;
	FAQPage faq;
	HomePage homePage;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		properties = basePage.init_properties();
		String browserName = properties.getProperty("browser");
		driver = basePage.init_driver(browserName);
		homePage = new HomePage(driver);
		faq = homePage.doClickFAQ();
	}

	@Test(priority = 1, description = "verify page title", enabled = true)
	public void verifyPageTitle() {
		String title = faq.getPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.FAQ_Page_Title);
	}

	@Test(priority = 2, description = "verify page header", enabled = true)
	public void verifyPageHeader() {
		faq.getPageHeader();
		String header = faq.getPageHeader();
		System.out.println(header);
		Assert.assertEquals(header, Constants.FAQ_Page_Header);
	}

	@Test(priority = 3, description = "verify url", enabled = true)
	public void verifyUrl() {
		faq.getPageUrl();
		String url = faq.getPageUrl();
		System.out.println(url);
		Assert.assertEquals(url, Constants.FAQ_Page_URL);
	}

	@AfterMethod
	public void tearDown() {
		basePage.quitBrowser();
	}

}
