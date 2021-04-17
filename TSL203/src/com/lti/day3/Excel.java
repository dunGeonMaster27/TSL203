package com.lti.day3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	Workbook wb;
	Excel(String FileName){
		try {
			FileInputStream IP=new FileInputStream(FileName);
			if(FileName.endsWith(".xls")) {
				    wb=new HSSFWorkbook(IP);
			}
			else if(FileName.endsWith(".xlsx")) {
				   wb=new XSSFWorkbook(IP);
			}
			}
 		catch(Exception e) {
			System.out.println(e.getMessage());
		}
}
	public String getData(String sheetName,int R,int C) {
		return wb.getSheet(sheetName).getRow(R).getCell(C).toString();
	}
	public int getRowNum(String sheetName) {
		return wb.getSheet(sheetName).getLastRowNum();
	}
	public void setData(String username,String password){
		Sheet sheet=wb.getSheet("sheet1");
		sheet.createRow(4).createCell(0).setCellValue(username);
		sheet.getRow(4).createCell(1).setCellValue(password);
			
			try {
				wb.write(new FileOutputStream("C:\\Users\\vshadmin\\Desktop\\data.xlsx"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	public void writeData(String sheetName,String data,int R,int C) {
		wb.getSheet(sheetName).getRow(R).getCell(C).setCellValue(data);
		/*wb.getSheet(sheetName).getRow(R).createCell(C).setCellValue(data);
		wb.getSheet(sheetName).createRow(R).createCell(C).setCellValue(data);*/
	}
	
	public void writeFile(String FileName) {
		try {
			wb.write(new FileOutputStream(FileName));
		} catch (Exception e) {
			System.out.println("error");
		}
	}
}
