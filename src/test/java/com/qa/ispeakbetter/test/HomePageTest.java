package com.qa.ispeakbetter.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ispeakbetter.base.BasePage;
import com.qa.ispeakbetter.pages.HomePage;
import com.qa.ispeakbetter.util.Constants;

public class HomePageTest {

	HomePage homepage;
	BasePage basePage;
	WebDriver driver;
	Properties properties;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		properties = basePage.init_properties();
		String browserName = properties.getProperty("browser");
		driver = basePage.init_driver(browserName);
		homepage = new HomePage(driver);
	}

	@Test(priority = 1, description = "verify home page title")
	public void verifyHomePageTitle() {
		String title = homepage.getPageTitle();
		System.out.println("Home page title is : " + title);
		Assert.assertEquals(title, Constants.Home_Page_Title);
	}
	
	@Test(priority = 2, description = "verify home page url")
	public void verifyPageUrl() {
		String url = homepage.getPageUrl();
		System.out.println("Page url is : " + url);
		Assert.assertEquals(url, Constants.Home_Page_URL);
	}

	@AfterMethod
	public void tearDown() {
		basePage.quitBrowser();
	}

}
