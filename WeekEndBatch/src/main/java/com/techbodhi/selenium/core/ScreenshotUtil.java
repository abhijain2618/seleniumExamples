package com.techbodhi.selenium.core;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

	public static void takeScreenShot(WebDriver driver) throws IOException{

		
		//String fileName = String.valueOf(System.currentTimeMillis());
		
		DateFormat dateFormat = new SimpleDateFormat("yy_MM_dd_HH_mm_ss_SS");
		Date date = new Date();
      
        
		String fileWithPath = "c://demo//test_"+ dateFormat.format(date) + ".png";
		
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		File DestFile = new File(fileWithPath);
		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
	}
	
//	public static void main (String [] args){
//		System.out.println(new SimpleDateFormat("yy_MM_dd_HH_mm_ss_SS").format(new Date()));
//		
//	}
	
	
	

}
