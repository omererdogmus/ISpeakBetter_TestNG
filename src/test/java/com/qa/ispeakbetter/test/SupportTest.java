package com.qa.ispeakbetter.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ispeakbetter.base.BasePage;
import com.qa.ispeakbetter.pages.Support;
import com.qa.ispeakbetter.util.Constants;
import com.qa.ispeakbetter.util.Credentials;

public class SupportTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties properties;
	Credentials credentials;
	Support homePageSupport;
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		properties = basePage.init_properties();
		String browserName = properties.getProperty("browser");
		driver = basePage.init_driver(browserName);
		homePageSupport = new Support(driver);
	}
	
	@Test(priority = 1, description = "verify page title", enabled = true)
	public void verifyPageTitle() {
		String title = homePageSupport.getPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.Home_Page_Title);
	}
	
	@Test(priority = 2, description = "sending valid credentials to support section", enabled = true)
	public void supportSectionValidCredentials() {
		homePageSupport.chatWithUsWithValidCredentials();
	}
	
	@Test(priority = 3, description = "sending invalid credentials to support section", enabled = true)
	public void supportSectionInvalidCredentials() {
		homePageSupport.chatWithUsWithInvalidCredentials();
		String text = "Please enter a valid email address";
		Assert.assertEquals(text, Constants.Support_Email_Warning);
	}
	
	@AfterMethod
	public void tearDown() {
		basePage.quitBrowser();
	}

}
