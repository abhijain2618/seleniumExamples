package com.techbodhi.selenium.core;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtils {
	
	public static XSSFWorkbook ExcelWBook;
	public static XSSFSheet ExcelWSheet;
	public static XSSFCell Cell;
	public static XSSFRow Row;
	
public static void setExcelFile(String path , String sheetName) throws Exception{
	
		FileInputStream fileObject = new FileInputStream(path);
		ExcelWBook = new XSSFWorkbook(fileObject);
		ExcelWSheet = ExcelWBook.getSheet(sheetName);
	
}

public static String getCellData(int RowNum, int ColNum){
	try {
		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
		String CellData = Cell.getStringCellValue();
		return CellData;
	} catch (Exception e) {
		e.printStackTrace();
		return "";
	}
	
}
	
public static void setCellData(String result , int RowNum, int ColNum){
	Row = ExcelWSheet.getRow(RowNum);
	Cell = Row.getCell(ColNum, Row.CREATE_NULL_AS_BLANK);
	Cell.setCellValue(result);
}

public static void saveExcelFile (String path) throws Exception{
	FileOutputStream fileOut = new FileOutputStream(path);
	ExcelWBook.write(fileOut);	
	fileOut.flush();
	fileOut.close();
}


}