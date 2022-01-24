package com.datadriven.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDataSeleniumTest {
	
	public static void main(String[] args) {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		System.out.println(driver.findElement(By.xpath("//*[@id='customers']/tbody/tr[2]/td[1]")).getText());
		String beforeXpathCompany = "//*[@id='customers']/tbody/tr[";
		String afterXpathCompany = "]/td[1]";
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		String beforeXpathContact = "//*[@id='customers']/tbody/tr[";
		String afterXpathContact = "]/td[2]";
		int rowCount = rows.size();System.out.println(rowCount);
		
		Xls_Reader  reader = new Xls_Reader("C:\\Users\\smita\\eclipse-workspace\\selenium4Project\\src\\com\\testdata\\HalfEbayTestData.xlsx");
		if(!reader.isSheetExist("WebData")){
			reader.addSheet("WebData");
			reader.addColumn("WebData","Company");	
			reader.addColumn("WebData","Contact");	
		}
		for (int i=2; i<rowCount-1;i++) {
			String actualXPathCompany=beforeXpathCompany+i+afterXpathCompany;
			String company = driver.findElement(By.xpath(actualXPathCompany)).getText();
			System.out.println(company);
			reader.setCellData("WebData","Company", i, company);
			
			String actualXPathContact=beforeXpathContact+i+afterXpathContact;
			String contact=driver.findElement(By.xpath(actualXPathContact)).getText();
			System.out.println(contact);
			reader.setCellData("WebData","Contact", i, contact);
		}
		driver.close();
	} 

}
