package com.tyss.ProjectFrameworkHMS.lib;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib {

	public static String getdata(String sheet,int row,int cell,String filepath)
	 {
		 String val="";
		 double val1=0;
		 try {
			FileInputStream fin=new FileInputStream(filepath);
			Workbook wb=WorkbookFactory.create(fin);
			Cell c=wb.getSheet(sheet).getRow(row).getCell(cell);
			val=c.getStringCellValue();
			val1=c.getNumericCellValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		return val;
		 
	 }
	public static double getdata1(String sheet,int row,int cell,String filepath)
	 {
		
		 double val1=0;
		 try {
			FileInputStream fin=new FileInputStream(filepath);
			Workbook wb=WorkbookFactory.create(fin);
			Cell c=wb.getSheet(sheet).getRow(row).getCell(cell);
			val1=c.getNumericCellValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		return val1;
	 }
}
