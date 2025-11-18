package com.Utilities;

import static org.testng.Assert.fail;

import org.apache.poi.ss.usermodel.Row;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.google.common.collect.Iterables;

public class DataProviders extends ExcelOperations {

	@DataProvider(name = "url")
	@Parameters("AppName")
	public Object getAppLink(String appName) {
		Object obj = null;
		getWorkBookSheet("Application links");
		int col1 = getWorkBookColumn("Application Name"), col2 = getWorkBookColumn("URL");
		for (Row row : Iterables.skip(super.sheet, 1)) {
			if (getCellStringValue(row.getCell(col1)).equals(appName)) {
				obj = getCellStringValue(row.getCell(col2));
				break;
			} else {
				if (row.getRowNum() == super.sheet.getLastRowNum()) {
					fail("Invalid app name: " + appName);
				}
			}
		}
		return obj;
	}
}
