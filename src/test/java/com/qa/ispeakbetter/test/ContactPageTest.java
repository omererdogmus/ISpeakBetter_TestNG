package com.qa.ispeakbetter.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ispeakbetter.base.BasePage;
import com.qa.ispeakbetter.pages.ContactPage;
import com.qa.ispeakbetter.pages.HomePage;
import com.qa.ispeakbetter.util.Constants;

public class ContactPageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	ContactPage contactPage;

	@BeforeMethod
	public void setUp() {

		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		homePage = new HomePage(driver);
		contactPage = homePage.doClickContact();
	}

	@Test(priority = 1, description = "verify page title", enabled = true)
	public void getContactPageTitle() {
		String title = contactPage.getContactPageTitle();
		System.out.println("Page title is : " + title);
		Assert.assertEquals(title, Constants.Contact_Page_Title);
	}

	@Test(priority = 2, description = "verify contact page header", enabled = true)
	public void getContactPageHeader() {
		String header = contactPage.getContactPageHeader();
		System.out.println("Contact page header is: " + header);
		Assert.assertEquals(header, Constants.Contact_Page_Header);
	}

	@Test(priority = 3, description = "verify hello text", enabled = true)
	public void getHelloText() {
		String hello = contactPage.getHelloText();
		System.out.println("Text is: " + hello);
		Assert.assertEquals(hello, Constants.Contact_Page_Small_Header);
	}

	@Test(priority = 7, description = "verify sending message with valid credentials", enabled = true)
	public void sendMessageWithValidCred() {
		contactPage.sendMessage();
		Assert.assertTrue(true, Constants.Contact_Page_Thank_You_Text);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
