package com.Utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

public class ExcelOperations extends DirectoryNavigations {

	ExcelOperations() {
		if (super.xssfWorkBook != null) {
			getWorkbookPath(super.dataFileName);
		}
	}

	public void getWorkbookPath(String fileName) {
		try {
			super.fis = new FileInputStream(new File(getUserDirectory() + "\\" + fileName));
			super.xssfWorkBook = new XSSFWorkbook(fis);
		} catch (Exception e) {
			Assert.fail("Unable to load the test data file!");
		}
	}

	public Sheet getWorkBookSheet(String sheetName) {
		return super.sheet = super.xssfWorkBook.getSheet(sheetName);
	}

	public String getCellStringValue(Cell cell) {
		return new DataFormatter().formatCellValue(cell).toString();
	}

	public int getWorkBookColumn(String columnKey) {
		int colindex = 0;
		Row row = super.sheet.getRow(0);
		for (Cell cell : row) {
			if (getCellStringValue(cell).equals(columnKey)) {
				colindex = cell.getColumnIndex();
				break;
			} else {
				if (colindex == row.getLastCellNum()) {
					Assert.fail("No match found for the colum with key: " + columnKey);
				}
			}
		}
		return colindex;
	}

	public String getWorkBookCell(int rowNumber, int cellNumber) {
		return getCellStringValue(super.sheet.getRow(rowNumber).getCell(cellNumber));
	}
}
