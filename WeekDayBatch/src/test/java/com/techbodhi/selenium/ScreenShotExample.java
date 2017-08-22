package com.techbodhi.selenium;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.techbodhi.core.SystemProp;
public class ScreenShotExample {

	@Test
	public void testGuru99TakeScreenShot() throws Exception {
		WebDriver driver = SystemProp.getDriver("firefox");
		driver.get("http://demo.guru99.com/V4/");
		takeSnapShot(driver, "c://demo//test_TimeStamp.png");
	}

	public static void takeSnapShot(WebDriver webdriver, String fileWithPath)
			throws Exception {
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		File DestFile = new File(fileWithPath);
		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
	}

}