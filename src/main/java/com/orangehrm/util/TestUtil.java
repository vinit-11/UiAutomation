package com.orangehrm.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


import com.orangehrm.base.TestBase;


public class TestUtil extends TestBase {

	public long PAGE_LOAD_TIMEOUT=20;
	public long IMPLICITLY_WAIT=10;

	public static String TEST_DATA_SHEETPATH="E:\\eclipse\\UIAutomation\\src\\main\\java\\com\\orangehrm\\testdata\\OrangeHRM.xlsx";
	public static Workbook book;
	public static Sheet sheet;


	public void switchtoframe() 
	{
		driver.switchTo().frame(0);
	}


	public static Object[][] getTestData(String sheetName) {

		FileInputStream file=null;
		try 
		{
			file=new FileInputStream(TEST_DATA_SHEETPATH);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try 
		{
			book =WorkbookFactory.create(file);

		}catch(IOException e) 
		{
			e.printStackTrace();
		}

		sheet=book.getSheet(sheetName);

		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];         //return type of data is object [][] is 

		//System.out.println(sheet.getLastRowNum()+"----------"+
		//sheet.getRow(0).getLastCellNum();

		for(int i=0;i<sheet.getLastRowNum();i++) {

			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {

				data[i][k]=sheet.getRow(i+1).getCell(k).getStringCellValue().toString();
				//System.out.println(data[i][k]);
			}
		}
		return data;

	}


}
