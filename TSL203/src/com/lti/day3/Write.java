package com.lti.day3;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Write {

	public static void main(String[] args) throws Exception  {
		FileInputStream IP= new FileInputStream("C:\\Users\\vshadmin\\Desktop\\data.xlsx");
		XSSFWorkbook wb= new XSSFWorkbook(IP);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		//sheet.getRow(3).getCell(1).setCellValue("LTI");
		//sheet.getRow(3).createCell(2).setCellValue("LTI");
		sheet.createRow(3).createCell(2).setCellValue("LTIlll");
		FileOutputStream OP = new FileOutputStream("C:\\Users\\vshadmin\\Desktop\\data2.xlsx");
		
		wb.write(OP);
		
	//	wb.write(new FileOutputStream("C:\\Users\\vshadmin\\Desktop\\data2.xlsx"));
		wb.close();
	}
	
}
