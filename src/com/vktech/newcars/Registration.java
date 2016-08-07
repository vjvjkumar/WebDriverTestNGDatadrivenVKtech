package com.vktech.newcars;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vktech.util.TestUtil;

public class Registration extends TestSuiteBase {
	
	static int count= -1;
	
@BeforeTest
	public void checkTestCaseSkip(){
		if (!TestUtil.isTestCaseRunnable(newcarsxls, "Registration")){
		throw new SkipException("Runmode of Registration testcase is set as NO, then skipping Registration testcase");
		}
		runmodes = TestUtil.getTestDataRunmodes(newcarsxls, "Registration"); 	
		}
	
@Test (dataProvider="getData")
	public void registration(String Name, String EmailAddress, String Mobile, String Password, String ConfirmPass){
		count++;
		if(!runmodes[count].equalsIgnoreCase("Y")){
		throw new SkipException("Runmode of testdata is set as NO, then skipping Rownumber  "+ (count+1));
		}
		
	// Executing testcase
		System.out.println("Executing testcase Registration with parameters: "+Name+"  "+EmailAddress+"  "+Password+"  "+ConfirmPass);	
	// Webdriver code
		OpenBrowser();
		
		driver.get(CONFIG.getProperty("baseurl"));
		getObject("logLocation").sendKeys("Hyderabad Central, Hyderabad, Telangana");
		getObject("logLink").click();
		getObject("regSignUp").click();
		getObject("regName").sendKeys(Name);
		getObject("regEmail").sendKeys(EmailAddress);
		getObject("regMobile").sendKeys(Mobile);
		getObject("regPass").sendKeys(Password);
		getObject("regConfPass").sendKeys(ConfirmPass);
		getObject("regSignUpButton").click();
		
		CloseBrowser();
		
	}
	
@DataProvider
	public String [][] getData(){
		return TestUtil.getTestData(newcarsxls, "Registration");
	}

}
