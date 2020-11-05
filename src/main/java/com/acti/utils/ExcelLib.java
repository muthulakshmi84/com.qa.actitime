package com.acti.utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLib {
	XSSFWorkbook wb;
	public ExcelLib(){
		try{
		File file=new File("./src/test/resources/testdata/actidata.xlsx");
		FileInputStream fis=new FileInputStream(file);
		wb=new XSSFWorkbook(fis);
		}
		catch(Exception e){
			System.out.println("File not found: "+e.getMessage());
		}
	}
	public int getRowCount(int sheetNumber){
		return wb.getSheetAt(sheetNumber).getLastRowNum()+1;
	}
	public String getData(int sheetNum, int row, int col){
		return wb.getSheetAt(0).getRow(row).getCell(col).toString();
	}

}
