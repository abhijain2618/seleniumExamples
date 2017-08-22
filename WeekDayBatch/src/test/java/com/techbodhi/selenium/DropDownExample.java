package com.techbodhi.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.techbodhi.core.SystemProp;


public class DropDownExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = SystemProp.getDriver("firefox");
	    String baseUrl = "http://newtours.demoaut.com/mercuryregister.php";
		driver.get(baseUrl);

		Select drpCountry = new Select(driver.findElement(By.name("country")));
		drpCountry.selectByIndex(2);
		
		//Selecting Items in a Multiple SELECT elements
		driver.get("http://jsbin.com/osebed/2");
		Select fruits = new Select(driver.findElement(By.id("fruits")));
		fruits.selectByVisibleText("Banana");
		fruits.selectByIndex(1);
		
		List<WebElement> test = fruits.getAllSelectedOptions();
		
		for (WebElement webElement : test) {
			if (webElement.getAttribute("id").equals("Banana")){
				System.out.println("test case passed");
			}else{
				System.out.println("test case failed");
			}
		}
		
		String abc = "Test";
		System.out.println("Lower case " + abc.toLowerCase());
		
		System.out.println("upper Case case " + abc.toUpperCase());
		
		if(abc.equalsIgnoreCase("test")){
			System.out.println("True");
		}else{
			System.out.println("False");
		}	
		
		
		String firstName = "Abhishek" ;
		String middleName = "Kumar"; 
		String lastName = "jain";
		
		String fullName = firstName + middleName + lastName;
		
		
						
				
		
	
	int i = 1;
	
	for (i=1;i<5;i++){
		
		String start = "html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[";
		String end = "]";
		
		String finalXpath = "html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[" + i +  "]";
		
		
		
		
		                                                                          
		driver.findElement(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[" + i +  "]")).click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}}

