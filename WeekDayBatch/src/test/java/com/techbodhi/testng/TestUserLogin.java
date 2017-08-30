package com.techbodhi.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.techbodhi.constants.Constant;
import com.techbodhi.core.ExcelUtils;
import com.techbodhi.core.PropertySystem;
import com.techbodhi.core.SystemProp;
import com.techbodhi.seleniumbasic.pageobjects.DemoQALoginPageObject;

public class TestUserLogin {

	WebDriver driver;
	
	
	@BeforeClass
	public void setUp(){
		
		driver = SystemProp.getDriver();
	}
	

	@Test(enabled=false)
	public void checkUserLogin() throws Exception{
		
		
		driver.get("http://store.demoqa.com/products-page/your-account/");
		DemoQALoginPageObject pageObjects = new DemoQALoginPageObject();
		
		
		ExcelUtils.setExcelFile(Constant.PATH_TEST_DATA_FOLDER + Constant.FILE_NAME, "Sheet1");
		
		int rowPosition = 1;
		while (ExcelUtils.getCellData(rowPosition, 0) != "") {
			//WebElement username = pageObjects.getUsernameField(driver);
			
			String value = ExcelUtils.getCellData(rowPosition, 1);
			if ( value !=""){
				pageObjects.getUsernameField(driver).sendKeys(value);
			}			
			pageObjects.getPasswordField(driver).sendKeys(ExcelUtils.getCellData(rowPosition, 2));
			pageObjects.getLoginbutton(driver).click();
			Thread.sleep(10000);
			System.out.println("Error Message: "+ driver.findElement(By.xpath("//form[@name='loginform']/p[1]")).getText());
			
			driver.get("http://store.demoqa.com/products-page/your-account/");
			System.out.println("rowPosition: " + rowPosition);
			rowPosition++;
		}
		
		
		

		
	}
}
