package com.vktech.sellcars;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vktech.util.TestUtil;

public class LocateDealer extends TestSuiteBase {
	
	static int count = -1;
	
@BeforeTest
	public void checkTestCaseSkip() {
		if(!TestUtil.isTestCaseRunnable(sellcarsxls, "LocateDealer")) {
		throw new SkipException("Runmode of LocateDealer testcase is set as NO, then skipping LocateDealer testcase");
		}
		runmodes = TestUtil.getTestDataRunmodes(sellcarsxls, "LocateDealer");
		}
	
@Test(dataProvider = "getData")
	public void locatedealer(String Uname, String Pass) {
		count ++;
		if (!runmodes[count].equalsIgnoreCase("Y")){
		throw new SkipException("Runmode of testdata is set as NO, then skipping Rownumber :" +(count+1));
		}
	//Executing testcase	
		System.out.println("Executing testcase of LocateDealer with parameters: "+Uname+"  "+Pass);
	//Webdriver code
		OpenBrowser();
		driver.get(CONFIG.getProperty("baseurl"));
		getObject("logLocation").sendKeys("Hyderabad Central, Hyderabad, Telangana");
		getObject("logLink").click();
		getObject("logEmail").sendKeys(Uname);
		getObject("logPass").sendKeys(Pass);
		getObject("logbuttonLOGIN").click();
	}
	
@DataProvider
	public String[][] getData() {
		return TestUtil.getTestData(sellcarsxls, "LocateDealer");
	}

}
