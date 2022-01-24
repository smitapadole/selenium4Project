package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetXMLValueParamerTest {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://signup.ebay.com/pa/crte?acntType=business");
		
		//Read xlsx
		Xls_Reader reader = new Xls_Reader("C:\\Users\\smita\\eclipse-workspace\\selenium4Project\\src\\com\\testdata\\HalfEbayTestData.xlsx");
		int rowCount = reader.getRowCount("RegTestData");
		reader.addColumn("RegTestData", "status");
		
		for(int rowNum=2;rowNum<=rowCount;rowNum++ ) {
			
			String name = reader.getCellData("RegTestData", "name",rowNum);
			String email = reader.getCellData("RegTestData", "emailaddress", rowNum);
			System.out.println(name+" "+email);
			driver.findElement(By.id("businessName")).clear();
			driver.findElement(By.id("businessName")).sendKeys(name);
			driver.findElement(By.id("businessEmail")).clear();
			driver.findElement(By.id("businessEmail")).sendKeys(email);
			reader.setCellData("RegTestData", "status", rowNum, "pass");
		}
		driver.close();
	}

}
