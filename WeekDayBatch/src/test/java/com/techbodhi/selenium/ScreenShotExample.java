package com.techbodhi.selenium;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.techbodhi.core.ScreenShotUtil;
import com.techbodhi.core.SystemProp;
public class ScreenShotExample {

	@Test
	public void testTakeScreenShot() throws Exception {
		WebDriver driver = SystemProp.getDriver("firefox");
		driver.get("http://demo.guru99.com/V4/");
		
		ScreenShotUtil.takeSnapShot(driver);
	}


}