package com.datadriven.test;

import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://signup.ebay.com/pa/crte?acntType=business");
		Xls_Reader reader = new Xls_Reader("C:\\Users\\smita\\eclipse-workspace\\selenium4Project\\src\\com\\testdata\\HalfEbayTestData.xlsx");
		String name = reader.getCellData("RegTestData", "name", 2);
		String email = reader.getCellData("RegTestData", "emailaddress", 2);
		
		driver.findElement(By.id("businessName")).sendKeys(name);
		driver.findElement(By.id("businessEmail")).sendKeys(email);
		
	}
}
