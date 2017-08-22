package com.techbodhi.selenium.core;

public class SystemProp {

	public static void getFireFoxProperties(){
		System.setProperty("webdriver.gecko.driver",
				"C:\\Selenium\\geckodriver.exe");
	}
}
