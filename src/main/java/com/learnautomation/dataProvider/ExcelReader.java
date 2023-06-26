package com.learnautomation.dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	static XSSFWorkbook wb=null;
	
	public static Object[][] getDataFromSheet(String SheetName)
	{
		
		System.out.println("**********Test Data Generating***************");
		

		try {
			wb = new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir") + "/TestData/excel/TestFile.xlsx")));
		} catch (FileNotFoundException e) {
			System.out.println("File not Found" + e.getMessage());
		} catch (IOException e) {
		  System.out.println("IO Exception" + e.getMessage());
		}
		
		int rows = wb.getSheet(SheetName).getPhysicalNumberOfRows();
		
		int columns = wb.getSheet(SheetName).getRow(0).getPhysicalNumberOfCells();
		
		Object arr[][] = new Object[rows-1][columns];
		
		for(int i=1;i<rows;i++)
		{
			for(int j=0;j<columns;j++)
			{
				//arr[i][j] = wb.getSheet(SheetName).getRow(i).getCell(j).getStringCellValue();
				
				arr[i-1][j] = getData(SheetName,i,j);
			
			}
		}
		
		System.out.println("**********Test Data Generated***************");
		
		return arr;
	}
	
	public static String getData(String SheetName, int rows, int columns)
	{
		XSSFCell cell = wb.getSheet(SheetName).getRow(rows).getCell(columns);
		String data ="";
		if(cell.getCellType() == CellType.STRING)
		{
			data = cell.getStringCellValue();
		}
		else if(cell.getCellType()==CellType.NUMERIC)
		{
			double data1 = cell.getNumericCellValue();
			data = String.valueOf(data1);
		}
		else if(cell.getCellType()== CellType.BOOLEAN)
		{
			boolean datainboolean = cell.getBooleanCellValue();
			data = String.valueOf(datainboolean);
		}
		else if(cell.getCellType()== CellType.BLANK)
		{
			data = "";
		}
		return data;
	}
	
	

}
