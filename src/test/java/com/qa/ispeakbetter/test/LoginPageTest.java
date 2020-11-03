package com.qa.ispeakbetter.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.ispeakbetter.base.BasePage;
import com.qa.ispeakbetter.pages.HomePage;
import com.qa.ispeakbetter.pages.LoginPage;
import com.qa.ispeakbetter.util.Constants;
import com.qa.ispeakbetter.util.Credentials;

public class LoginPageTest {

	WebDriver driver;
	BasePage basePage;
	Properties properties;
	Credentials userCred;
	HomePage homePage;
	LoginPage homePageLogin;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		properties = basePage.init_properties();
		String browserName = properties.getProperty("browser");
		driver = basePage.init_driver(browserName);
		homePage = new HomePage(driver);
		homePageLogin = homePage.doClickLoginLink();
		userCred = new Credentials(properties.getProperty("username"), properties.getProperty("password"));
	}

	@Test(priority = 1, description = "verify page title", enabled = true)
	public void verifyPageTitle() {
		String title = homePageLogin.getPageTitle();
		System.out.println("Page title is : " + title);
		Assert.assertEquals(title, Constants.Home_Page_Title);
	}

	@Test(priority = 2, description = "login with valid credentials", enabled = true)
	public void validLogin() {
		homePageLogin.loginWithValidCredentials(userCred);
	}
	
	@DataProvider
	public Object [][] getLoginInvalidData(){
		Object data[][] = {{"omer","test123"},
						   {"cristine","123test"},
						   {"john","sample1234"},
						   {"meekmill","drake123"}

		};
		return data;
	}
	
	@Test(priority = 3, dataProvider = "getLoginInvalidData", enabled = true)
	public void loginWithInvalidTestCase(String userName, String password) {
		userCred.setUserName(userName);
		userCred.setPassword(password);
		homePageLogin.loginWithValidCredentials(userCred);
		Assert.assertTrue(homePageLogin.checkLoginErrorMessage());
	}

	@AfterMethod
	public void tearDown() {
		basePage.quitBrowser();
	}

}
