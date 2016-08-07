package Roughwork;

import com.vktech.util.XLS_Reader;

public class GetTestData {

 public static void main (String[] args)  {
		
	 	XLS_Reader xls = new XLS_Reader(System.getProperty("user.dir")+"/src/com/vktech/xlsfiles/newcars.xlsx");
	 	getTestData(xls, "Registration");
	 	}
 
 //Getting the TestData from Excel Sheet
 		public static String[][]  getTestData(XLS_Reader xls, String sheetName) {
 			if (!xls.isSheetExist(sheetName)) {
 			System.out.println("Test data sheet not found");
 			}
 			int rows = xls.getRowCount(sheetName);
 			int cols = xls.getColumnCount(sheetName);
 
 		//Size declaration
 			String[][] data = new String[rows-1][cols-1];
 
 		//Values declaration
 			for (int rowNum=2; rowNum<=rows; rowNum++){
			for (int colNum=0; colNum<=cols-2; colNum++){   
		//in above col loop as we are not taking the "runmode" column, so "colNum<=cols-2" because cols count start from 0 1 2 3 4...etc  
				
				System.out.print(xls.getCellData(sheetName, colNum, rowNum)+"  ==  ");
				data[rowNum-2][colNum]=xls.getCellData(sheetName, colNum, rowNum);
			}
			System.out.println();
			}
			return data;
 			}
}
