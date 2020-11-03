package com.qa.ispeakbetter.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qa.ispeakbetter.util.Constants;
import com.qa.ispeakbetter.util.ElementUtil;

public class StudentPage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	//Locators
	
	By greeting = By.xpath("//strong[contains(text(),'Burcu')]");
	By launchPad = By.xpath("//a[contains(text(), 'Launch Pad')]");
	By profile = By.xpath("//*[@id=\"subnav\"]/div/div[1]/ul/li[3]/a");
	By personalInfoHeader = By.xpath("//legend[contains(text(),'Personal Info')]");
	By studentname = By.id("studentname");
	By updateBtn = By.xpath("//button[contains(text(),'Update')]");
	By submitBtn = By.xpath("//button[@id='cmdSignin']");
	
	public StudentPage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	
	public String getPageTitle() {
		elementUtil.doWaitTitleToBePresent(Constants.Student_Page_Title);
		return driver.getTitle();
	}
	
	public String getGreetingText() {
		elementUtil.doWaitTextToBePresent(greeting, "Burcu");
		return elementUtil.doGetText(greeting);
	}
	
	public int launchPad() {
		elementUtil.doClick(launchPad);
		List<WebElement> launchpadList = driver.findElements(launchPad);
		System.out.println(launchpadList.size());
		for(int i = 0; i < launchpadList.size(); i++) {
			String list = launchpadList.get(i).getText();
			System.out.println(list);
		}
		return launchpadList.size();
	}
	
	
}
