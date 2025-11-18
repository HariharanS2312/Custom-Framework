package com.Utilities;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GlobalVaribles {

	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor jsExecutor;
	public XSSFWorkbook xssfWorkBook;
	public HSSFWorkbook hssfWorkBook;
	public Sheet sheet;
	public FileInputStream fis;

	public String dataFileName = "TestData.xlsx";

}
