package com.techbodhi.selenium.testng;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.techbodhi.constants.Constant;
import com.techbodhi.selenium.core.ExcelUtils;
import com.techbodhi.selenium.core.SystemProp;
import com.techbodhi.selenium.pageObjects.MyAccountPageObjects;

public class DataDrivenExample {
	WebDriver driver;
	MyAccountPageObjects pageObjects;

	@BeforeClass(alwaysRun = true)
	@Parameters("browserName")
	public void setUp(String browserName) {
		driver = SystemProp.getDriver(browserName);
		pageObjects = new MyAccountPageObjects();
	}

	@Test
	public void check_user_login_test() throws Exception {
		ExcelUtils.setExcelFile(Constant.PATH_TEST_DATA_FOLDER
				+ Constant.FILE_NAME, "Sheet1");
		int rowCounter = 1;
		String testCaseName = ExcelUtils.getCellData(rowCounter, 0);
		while (testCaseName != "") {
			// perform login
			driver.get("http://store.demoqa.com/products-page/your-account/");
			pageObjects.getUserName(driver).sendKeys(
					ExcelUtils.getCellData(rowCounter, 1));
			pageObjects.getPassword(driver).sendKeys(
					ExcelUtils.getCellData(rowCounter, 2));
			pageObjects.getLoginButton(driver).click();

			Thread.sleep(5000);
			String errorMessage = pageObjects.getErrorMessage(driver).getText();
			ExcelUtils.setCellData(errorMessage, rowCounter, 3);

			// handle while condition
			rowCounter++;
			testCaseName = ExcelUtils.getCellData(rowCounter, 0);
		}

		ExcelUtils.saveExcelFile(Constant.PATH_TEST_DATA_FOLDER
				+ Constant.FILE_NAME);
	}

	@AfterClass(alwaysRun = true)
	public void closeAll() {
		driver.quit();
	}

}
