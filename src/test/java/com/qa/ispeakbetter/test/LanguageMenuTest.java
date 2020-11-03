package com.qa.ispeakbetter.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.ispeakbetter.base.BasePage;
import com.qa.ispeakbetter.pages.HomePage;
import com.qa.ispeakbetter.pages.LanguageMenu;
import com.qa.ispeakbetter.util.Constants;
import com.qa.ispeakbetter.util.ElementUtil;

public class LanguageMenuTest {

	WebDriver driver;
	Properties properties;
	ElementUtil elementUtil;
	BasePage basePage;
	HomePage homePage;
	LanguageMenu languageMenu;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		properties = basePage.init_properties();
		String browserName = properties.getProperty("browser");
		driver = basePage.init_driver(browserName);
		homePage = new HomePage(driver);
		languageMenu = homePage.doClickLanguageMenu();
		
	}

	@Test(priority = 1, description = "verify page title", enabled = true)
	public void verifyPageTitle() {
		String title = languageMenu.getPageTitle();
		System.out.println("Page title is : " + title);
		Assert.assertEquals(title, Constants.Home_Page_Title);
	}

	@Test(priority = 2, description = "verify number of languages", enabled = true)
	public void verifyNumberOfLanguages() {
		int numberOfLanguages = languageMenu.getLanguagesMenuNumber();
		Assert.assertEquals(numberOfLanguages, 6);
	}

	@Test(priority = 3, description = "verify languages names", enabled = true)
	public void homePageLanguageDropDownMenu() {
		languageMenu.dropDownLanguageMenuElements();
	}

	@Test(priority = 4, description = "verify english language header and title", enabled = true)
	public void selectingEnglish() {
		String englishHeader = languageMenu.chooseEnglishLanguage();
		Assert.assertEquals(englishHeader, Constants.English_Language_Header);
		String title = languageMenu.differentLanguagesPageTitle();
		Assert.assertEquals(title, Constants.Home_Page_Title);
	}

	@Test(priority = 5, description = "verify turkish language header", enabled = true)
	public void selectingTurksih() {
		String turkishHeader = languageMenu.chooseTurkishLanguage();
		Assert.assertEquals(turkishHeader, Constants.Turkish_Language_Header);
		String title = languageMenu.differentLanguagesPageTitle();
		Assert.assertEquals(title, Constants.Turkish_Page_Title);
	}

	@Test(priority = 6, description = "verify mongolian language header", enabled = true)
	public void selectingMongolian() {
		String mongolianHeader = languageMenu.chooseMongolianLanguage();
		Assert.assertEquals(mongolianHeader, Constants.Mongolian_Language_Header);
		String title = languageMenu.differentLanguagesPageTitle();
		Assert.assertEquals(title, Constants.Mongolian_Page_Title);
	}

	@Test(priority = 7, description = "verify chinese language header", enabled = true)
	public void selectingChinese() {
		String chineseHeader = languageMenu.chooseChineseLanguage();
		Assert.assertEquals(chineseHeader, Constants.Chinese_Language_Header);
		String title = languageMenu.differentLanguagesPageTitle();
		Assert.assertEquals(title, Constants.Chinese_Page_Title);
	}

	@Test(priority = 8, description = "verify russian language header", enabled = true)
	public void selectingRussian() {
		String russianHeader = languageMenu.chooseRussianLanguage();
		Assert.assertEquals(russianHeader, Constants.Russian_Language_Header);
		String title = languageMenu.differentLanguagesPageTitle();
		Assert.assertEquals(title, Constants.Russian_Page_Title);
	}

	@Test(priority = 9, description = "verify arabic language header", enabled = true)
	public void selectingArabic() {
		String arabicHeader = languageMenu.chooseArabicLanguage();
		Assert.assertEquals(arabicHeader, Constants.Arabic_Language_Header);
		String title = languageMenu.differentLanguagesPageTitle();
		Assert.assertEquals(title, Constants.Arabic_Page_Title);
	}

	@AfterMethod
	public void tearDown() {
		basePage.quitBrowser();
	}

}
