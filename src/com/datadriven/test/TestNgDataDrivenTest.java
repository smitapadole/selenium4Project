package com.datadriven.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.excel.utility.Xls_Reader;
import com.test.utility.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNgDataDrivenTest {

	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://signup.ebay.com/pa/crte?acntType=business");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData() {
		/*Xls_Reader reader = new Xls_Reader("C:\\Users\\smita\\eclipse-workspace\\selenium4Project\\src\\com\\testdata\\HalfEbayTestData.xlsx");
		int rowCount = reader.getRowCount("RegTestData");
		for(int rowNum=2;rowNum<=rowCount;rowNum++ ) {
			
			String name = reader.getCellData("RegTestData", "name",rowNum);
			String email = reader.getCellData("RegTestData", "emailaddress", rowNum);
			System.out.println(name+" "+email);
			driver.findElement(By.id("businessName")).clear();
			driver.findElement(By.id("businessName")).sendKeys(name);
			driver.findElement(By.id("businessEmail")).clear();
			driver.findElement(By.id("businessEmail")).sendKeys(email);
			//reader.setCellData("RegTestData", "status", rowNum, "pass");
		}*/
		ArrayList<Object[]> data= TestUtil.getDataFromExcel();
	    return(data.iterator());
	}
	//@Test(priority=1, enabled=true/false, dependsOnMethods={"method1"})
	@Test(dataProvider="getTestData")
	public void testNgTest(String name,String email) {
		
		driver.findElement(By.id("businessName")).clear();
		driver.findElement(By.id("businessName")).sendKeys(name);
		driver.findElement(By.id("businessEmail")).clear();
		driver.findElement(By.id("businessEmail")).sendKeys(email);	
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
	
}
