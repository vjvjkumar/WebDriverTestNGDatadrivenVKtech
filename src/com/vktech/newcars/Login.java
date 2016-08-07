package com.vktech.newcars;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vktech.util.TestUtil;

public class Login extends TestSuiteBase {

//Firstly, to check the TestData Runmode, we are declaring an integer count variable
	static int count = -1;
	
@BeforeTest
	public void checkTestCaseSkip () { 	
		if (!TestUtil.isTestCaseRunnable(newcarsxls, "Login")) {
		throw new SkipException("Runmode of Login testcase is set as NO, so skipping Login testcase");
		}
		runmodes = TestUtil.getTestDataRunmodes(newcarsxls, "Login");	
		}


//Test Case
@Test (dataProvider = "getData")
	public void login(String Uname, String Pass) {
		count++;
	//now check the TestData Runmodes		
		if (!runmodes[count].equalsIgnoreCase("Y")) {
		throw new SkipException("Runmode of the testdata is set as NO, so skipping row number: "+(count+1));	
		}
	//Executing TestCase
		System.out.println("Executing the TestCase with Parameters: "+Uname+"  "+Pass);
	//webdriver code
		OpenBrowser();
		
		driver.get(CONFIG.getProperty("baseurl"));
		getObject("logLocation").sendKeys("Hyderabad Central, Hyderabad, Telangana");
		getObject("logLink").click();
		getObject("logEmail").sendKeys(Uname);
		getObject("logPass").sendKeys(Pass);
		getObject("logbuttonLOGIN").click();
		
		CloseBrowser();
	}

//Get the Data from Excel file
@DataProvider
	public String[][] getData() {
		return TestUtil.getTestData(newcarsxls, "Login");
		}
}