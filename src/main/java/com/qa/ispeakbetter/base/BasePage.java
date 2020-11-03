package com.qa.ispeakbetter.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.ispeakbetter.base.OptionsManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public WebDriver driver;
	public Properties properties;
	public String flash;
	public OptionsManager optionsManager;

public WebDriver init_driver(String browserName) {
		
		optionsManager = new OptionsManager(properties);
		
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(optionsManager.getChromeOptions());
		} 
		else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
		}
		else if(browserName.equals("opera")) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		}
		else if(browserName.equals("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			driver = new SafariDriver();
		} else {
			System.out.println(browserName  + " is not found");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(properties.getProperty("url"));
		
		return driver;
	}

	public Properties init_properties() {

		properties = new Properties();
		String path = "/Users/omererdogmus/Documents/eclipse-workspace/ISpeakBetter2020"
				+ "/src/main/java/com/qa/ispeakbetter/config/config.properties";

		try {
			FileInputStream fileInputStream = new FileInputStream(path);
			properties.load(fileInputStream);
		} catch (FileNotFoundException e) {
			System.out.println("Some issue with config properties... Please correct your config...!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

	public void quitBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println("Some exception occured while quitting browser...!");
		}
	}

	public void closeBrowser() {
		try {
			driver.close();
		} catch (Exception e) {
			System.out.println("Some exception occured while closing browser...!");
		}
	}
}
