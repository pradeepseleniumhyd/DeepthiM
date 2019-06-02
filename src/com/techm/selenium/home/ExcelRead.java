package com.techm.selenium.home;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class ExcelRead 
{
	
	@Test
	public void Excel () throws Exception
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\Techm_Testdata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("TestData");
		

	/*	System.out.println(sheet.getRow(0).getCell(0).getStringCellValue());
		System.out.println(sheet.getRow(0).getCell(1).getStringCellValue());
		System.out.println(sheet.getRow(0).getCell(2).getStringCellValue());
		System.out.println(sheet.getRow(1).getCell(0).getStringCellValue());
		System.out.println(sheet.getRow(1).getCell(1).getStringCellValue());
		System.out.println(sheet.getRow(1).getCell(2).getStringCellValue());
		System.out.println(sheet.getRow(2).getCell(0).getStringCellValue());
		System.out.println(sheet.getRow(2).getCell(1).getStringCellValue());
		System.out.println(sheet.getRow(2).getCell(2).getStringCellValue());
		*/ 
		if(sheet.getRow(1).getCell(0).getStringCellValue().equalsIgnoreCase("TC001"))
		{
			System.out.println("TC001 is executed");
		}else
		{
			throw new SkipException("TC001 is not in First row  " + sheet.getRow(1).getCell(0).getStringCellValue());
		}
		
	}

}
