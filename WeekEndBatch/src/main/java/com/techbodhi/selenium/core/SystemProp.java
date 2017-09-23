package com.techbodhi.selenium.core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

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
		String browserName = "remotefirefox";
		if(browserName.equalsIgnoreCase("chrome")){
			getChromeProperties();
			driver = new ChromeDriver();
			return driver;	
		}
		else if(browserName.equalsIgnoreCase("internetexplorer")){
			getInternetExplorerProperties();
			driver = new InternetExplorerDriver();
			return driver;	
		}
		else if(browserName.equalsIgnoreCase("remotefirefox")){
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.firefox();
			capabilities.setBrowserName("firefox");
			try {
				return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		
		
		else{
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
