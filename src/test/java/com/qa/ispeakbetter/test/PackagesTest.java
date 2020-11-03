package com.qa.ispeakbetter.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ispeakbetter.base.BasePage;
import com.qa.ispeakbetter.pages.Packages;
import com.qa.ispeakbetter.util.Constants;
import com.qa.ispeakbetter.util.ElementUtil;

public class PackagesTest {

	WebDriver driver;
	BasePage basePage;
	ElementUtil elementUtil;
	Packages homePagePackages;
	Properties properties;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		properties = basePage.init_properties();
		String browserName = properties.getProperty("browser");
		driver = basePage.init_driver(browserName);
		homePagePackages = new Packages(driver);
	}

	@Test(priority = 1, description = "verify page title", enabled = true)
	public void verifyPageTitle() {
		String title = homePagePackages.getPageTitle();
		System.out.println("Page title is : " + title);
		Assert.assertEquals(title, Constants.Home_Page_Title);
	}

	@Test(priority = 2, description = "selecting a classes and duration", enabled = true)
	public void selectAPackage() {
		String price = homePagePackages.selecPackage();
		Assert.assertEquals(price, "$768");
	}

	@AfterMethod
	public void tearDown() {
		basePage.quitBrowser();
	}

}
