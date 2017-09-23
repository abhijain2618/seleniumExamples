package com.techbodhi.selenium.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SystemProp {

	public static void getFireFoxProperties(){
		System.setProperty("webdriver.gecko.driver",
				"C:\\Selenium\\geckodriver.exe");
	}
	public static void getChromeProperties(){
		System.setProperty("webdriver.chrome.driver",
				"C:\\Selenium\\chromedriver.exe");
	}
	public static void getInternetExplorerProperties() {
		System.setProperty("webdriver.ie.driver",
				"C:\\Selenium\\MicrosoftWebDriver.exe");
		
	}
	public static WebDriver getDriver(){
		WebDriver driver;
		String browserName = "firefox";
		if(browserName.equalsIgnoreCase("chrome")){
			getChromeProperties();
			driver = new ChromeDriver();
			return driver;	
		}
		else if(browserName.equalsIgnoreCase("internetexplorer")){
			getInternetExplorerProperties();
			driver = new InternetExplorerDriver();
			return driver;	
		}else{
			getFireFoxProperties();
			driver = new FirefoxDriver();
			return driver;
		}
		
	}
	
	public static WebDriver getDriver(String browserName){
		WebDriver driver;
		//String browserName = "firefox";
		if(browserName.equalsIgnoreCase("chrome")){
			getChromeProperties();
			driver = new ChromeDriver();
			return driver;	
		}
		else if(browserName.equalsIgnoreCase("internetexplorer")){
			getInternetExplorerProperties();
			driver = new InternetExplorerDriver();
			return driver;	
		}else{
			getFireFoxProperties();
			driver = new FirefoxDriver();
			return driver;
		}
		
	}

}
