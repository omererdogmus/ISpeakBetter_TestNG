package com.qa.ispeakbetter.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ispeakbetter.base.BasePage;
import com.qa.ispeakbetter.pages.HomePage;
import com.qa.ispeakbetter.pages.StudentPage;
import com.qa.ispeakbetter.util.Constants;

public class StudentPageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	StudentPage studentPage;
	
	@BeforeMethod
	public void setUp()  {
		
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		homePage = new HomePage(driver);
		studentPage = homePage.loginStudent();
	}
	@Test(priority = 1, description="verify page title method", enabled = false)
	public void verifystudentPageTitleTest() {
		String title = studentPage.getPageTitle();
		System.out.println("StudentPage title is : " + title);
		Assert.assertEquals(title, Constants.Student_Page_Title);
		
	}
	@Test(priority = 2, description = "Verify Greeting text" , enabled = false)
	public void checkGreetingText() {		
		String name = studentPage.getGreetingText();
		System.out.println("Greeting text is : " + name);
		Assert.assertEquals(name, "Burcu");
	}   
    @Test(priority = 3, description = "Verify launch pad menu", enabled = false)
	 public void launchPadMenu() {
    	studentPage.launchPad();
    	Assert.assertEquals(studentPage.launchPad(), 7);
    }
     
	@AfterMethod
	public void tearDown() {
		basePage.quitBrowser();
	}
}


