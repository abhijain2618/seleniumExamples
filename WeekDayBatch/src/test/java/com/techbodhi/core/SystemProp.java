package com.techbodhi.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.techbodhi.constants.Constant;

public class SystemProp {

	public static void getFireFoxProperty() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Selenium\\geckodriver.exe");
	}

	public static void getChromeProperty() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Selenium\\chromedriver.exe");
	}
	
	public static void getIEProperty() {
		System.setProperty("webdriver.ie.driver",
				"C:\\Selenium\\chromedriver.exe");
	}


	public static WebDriver getDriver(String browserName) {
		if (browserName.equalsIgnoreCase("ie")) {
			getIEProperty();
			WebDriver driver = new InternetExplorerDriver();
			return driver;
		}
		else if (browserName.equalsIgnoreCase("chrome")) {
			getChromeProperty();
			return new ChromeDriver();
		}else{
			getFireFoxProperty();
			WebDriver driver = new FirefoxDriver();
			return driver;
		}
		
	}
	public static WebDriver getDriver() {
		PropertySystem propertySystem = new PropertySystem(Constant.PROPERTIES_FILE_NAME);
		String browserName = propertySystem.getProperty("BROWSER");
		System.out.println(browserName);
		if (browserName.equalsIgnoreCase("ie")) {
			getIEProperty();
			WebDriver driver = new InternetExplorerDriver();
			return driver;
		}
		else if (browserName.equalsIgnoreCase("chrome")) {
			getChromeProperty();
			return new ChromeDriver();
		}else{
			getFireFoxProperty();
			WebDriver driver = new FirefoxDriver();
			return driver;
		}
		
	}
}
