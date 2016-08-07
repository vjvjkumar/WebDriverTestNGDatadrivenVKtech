package com.vktech.usedcars;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vktech.util.TestUtil;

public class SearchUsedCars extends TestSuiteBase {
	
	static int count =-1;
@BeforeTest
	public void checkTestCaseSkip() {
		if (!TestUtil.isTestCaseRunnable(usedcarsxls, "SearchUsedCars")){
		throw new SkipException("Runmode of testcase SearchUsedCars is set as NO, so skipping SearchUsedCars testcase");
		}
		runmodes = TestUtil.getTestDataRunmodes(usedcarsxls, "SearchUsedCars");
		}
	
@Test (dataProvider = "getData")
	public void searchUsedCars(String Uname, String Pass){
		count ++;
		if(!runmodes[count].equalsIgnoreCase("Y")){
		throw new SkipException("Runmode of the testdata is set as NO, so skipping the Rownumber :" +(count+1));
		}
	//Executing the TestCase
		System.out.println("Executing the testcase SearchUsedCars with parameters :"+Uname+"  "+Pass);
	//Webdriver code
		OpenBrowser();
		
		driver.get(CONFIG.getProperty("baseurl"));
		getObject("logLocation").sendKeys("Hyderabad Central, Hyderabad, Telangana");
		getObject("logLink").click();
		getObject("logEmail").sendKeys("Uname");
		getObject("logPass").sendKeys("Pass");
		getObject("logbuttonLOGIN").click();
		
		CloseBrowser();
	}
	
@DataProvider
	public String [][] getData(){
		return TestUtil.getTestData(usedcarsxls, "SearchUsedCars");
	}
}
