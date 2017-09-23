package com.techbodhi.selenium.testng;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
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
		driver = SystemProp.getDriver("firefox");
		pageObjects = new MyAccountPageObjects();
	}

	@Test(enabled=false)
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
	
	@DataProvider(name = "Authentication")
	public static Object[][] credentials() {
		Object [][] test = new Object [2][2];
		test[0][0] = "testuser_1";
		test[0][1] = "Test@123";
		test[1][0] = "testuser_12";
		test[1][1] = "Test@1234";
		 return test;
	}
	
	@DataProvider(name = "Authentication_Excel")
	public static Object[][] credentials_Excel() throws Exception {
		ExcelUtils.setExcelFile(Constant.PATH_TEST_DATA_FOLDER
				+ Constant.FILE_NAME, "Sheet1");
		
		int rowCount = ExcelUtils.ExcelWSheet.getLastRowNum();
		Object [][] test = new Object [rowCount-1][2];
		for (int i = 0; i < rowCount; i++) {
			test[i][0] = ExcelUtils.getCellData(i+1, 1);
			test[i][1] = ExcelUtils.getCellData(i+1, 2);
		}
		
		 return test;
	}
	
	@Test (dataProvider = "Authentication_Excel")
	public void dataProvider_Example_Excel(String userName , String password) throws InterruptedException{
		System.out.println("user name : " + userName);
		System.out.println("password: " + password);
	}
	
	@Test (dataProvider = "Authentication", enabled=false)
	public void dataProvider_Example(String userName , String password) throws InterruptedException{
		System.out.println("user name : " + userName);
		System.out.println("password: " + password);
		
		driver.get("http://store.demoqa.com/products-page/your-account/");
		pageObjects.getUserName(driver).sendKeys(userName);
		pageObjects.getPassword(driver).sendKeys(password);
		pageObjects.getLoginButton(driver).click();

		Thread.sleep(5000);
		String errorMessage = pageObjects.getErrorMessage(driver).getText();
		System.out.println(errorMessage);
		
	}

	@AfterClass(alwaysRun = true)
	public void closeAll() {
		driver.quit();
	}

}
