package com.techbodhi.selenium.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.techbodhi.constants.Constant;
import com.techbodhi.selenium.core.ExcelUtils;

public class ExcelTestDataProvider {

	@DataProvider(name = "Authentication_Excel")
	public static Object[][] credentials_Excel() throws Exception {
		ExcelUtils.setExcelFile(Constant.PATH_TEST_DATA_FOLDER
				+ Constant.FILE_NAME, "Sheet1");
		
		int rowCount = ExcelUtils.ExcelWSheet.getLastRowNum();
		Object [][] test = new Object [rowCount][2];
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
}
