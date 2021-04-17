package utils;

public class Execute {

	
	public static void main(String[] args) {
		
		Excel ex = new Excel("C:\\Users\\vshadmin\\Desktop\\data.xlsx");
		System.out.println(ex.getData("Sheet1", 0, 0));
		
	    ex.WriteData("sheet1", 9, 3, "huehuehuehue");
	   
	    ex.WriteFile("C:\\Users\\vshadmin\\Desktop\\data1.xls");
	    
	    
	}
}
