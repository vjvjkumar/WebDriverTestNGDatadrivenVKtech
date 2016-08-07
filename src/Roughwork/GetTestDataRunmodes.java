package Roughwork;

import com.vktech.util.XLS_Reader;

public class GetTestDataRunmodes {
	
	public static void main(String[] args){
	 
		XLS_Reader xls = new XLS_Reader(System.getProperty("user.dir")+"/src/com/vktech/xlsfiles/newcars.xlsx");
		getTestDataRunmodes(xls, "Login");
		}

// Getting the Runmodes of Test Data from Excel sheet
		public static String[] getTestDataRunmodes(XLS_Reader xls, String sheetName) {
			if (!xls.isSheetExist(sheetName)){
			System.out.println("Test data sheet not found");
			}
	
		// Size declaration
			String[] runmodes = new String[xls.getRowCount(sheetName)-1];
	
		// Values declaration
			for (int i=2; i<=xls.getRowCount(sheetName); i++){
			System.out.println(xls.getCellData(sheetName, "Runmode", i));
		
			runmodes[i-2]=xls.getCellData(sheetName, "Runmode", i);
			}
			return runmodes;
			}		                                 
}
	                              


