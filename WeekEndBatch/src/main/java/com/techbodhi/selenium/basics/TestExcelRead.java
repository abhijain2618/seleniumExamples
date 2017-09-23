package com.techbodhi.selenium.basics;

import com.techbodhi.constants.Constant;
import com.techbodhi.selenium.core.ExcelUtils;

public class TestExcelRead {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			ExcelUtils.setExcelFile(Constant.PATH_TEST_DATA_FOLDER+Constant.FILE_NAME, "Sheet1");
			System.out.println(ExcelUtils.getCellData(0, 1));
			ExcelUtils.setCellData("Test Information ", 1, 3);
			ExcelUtils.saveExcelFile(Constant.PATH_TEST_DATA_FOLDER+Constant.FILE_NAME);
			
			int rowCount = ExcelUtils.ExcelWSheet.getLastRowNum();
			System.out.println(rowCount);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
