package com.qa.ispeakbetter.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qa.ispeakbetter.util.Constants;
import com.qa.ispeakbetter.util.ElementUtil;

public class LanguageMenu {

	WebDriver driver;
	ElementUtil elementUtil;

	// Constructor
	public LanguageMenu(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	// Locators
	
	By dropDownMenu = By.xpath("//a[@class='dropdown-item']");
	By english = By.xpath("//a[contains(text(),'English')]");
	By englishHeader = By.xpath("//h1[contains(text(),'Speak English Better Wherever You Are')]");
	By turkish = By.xpath("//a[contains(text(),'Turkish')]");
	By turkishHeader = By.xpath("//h1[contains(text(),'Daha İyi İngilizce Konuşmak İster Misiniz?')]");
	By mongolian = By.xpath("//a[contains(text(),'Mongolian')]");
	By mongolianHeader = By.xpath("//h1[contains(text(),'Do You Want To Speak English Better?')]");
	By chinese = By.xpath("//a[contains(text(),'Chinese')]");
	By chineseHeader = By.xpath("//h1[contains(text(),'不論您身在何處，都將說一口更流利的英語')]");
	By russian = By.xpath("//a[contains(text(),'Russian')]");
	By russianHeader = By.xpath("//h1[contains(text(),'Разговаривайте на английском, где бы вы ни были')]");
	By arabic = By.xpath("//a[contains(text(),'Arabic')]");
	By arabicHeader = By.xpath("//h1[contains(text(),'تكلم الإنجليزية بشكل أفضل أينما كنت')]");

	// Methods
	public String getPageTitle() {
		return elementUtil.doGetPageTitle();
	}

	public List<WebElement> dropDownLanguageMenuElements() {
		List<WebElement> languageMenu = driver.findElements(dropDownMenu);
		for (int i = 0; i < languageMenu.size(); i++) {
			System.out.println(languageMenu.get(i).getText());
		}
		return languageMenu;
	}

	public int getLanguagesMenuNumber() {
		List<WebElement> languageMenu = driver.findElements(dropDownMenu);
		System.out.println(languageMenu.size());
		return languageMenu.size();
	}

	public String chooseEnglishLanguage() {
		elementUtil.doWaitElementToBeClickable(english);
		elementUtil.doClick(english);
		elementUtil.doWaitTextToBePresent(englishHeader, Constants.English_Language_Header);
		String header = elementUtil.doGetText(englishHeader);
		System.out.println(header);
		return header;
	}

	public String chooseTurkishLanguage() {
		elementUtil.doClick(turkish);
		elementUtil.doWaitTextToBePresent(turkishHeader, Constants.Turkish_Language_Header);
		elementUtil.doGetText(turkishHeader);
		String header = elementUtil.doGetText(turkishHeader);
		System.out.println(header);
		return header;
	}

	public String chooseMongolianLanguage() {
		elementUtil.doWaitElementToBeClickable(mongolian);
		elementUtil.doClick(mongolian);
		elementUtil.doWaitTextToBePresent(mongolianHeader, Constants.Mongolian_Language_Header);
		String header = elementUtil.doGetText(mongolianHeader);
		System.out.println(header);
		return header;
	}

	public String chooseChineseLanguage() {
		elementUtil.doWaitElementToBeClickable(chinese);
		elementUtil.doClick(chinese);
		elementUtil.doWaitTextToBePresent(chineseHeader, Constants.Chinese_Language_Header);
		String header = elementUtil.doGetText(chineseHeader);
		System.out.println(header);
		return header;
	}

	public String chooseRussianLanguage() {
		elementUtil.doWaitElementToBeClickable(russian);
		elementUtil.doClick(russian);
		elementUtil.doWaitTextToBePresent(russianHeader, Constants.Russian_Language_Header);
		String header = elementUtil.doGetText(russianHeader);
		System.out.println(header);
		return header;
	}

	public String chooseArabicLanguage() {
		elementUtil.doWaitElementToBeClickable(arabic);
		elementUtil.doClick(arabic);
		elementUtil.doWaitTextToBePresent(arabicHeader, Constants.Arabic_Language_Header);
		String header = elementUtil.doGetText(arabicHeader);
		System.out.println(header);
		return header;
	}

	public String differentLanguagesPageTitle() {
		String title = elementUtil.doGetPageTitle();
		System.out.println(title);
		return title;
	}
}
