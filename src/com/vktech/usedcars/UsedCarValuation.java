package com.vktech.usedcars;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vktech.util.TestUtil;

public class UsedCarValuation extends TestSuiteBase{
	static int count =-1;

@BeforeTest
	public void checkTestCaseSkip () {
		if (!TestUtil.isTestCaseRunnable(usedcarsxls, "UsedCarValuation")){
		throw new SkipException("Runmode of UsedCarValuation testcase is set as NO, so skipping UsedCarValuation testcase");
		}
		runmodes = TestUtil.getTestDataRunmodes(usedcarsxls, "UsedCarValuation");
		}
	
@Test (dataProvider = "getData")
	public void usedCarValuation(String Name, String EmailAddress, String Mobile, String Password, String ConfirmPass) {
		count ++;
		if (!runmodes[count].equalsIgnoreCase("Y")){
		throw new SkipException("Runmode of testdata is set as NO, so skipping Rownumber "+ (count+1));
		}
	//Executing TestCase
		System.out.println("Executing the testcase of UsedCarvaluation with parameters: "+Name+"  "+EmailAddress+"  "+Mobile+"  "+Password+"  "+ConfirmPass); 
	//Webdriver code
		OpenBrowser();
		
		driver.get(CONFIG.getProperty("baseurl"));
		getObject("logLocation").sendKeys("Hyderabad Central, Hyderabad, Telangana");
		getObject("logLink").click();
		getObject("regSignUp").click();
		getObject("regName").sendKeys("Name");
		getObject("regEmail").sendKeys("EmailAddress");
		getObject("regMobile").sendKeys("Mobile");
		getObject("regPassword").sendKeys("Password");
		getObject("regConfPass").sendKeys("ConfirmPass");
		getObject("regSignUpButton").click();
		
		
	}
	
@DataProvider
	public String [][] getData(){
		return TestUtil.getTestData(usedcarsxls, "UsedCarValuation");
	}
}
