package com.qa.ispeakbetter.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ispeakbetter.base.BasePage;
import com.qa.ispeakbetter.pages.HomePage;
import com.qa.ispeakbetter.pages.SignUpPage;
import com.qa.ispeakbetter.util.Constants;
import com.qa.ispeakbetter.util.Credentials;
import com.qa.ispeakbetter.util.ElementUtil;

public class SignUpPageTest {

	BasePage basePage;
	WebDriver driver;
	Properties properties;
	Credentials userCredValid;
	Credentials userCredInvalid;
	HomePage homePage;
	SignUpPage homePageSignUp;
	ElementUtil elementUtil;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		properties = basePage.init_properties();
		String browserName = properties.getProperty("browser");
		driver = basePage.init_driver(browserName);
		homePage = new HomePage(driver);
		homePageSignUp = homePage.doClickSignUpLink();
		userCredValid = new Credentials(properties.getProperty("name"), properties.getProperty("lastname"),
				properties.getProperty("email"), properties.getProperty("password"), properties.getProperty("password"),
				properties.getProperty("number"));
		userCredInvalid = new Credentials(properties.getProperty("name"), properties.getProperty("lastname"),
				properties.getProperty("invalidemail"), properties.getProperty("password"), properties.getProperty("password"),
				properties.getProperty("number"));

	}

	@Test(priority = 1, description = "verify page title", enabled = true)
	public void getPageTitle() {
		String title = homePageSignUp.getPageTitle();
		System.out.println("Page title is : " + title);
		Assert.assertEquals(title, Constants.Home_Page_Title);
	}

	@Test(priority = 2, description = "signing up with valid credentials as a new user", enabled = true)
	public void signUpValid() {
		homePageSignUp.signUpWithValidCredentials(userCredValid);
	}

	@Test(priority = 3, description = "signing up with invalid credentials as a new user", enabled = true)
	public void signUpInvalid() {
		homePageSignUp.signUpWithInvalidCredentials(userCredInvalid);
		String alertText = "Email Invalid";
		Assert.assertEquals(alertText, Constants.Invalid_Email_Message);
	}
	
	@AfterMethod
	public void tearDown() {
		basePage.quitBrowser();
	}

}
