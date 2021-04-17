package com.lti.day3;

public class Execute {
public static void main(String[] args) {
	Excel ex=new Excel("C:\\Users\\vshadmin\\Desktop\\data.xlsx");
	System.out.println(ex.getData("Sheet1", 0, 0));
	ex.setData("LTI","LTI!");
	ex.writeData("Sheet1", "NAMO",2,1);
	ex.writeFile("C:\\Users\\vshadmin\\Desktop\\1data.xls");
}
}
