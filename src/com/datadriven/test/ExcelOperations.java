package com.datadriven.test;

import com.excel.utility.Xls_Reader;

public class ExcelOperations {
	public static void main(String[] args) {
		Xls_Reader reader = new Xls_Reader("C:\\Users\\smita\\eclipse-workspace\\selenium4Project\\src\\com\\testdata\\HalfEbayTestData.xlsx");
		System.out.println(reader.isSheetExist("NewSheet"));
		if(!reader.isSheetExist("NewSheet")) {
		reader.addSheet("NewSheet");
		}
		int columnCount = reader.getColumnCount("RegTestData");
		System.out.println("Total Columns "+columnCount);
		System.out.println(reader.getCellRowNum("RegTestData","name","Harry"));
	}
}
