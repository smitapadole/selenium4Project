package com.test.utility;

import java.util.ArrayList;
import com.excel.utility.Xls_Reader;

public class TestUtil {

	Xls_Reader reader;
	
	public static ArrayList<Object[]> getDataFromExcel() {
		ArrayList<Object[]> data = new ArrayList<Object[]>();
		Xls_Reader reader = new Xls_Reader("C:\\Users\\smita\\eclipse-workspace\\selenium4Project\\src\\com\\testdata\\HalfEbayTestData.xlsx");
		int rowCount = reader.getRowCount("RegTestData");
		for(int rowNum=2;rowNum<=rowCount;rowNum++ ) {
			
			String name = reader.getCellData("RegTestData", "name",rowNum);
			String email = reader.getCellData("RegTestData", "emailaddress", rowNum);
			System.out.println(name+" "+email);
			Object ob[] = {name,email};
			data.add(ob);
		}
		return data;
	}
}
